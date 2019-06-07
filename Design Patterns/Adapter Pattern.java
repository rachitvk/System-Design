import java.util.*;
import java.lang.*;
import java.io.*;

interface Cricketer{
    public void run();
}

interface Footballer{
    public void sprint();
}

class Player implements Cricketer{
    public void run(){
        System.out.println("Player is running in cricket...");
    }
}

class player implements Footballer{
    public void sprint(){
        System.out.println("Player is running in football...");
    }
}

class Adapter implements Footballer{
    
    Cricketer c;
    
    public Adapter(Cricketer c){
        this.c = c;
    }
    
    public void sprint(){
        c.run();
    }    
}


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Cricketer c = new Player();
	    c.run();
	    
	    Footballer f = new player();
	    f.sprint();
	    
	    f = new Adapter(c);
	    f.sprint();
	}
}
