/*

This design pattern is useful in building a family of algorithms and can be used to alter the application without having to change the
whole architecture.

*/


import java.util.*;
import java.lang.*;
import java.io.*;

interface Kick{
    public void kick();
}

class Lightining implements Kick{
    @Override
    public void kick(){
        System.out.println("Lightining kick");
    }
}

class Tornado implements Kick{
    @Override
    public void kick(){
        System.out.println("Tornado kick");
    }
}

abstract class Fighter{
    Kick kickbehaviour;
    
    public Fighter(Kick k){
        this.kickbehaviour = k;
    }
    
    public void setkick(Kick k){
        this.kickbehaviour = k;
    }
    

    public void getPunch(){
        System.out.println("Default punch");
    }
    
    public void getRoll(){
        System.out.println("Default roll");
    }
}

class Ryu extends Fighter{
   public Ryu(Kick k){
       super(k);
   }
   
}

class Ken extends Fighter{
    public Ken(Kick k){
       super(k);
   }
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Kick k = new Tornado();
		Fighter f1 = new Ryu(k);
		Fighter f2 = new Ken(k);
		f1.kickbehaviour.kick();
		f1.getPunch();
		f1.getRoll();
		f1.setkick(new Lightining());
		f1.kickbehaviour.kick();
		
		
		f2.kickbehaviour.kick();
		f2.getPunch();
		f2.getRoll();
		
	}
}
