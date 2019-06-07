/* 

Main aim of the factory pattern is that the client and the server should be decoupled. Any changes on the server side should not affect
the client and it need not be recompiled. 

In this example,student is the client and Grading system is the server side. Grade is calculated on the server side and if tomorrow there's
some change in the grading system, the Student side remains unaffected, thus ensuring the decoupling of the two.

*/


import java.util.*;
import java.lang.*;
import java.io.*;

class Grade{
    
    char grade;
    
    public Grade(int marks){
        if(marks > 90)
            grade = 'A';
        else if(marks > 80)
            grade = 'B';
        else if(marks > 70)
            grade = 'C';
        else
            grade = 'D';
    }
}


class Student{
    String name;
    int roll;
    char grade;
    
    public Student(String name,int roll,int marks){
        this.name = name;
        this.roll = roll;
        Grade g = new Grade(marks);
        grade = g.grade;
    }
}

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Student s1 = new Student("Rachit",1,92);
	    Student s2 = new Student("Rohan",2,82);
	   
	   System.out.println(s1.name+" "+s1.roll+" "+s1.grade);
	   System.out.println(s2.name+" "+s2.roll+" "+s2.grade);
	    
	}
}
