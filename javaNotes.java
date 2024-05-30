//a. Java Program to illustrate how to define a class and fields  
class Student{ 
 int id;
 String name;  
 public static void main(String args[]){  
  Student s1=new Student();  
  System.out.println(s1.id);
  System.out.println(s1.name);  
 }  
} 

// b. Java Program to demonstrate having the main method in    
class Student{  
 int id;  
 String name;  
}  

class TestStudent1{  
 public static void main(String args[]){  
  Student s1=new Student();  
  System.out.println(s1.id);  
  System.out.println(s1.name);  
 }  
} 

// ----------------------------- Initializing Objects ----------------------------------------------------------- //
class Student{  
 int id;  
 String name;  
 
  // setter
  void insertRecord(int r, String n){  
	  rollno=r;  
	  name=n;  
  } 
  
  // getter
  void displayInformation(){System.out.println(rollno+" "+name);} 
  
  // constructors
  public Student(String stuName){
	  this.name = stuName;
  }
}  

class TestStudent3{  
 public static void main(String args[]){   
  Student s1=new Student();  
  
  // By reference variables
  s1.id=101;  
  s1.name="Sonoo";  
  System.out.println(s1.id+" "+s1.name);  
  System.out.println(s2.id+" "+s2.name);  
  
  // By methods (setters and getters)
  s1.insertRecord(101,"Sonoo");
  s1.displayInformation();
  
  // By constructors
  Student s1 = new Student("Geethya");

 }  
} 

// ----------------------------- Anoynymous Objects ----------------------------------------------------------- //
class Calculation{  
	void fact(int  n){  
		int fact=1;  
		for(int i=1;i<=n;i++){  
		fact=fact*i;  
		}  
		System.out.println("factorial is "+fact);  
	}  
	
	public static void main(String args[]){  
	 new Calculation().fact(5);//calling method with anonymous object  
	}  
}  

// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// a. How a run-time system searches for appropriate exception handling code on the call stack

class GFG { 

	// Method 1 
	// It throws the Exception(ArithmeticException). 
	// Appropriate Exception handler is not found 
	// within this method. 
	static int divideByZero(int a, int b) 
	{ 

		// this statement will cause ArithmeticException 
		// (/by zero) 
		int i = a / b; 

		return i; 
	} 

	// The runTime System searches the appropriate 
	// Exception handler in method also but couldn't have 
	// found. So looking forward on the call stack 
	static int computeDivision(int a, int b) 
	{ 

		int res = 0; 

		// Try block to check for exceptions 
		try { 

			res = divideByZero(a, b); 
		} 

		// Catch block to handle NumberFormatException 
		// exception Doesn't matches with 
		// ArithmeticException 
		catch (NumberFormatException ex) { 
			// Display message when exception occurs 
			System.out.println( 
				"NumberFormatException is occurred"); 
		} 
		return res; 
	} 

	// Method 2 
	// Found appropriate Exception handler. 
	// i.e. matching catch block. 
	public static void main(String args[]) 
	{ 

		int a = 1; 
		int b = 0; 

		// Try block to check for exceptions 
		try { 
			int i = computeDivision(a, b); 
		} 

		// Catch block to handle ArithmeticException 
		// exceptions 
		catch (ArithmeticException ex) { 

			// getMessage() will print description 
			// of exception(here / by zero) 
			System.out.println(ex.getMessage()); 
		} 
	} 
}


// b. throw keyword [ output --> Excep found: ... ]
class Test{ 
	static void avg(){
		try {
			throw new ArithmeticException("Demo");
		}
		catch(ArithmeticException e) {
			sout("Excep found: " + e);
		}
	}

	public static void main(String args[]){  
	  avg();
	}  
} 

// c. throws keyword [ output --> inside avg meth    |  except resolved   | finally ]
class Test{ 
	static void avg() throws ArithmeticException {
		sout("inside avg meth");
		throw new ArithmeticException("Demo");
	}

	public static void main(String args[]){  
		try{
			avg();
		}
		catch (ArithmeticException e) {
			sout("except resolved");
		}
		finally {
			sout("finally");
		}
	}  
} 

// d. User defined exceptions
// error obj details thrown by e obj
// User with ID 456 not found.

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        try {
            String result = userManager.findUser("456"); // This ID does not exist
            System.out.println(result);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class UserManager {
    public String findUser(String userId) throws UserNotFoundException {
        if (!"123".equals(userId)) {
            throw new UserNotFoundException("User with ID " + userId + " not found.");
        }
        return "User found: User ID " + userId;
    }
}

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}


// ----------------------------- Methods to create objects ----------------------------------------------------------- //
// a. Using 'new key word'
class Student {
    int id;
    String name;
 
    public static void main(String args[])
    {
        Student s1 = new Student();
        System.out.println(s1.id);
    }
}

/* 
In Java, new is an operator where newInstance() is a method where both are used for object creation. 
If we know the type of object to be created then we can use a new operator.
But if we do not know the type of object to be created in beginning and is passed at runtime, the newInstance() method is used.
*/

// b. Using 'new Instance' ---> [Object created for class:A]
class A {
	int a;
}

public class GFG {
	// To create an instance of class whose name is
	// passed as a string 'c'.
	public static void fun(String c)
		throws InstantiationException,
			IllegalAccessException,
			ClassNotFoundException
	{

		// Creating an object of type 'c'
		Object obj = Class.forName(c).newInstance();

		// Printing the type of object created
		System.out.println("Object created for class:"
						+ obj.getClass().getName());
	}

	// Main driver method
	public static void main(String[] args)
		throws InstantiationException,
			IllegalAccessException,
			ClassNotFoundException
	{
		// Calling above method over "A"
		fun("A");
	}
}

