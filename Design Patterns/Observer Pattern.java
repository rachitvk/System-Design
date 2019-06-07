import java.util.ArrayList; 
import java.util.Iterator; 


interface subject{
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}

interface Observer{
    public void updateChange(int runs,int wickets,float overs);
}

class CricketData implements subject{
    int runs,wickets;
    float overs;
    ArrayList<Observer> observerlist;
    
    public CricketData(){
        observerlist = new ArrayList<Observer>();
    }
    
    @Override
    public void addObserver(Observer o){
        observerlist.add(o);
    }
    
    @Override
    public void removeObserver(Observer o){
        observerlist.remove(observerlist.indexOf(o));
    }
    
    @Override
    public void notifyObserver(){
        for(Iterator<Observer> it = observerlist.iterator();it.hasNext();){
            Observer o = it.next();
            o.updateChange(runs,wickets,overs);
        }        
    }
    
    public int getLatestRuns(){
        return 100;
    }
    
    public int getLatestWickets(){
        return 2;
    }
    
    public float getLatestOvers(){
        return (float)10;
    }
    
    public void dataChange(){
        this.runs = getLatestRuns();
        this.wickets = getLatestWickets();
        this.overs = getLatestOvers();
        
        notifyObserver();
    }
}


class AverageScore implements Observer{
    float runrate;
    int PredictedScore;
    
    @Override
    public void updateChange(int runs,int wickets,float overs){
        this.runrate = (float)runs/overs;
        this.PredictedScore = (int)runrate * 50;
        display();
    }
    
    public void display(){
        System.out.println("Average Score Display :");
        System.out.println("Current Run Rate : "+runrate);
        System.out.println("Predicted Score : "+PredictedScore);
    }
}


class CurrentScore implements Observer{
    int runs,wickets;
    float overs;
    
    @Override
    public void updateChange(int runs,int wickets,float overs){
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        
        display();
    }
    
    public void display(){
        System.out.println("Current Score Display :");
        System.out.println("Runs : "+runs);
        System.out.println("Wickets : "+wickets);
        System.out.println("Overs :"+overs);
    }
}

class Main{
    public static void main(String args[]){
        AverageScore o1 = new AverageScore();
        CurrentScore o2 = new CurrentScore();
        
        CricketData c1 = new CricketData();
        c1.addObserver(o1);
        c1.addObserver(o2);
        
        c1.dataChange();
        
        
    }
}