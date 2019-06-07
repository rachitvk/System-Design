import java.util.*;
import java.lang.*;
import java.io.*;


class PMO{
    String name;
    int age;
    
    public static PMO p;
    
    private PMO(){}
    
    public static PMO getInstance(){
        if(p == null)
            p = new PMO();
        return p;
    }
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//PMO p = new PMO();
		PMO p = PMO.getInstance();
		p.name = "MODI";
		p.age = 68;
		
		System.out.println(p.name+" "+p.age);
	}
}