// c. Using clone() method - Implementing Cloneable interface
class GFG implements Cloneable {
    @Override
    protected Object clone()
        throws CloneNotSupportedException
    {
        // Super() keyword refers to parent class
        return super.clone();
    }
    String name = "GeeksForGeeks";

    public static void main(String[] args)
    {
        GFG obj1 = new GFG();
        try {
            GFG obj2 = (GFG)obj1.clone();
            System.out.println(obj2.name);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

// d. Deserialization [De-serialization is a technique of reading an object from the saved state in a file.]
FileInputStream file = new FileInputStream(filename);
ObjectInputStream in = new ObjectInputStream(file);
Object obj = in.readObject();


// ----------------------------- Interfaces ----------------------------------------------------------- //
// A class which implements an interface should implement ALL of the interface's abstract methods

// a. A simple interface
interface Player
{
    final int id = 10;
    int move();
}

// b. Java program to demonstrate the real-world example of Interfaces (Car, Bycicle are both vehicles and display similar behaviours and consist common functionalities)

import java.io.*;
interface Vehicle {
    
    // all are the abstract methods.
    void changeGear(int a);
    void speedUp(int a);
    void applyBrakes(int a);
}

class Bicycle implements Vehicle{
    
    int speed;
    int gear;
    
    @Override
    public void changeGear(int newGear){ 
        gear = newGear;
    }
    
    @Override
    public void speedUp(int increment){
        speed = speed + increment;
    }
    
    @Override
    public void applyBrakes(int decrement){      
        speed = speed - decrement;
    }
    
    public void printStates() {
        System.out.println("speed: " + speed
            + " gear: " + gear);
    }
}

class GFG {
    
    public static void main (String[] args) {
    
        // creating an instance of Bicycle doing some operations
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);
        
        System.out.println("Bicycle present state :");
        bicycle.printStates();
    }
}

// c. Multiple Inheritance (Java program to demonstrate How Diamond Problem is Handled in case of Default Methods)

// Interface 1
interface API {
    // Default method
    default void show()
    {
        System.out.println("Default API");
    }
}

// Interface 2
// Extending the above interface
interface Interface1 extends API {
    void display();
}

// Interface 3
interface Interface2 extends API {
    void print();
}

class TestClass implements Interface1, Interface2 {
    public void display()
    {
        System.out.println("Display from Interface1");
    }

    public void print()
    {
        System.out.println("Print from Interface2");
    }

    public static void main(String args[])
    {
        TestClass d = new TestClass();

        // Now calling the methods from both the interfaces
        d.show(); // Default method from API
        d.display(); // Overridden method from Interface1
        d.print(); // Overridden method from Interface2
    }
}

// d. JDK 8 Updates
	//	1. Usage of default methods 
	/* Prior to JDK 8, the interface could not define the implementation. We can now add default implementation for interface methods.
     Suppose we need to add a new function to an existing interface. Obviously, the old code will not work as the classes have not implemented those new functions. 
	 So with the help of default implementation, we will give a default body for the newly added functions. Then the old codes will still work.*/
	 
	// 2. Static methods in interfaces that can be called independently without an object
	interface In1
	{
		final int a = 10;
		static void display()
		{
			System.out.println("hello");
		}
	}

	class TestClass implements In1
	{
		public static void main (String[] args)
		{
			In1.display();
		}
	}
	
// e. Extending Interfaces
// When a class implements an interface that inherits another interface, it must provide an implementation for all methods required by the interface inheritance chain.
interface A {
    void method1();
    void method2();
}

interface B extends A {
    void method3();
}
// the class must implement all method of A and B.
class gfg implements B {
    public void method1()
    {
        System.out.println("Method 1");
    }
    public void method2()
    {
        System.out.println("Method 2");
    }
    public void method3()
    {
        System.out.println("Method 3");
    }
}

// f. Interfaces, Abstract Classes and Implementation Classes
/* 
In general, the development process is step by step. If a class cant implement ALL methods in the extended interface, make that class abstract and do partial implementation.
It is possible to declare multiple child classes but at final, we have to complet the implementation of ALL abstract methods.
Level 1 – interfaces: It contains the service details.
Level 2 – abstract classes: It contains partial implementation.
Level 3 – implementation classes: It contains all implementations.
Level 4 – Final Code / Main Method: It have access of all interfaces data.
*/

	// Java Program for implementation Level wise
	import java.io.*;
	import java.lang.*;
	import java.util.*;

	// Level 1
	interface Bank {
		void deposit();
		void withdraw();
		void loan();
		void account();
	}

	// Level 2
	abstract class Dev1 implements Bank {
		public void deposit()
		{
			System.out.println("Your deposit Amount :" + 100);
		}
	}

	abstract class Dev2 extends Dev1 {
		public void withdraw()
		{
			System.out.println("Your withdraw Amount :" + 50);
		}
	}

	// Level 3
	class Dev3 extends Dev2 {
		public void loan() {}
		public void account() {}
	}

	// Level 4
	class GFG {
		public static void main(String[] args)
		{
			Dev3 d = new Dev3();
			d.account();
			d.loan();
			d.deposit();
			d.withdraw();
		}
	}

/* g. JDK 9
	1. Static methods
	2. Private methods
	3. Private Static methods 
*/


// ----------------------------- OOP - Inheritance ----------------------------------------------------------- //



// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //
// ----------------------------- Exceptions and Errors ----------------------------------------------------------- //


// ----------------------------- Random ----------------------------------------------------------- //
/* a. Using a parent class reference variable to store a sub-class object. 
In this case, we can switch into different subclass objects using the same referenced variable. 
*/
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
public class Test
{
    // using Dog object
    Animal obj = new Dog();
    // using Cat object
    obj = new Cat();
}
