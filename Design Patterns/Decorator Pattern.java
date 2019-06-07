/*

1) Offers pay as you go approach. Affect the behaviour of the object at runtime.
2) Used to extend the functionalities of the object at runtime and can be thought of as an alternative to  subclassing

*/ 




import java.util.*;
import java.lang.*;
import java.io.*;

abstract class Pizza{
    String description = "Unknown";
    
    abstract public int getcost();
    public String getdescription(){return description;}
}

class Farmhouse extends Pizza{

    public Farmhouse(){description = "Farmhouse";}
    public int getcost(){return 100;}
    public String getdescription(){return description;}
    
}


class Margherita extends Pizza{

    public Margherita(){description = "Margherita";}
    public int getcost(){return 90;}
    public String getdescription(){return description;}
    
}

abstract class Toppings extends Pizza{
    abstract public String getdescription();
}

class Cheese extends Toppings{
    Pizza p;
    
    public Cheese(Pizza p){this.p = p;}
    public int getcost(){return p.getcost()+30;}
    public String getdescription(){return p.getdescription()+",Cheese";}
}

class Mayo extends Toppings{
    Pizza p;
    
    public Mayo(Pizza p){this.p = p;}
    public int getcost(){return p.getcost()+10;}
    public String getdescription(){return p.getdescription()+",Mayo";}
}


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Pizza p1 = new Farmhouse();
		System.out.println(p1.getdescription()+" "+p1.getcost());
		
		Pizza p2 = new Margherita();
		p2 = new Cheese(p2);
		System.out.println(p2.getdescription()+" "+p2.getcost());
	}
}
