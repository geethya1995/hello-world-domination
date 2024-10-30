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


// ----------------------------- Creating Multiple Objects by One Type Only -----------------------------//
// 1. Primitive types
int a=10, b=20; 

// 2. Objects initialize
Rectangle r1=new Rectangle(), r2=new Rectangle();

 
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
// This allocates memory for the object and calls its constructor to initialize it.
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
// Objects can be created by deserializing them from a stream of bytes. This is achieved using the ObjectInputStream class in Java. The serialized object is read from a file or network, and then the readObject() method is called to recreate the object.
FileInputStream file = new FileInputStream(filename);
ObjectInputStream in = new ObjectInputStream(file);
Object obj = in.readObject();

// e. By factory method
/* Factory methods are static methods within a class that return instances of the class. They provide a way to create objects without directly invoking a constructor and can be used to encapsulate object creation logic.
*/
ClassName obj = ClassName.createInstance()


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
class Subclass-name extends Superclass-name  
{  
   //methods and fields  
} 

class Employee{  
	float salary=40000;  
}  
class Programmer extends Employee{  
	int bonus=10000;  
	public static void main(String args[]){  
		Programmer p=new Programmer();  
		System.out.println("Programmer salary is:"+p.salary);  
		System.out.println("Bonus of Programmer is:"+p.bonus);  
	}  
}  
// Programmer salary is:40000.0
// Bonus of programmer is:10000

/* Why multiple inheritance is not supported in Java?
	- If A and B classes have the same method and we call it from child class object, there will be ambiguity to call the method of A or B class.
	- Since compile-time errors are better than runtime errors, Java renders compile-time error if you inherit 2 classes.
*/
class A{  
	void msg(){System.out.println("Hello");}  
} 
 
class B{  
	void msg(){System.out.println("Welcome");}  
} 
 
class C extends A,B{//suppose if it were  
   
	public static void main(String args[]){  
	   C obj=new C();  
	   obj.msg();//Now which msg() method would be invoked?  
	}  
}  

// Multiple inheritance via interfaces
interface A {  
    default void methodA() {  
        System.out.println("Method A from interface A");  
    }  
}  

interface B {  
    default void methodB() {  
        System.out.println("Method B from interface B");  
    }  
}  
 
class MyClass implements A, B {  
    public void myMethod() {  
        System.out.println("My method in MyClass");  
    }  
}
 
public class MultipleInheritanceDemo {  
    public static void main(String[] args) {  
        MyClass obj = new MyClass();  

        obj.methodA();  
        obj.methodB();  
        obj.myMethod();  
    }  
}  

/* Even if you have same methods in interfaces, no prob during multiple inheritance.
When both interfaces define the same method (same name and parameters), there is no ambiguity because they don’t contain any actual implementation (just the method signature).

How to resolve this issue when both interfaces have default methods with same signature:
1. Override the method in the implementing class
2. Explicitly call the default implementation from one of the interfaces

Solution 2 can be seen below.
*/
interface InterfaceA {
    default void display() {
        System.out.println("Display from InterfaceA");
    }
}

interface InterfaceB {
    default void display() {
        System.out.println("Display from InterfaceB");
    }
}

class MyClass implements InterfaceA, InterfaceB {
    @Override
    public void display() {
        // Resolve the conflict by choosing a specific implementation
        InterfaceA.super.display();
        // Or you can choose InterfaceB.super.display();
    }
}

// Example code for Composition
/* Composition in Java is a design principle where one class contains an instance of another class to reuse its functionality, rather than inheriting from it. This creates a "has-a" relationship rather than an "is-a" relationship, which is what inheritance typically represents.
*/
class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Transmission {
    public void engage() {
        System.out.println("Transmission engaged.");
    }
}

class Car {
    private Engine engine;
    private Transmission transmission;

    // Constructor to initialize components
    public Car() {
        this.engine = new Engine();
        this.transmission = new Transmission();
    }

    public void drive() {
        engine.start();
        transmission.engage();
        System.out.println("Car is moving!");
    }
}


// ----------------------------- OOP - Polymorphism ----------------------------------------------------------- //
// Compile-time Polymorphism (8, 6.2)
class Calculation {  
    int add(int a, int b) {  
        return a + b;  
    }  
    double add(double a, double b) {  
        return a + b;  
    }  
}  
public class CompileTimePolymorphism {  
    public static void main(String[] args) {  
        Calculation calc = new Calculation();  
        // Compile-time polymorphism: selecting the appropriate add method based on parameter types  
        System.out.println("Sum of integers: " + calc.add(5, 3));  
        System.out.println("Sum of doubles: " + calc.add(2.5, 3.7));  
    }  
}  


// Runtime Polymorphism in Java (Dynamic Method Dispatch)
/* Splendor class extends Bike class and overrides its run() method. We are calling the run method by the reference variable of Parent class. Since it refers to the subclass object and subclass method overrides the Parent class method, the subclass method is invoked at runtime.

Output: running safely with 60km.

Therefore, the JVM determines which method to call based on the actual object type at runtime.
*/
class Bike{  
  void run(){System.out.println("running");}  
}  
class Splendor extends Bike{  
  // override
  void run(){System.out.println("running safely with 60km");}  
  
  public static void main(String args[]){  
    Bike b = new Splendor();//upcasting  
    b.run();  
  }  
}  

// Real life example ------
class Bank{  
float getRateOfInterest(){return 0;}  
}  
class A extends Bank{  
float getRateOfInterest(){return 8.4f;}  
}  
class B extends Bank{  
float getRateOfInterest(){return 7.3f;}  
}  
class C extends Bank{  
float getRateOfInterest(){return 9.7f;}  
}  
class TestPolymorphism{  
	public static void main(String args[]){  
		Bank b;  
		b=new A();  
		System.out.println("A: Rate of Interest: "+b.getRateOfInterest());  
		b=new B();  
		System.out.println("B: Rate of Interest: "+b.getRateOfInterest());  
		b=new C();  
		System.out.println("C: Rate of Interest: "+b.getRateOfInterest());  
	}  
}  

// Java Runtime Polymorphism with Data Member
/* A method is overridden, not the data members, so runtime polymorphism can't be achieved by data members. 
*/
class Bike{  
 int speedlimit=90;  
}  
class Honda3 extends Bike{  
 int speedlimit=150;  
  
 public static void main(String args[]){  
  Bike obj=new Honda3();  
  System.out.println(obj.speedlimit);//90  
}  

// Java Runtime Polymorphism with Multilevel Inheritance
// Example 1
class Animal{  
	void eat(){System.out.println("eating");}  
}  
class Dog extends Animal{  
	void eat(){System.out.println("eating fruits");}  
}  
class BabyDog extends Dog{  
	void eat(){System.out.println("drinking milk");}  
	public static void main(String args[]){  
		Animal a1,a2,a3;  
		a1=new Animal();  
		a2=new Dog();  
		a3=new BabyDog();  
		a1.eat();  // eating
		a2.eat();  // eating fruits
		a3.eat();  // drinking milk
	}  
}

// Example 2
class Animal{  
	void eat(){System.out.println("animal is eating...");}  
}  
class Dog extends Animal{  
	void eat(){System.out.println("dog is eating...");}  
}  
class BabyDog1 extends Dog{  
	public static void main(String args[]){  
		Animal a=new BabyDog1();  
		a.eat();  // dog is eating...
	}
} 


// ----------------------------- OOP - Abstraction ----------------------------------------------------------- //
// Data Abstraction
/* Data abstraction hides the implementation details of data and shows only essential features or relevant data to the user. 

Here, Car hides complex data handling from the user such as fuel injection, engine temperature, or sensor readings, focusing only on data relevant to the user, like speed and fuelLevel.
*/
class Car {
    private int speed;
    private int fuelLevel;

    public int getSpeed() { // Only relevant info is shown
        return speed;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }
}

// Control Abstraction
/* Hides the flow of control (like loops, conditionals) and provides a simpler interface for performing operations.

Example: Sort class that offers a sortArray() method. The user doesn't need to know if it uses Quick Sort, Merge Sort, etc.; they only need to call sortArray() to sort the data.
*/
class Sort {
    public void sortArray(int[] array) {
        // Internally it may use any algorithm (like Quick Sort or Merge Sort)
        Arrays.sort(array); // Hides the sorting mechanism
    }
}

// Examples codes of Abs Classes
// Code 1:
abstract class Car{  
    abstract void accelerate();  
}  
//concrete class
class Suzuki extends Car{  
    void accelerate(){
        System.out.println("Suzuki::accelerate");
     
    }
}
class Main{
    public static void main(String args[]){  
        Car obj = new Suzuki();    //Car object =>contents of Suzuki
        obj.accelerate();          //Suzuki::accelerate 
    }   
}  

// Certain other keywords should not be used with the abstract keyword when writing abs methods (final, abstract native, abstract static, abstract private, abstract synchronized, abstract strictfp)

// Which to choose? Abstract classes or Interfaces?
/* 
consider that we are designing a web application. For this, we will have to use some web technology like Servlet, REST API, etc. Now each of these web technologies has some techniques or steps that are to be implemented irrespective of the application that we are developing. Then we build our customized application.

So in this case, the definite code that the web technology has to execute can be put in an abstract class. Can we have an interface for this? No. This is because the interface cannot have an implementation.

------
Now consider the Map interface of Java Collections Framework. Many classes like HashMap, TreeMap, HashTable, etc. implement this interface. Each of these classes has a different implementation. They do not have any common behavior that can be represented in the abstract class.

So what we do is we design an interface with method prototypes and then implement each of the classes.
*/

// ----------------------------- OOP - Encapsulation ----------------------------------------------------------- //
/* We bundled these fields and methods inside a single class.

Here, the fields and methods can be accessed from other classes as well. Hence, this is not data hiding.

This is only encapsulation.

If we change the length and breadth variable into private, then the access to these fields is restricted.

And, they are kept hidden from outer classes. This is called data hiding.
*/
class Area {

  // fields to calculate area
  int length;
  int breadth;

  // constructor to initialize values
  Area(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  // method to calculate area
  public void getArea() {
    int area = length * breadth;
    System.out.println("Area: " + area);
  }
}

class Main {
  public static void main(String[] args) {
    Area rectangle = new Area(5, 6);
    rectangle.getArea();
  }
}

// Uses: Encapsulation helps to control the values of our data fields. Here, age cant be negative
class Person {
  private int age;

  // SETTER 
  public void setAge(int age) {
    if (age >= 0) {
      this.age = age;
    }
  }
}

// Uses: Data Hiding (To restrict the access of our data members by hiding the implementation details using access modifiers)
/* Making age private allowed us to restrict unauthorized access from outside the class. This is data hiding. In order to access age, we have used public methods: getAge() and setAge()

error: age has private access in Person
p1.age = 24;
*/
class Person {

  // private field
  private int age;

  // getter method
  public int getAge() {
    return age;
  }

  // setter method
  public void setAge(int age) {
    this.age = age;
  }
}

class Main {
  public static void main(String[] args) {

    // create an object of Person
    Person p1 = new Person();

    // change age using setter
    p1.setAge(24);

    // access age using getter
    System.out.println("My age is " + p1.getAge());
  }
}


// ----------------------------- OOP - Association ----------------------------------------------------------- //
// A person can have many mobile numbers, so it defines the one-to-many relationship.
class Mobile {    
    private String mobile_no;  
    
    public String getMobileNo() {  
        return mobile_no;  
    }  
    public void setMobileNo(String mobile_no) {  
        this.mobile_no = mobile_no;  
    }  
} 
 
class Person {       
    private String name;  
    List<Mobile> numbers;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public List<Mobile> getNumbers() {  
        return numbers;  
    }  
    public void setNumbers(List<Mobile> numbers) {  
        this.numbers = numbers;  
    }  
}  

public class AssociationExample {  
    public static void main(String[] args) {  
		Person person = new Person();  
		person.setName("Shubham Rastogi");  
		 
		Mobile number1 = new Mobile();  
		number1.setMobileNo("8868923136");  
		Mobile number2 = new Mobile();  
		number2.setMobileNo("8630023310");  
  
		List<Mobile> numberList = new ArrayList<Mobile>();  
		numberList.add(number1);  
		numberList.add(number2);  
		person.setNumbers(numberList);  
		System.out.println(person.getNumbers()+" are mobile numbers of the person "+ person.getName()); 
    }  
        
}  

// Aggregation Example 
class Student    
{   
    String name;   
    int enrol ;   
    String course;   
        
    Student(String name, int enrol, String course)    
    {               
        this.name = name;   
        this.enrol = enrol;   
        this.course = course;   
    }   
}   
    
// Course class having a list of students.  
class course    
{        
    String name;   
    private List<Student> students;   
    Course(String name, List<Student> students)    
    {       
        this.name = name;   
        this.students = students;          
    }        
    public List<Student> studentsData()    
    {   
        return students;   
    }   
}   
    
/* College class having a list of Courses*/  
class College  
{           
    String collegeName;   
    private List<Course> courses;   
        
    College(String collegeName, List<Course> courses)   
    {   
        this.collegeName = collegeName;   
        this.courses = courses;   
    }   
        
    // Returning number of students available in all courses in a given college    
    public int countStudents()   
    {   
        int studentsInCollege = 0;   
        List<Student> students;    
        for(Course course : courses)   
        {   
            students = course.studentsData();   
            for(Student s : students)   
            {   
                studentsInCollege++;   
            }   
        }   
        return studentsInCollege;   
    }          
}    
    
class AggregationExample  
{   
    public static void main (String[] args)    
    {   
        Student std1 = new Student("Emma", 1801, "MCA");   
        Student std2 = new Student("Adele", 1802, "BSC-CS");   
        Student std3 = new Student("Aria", 1803, "Poly");   
        Student std4 = new Student("Ally", 1804, "MCA");   
        Student std5 = new Student("Paul", 1805, "Poly");         
          
        // Constructing list of MCA Students.   
        List <Student> mca_students = new ArrayList<Student>();   
        mca_students.add(std1);   
        mca_students.add(std4);   
            
        //Constructing list of BSC-CS Students.   
        List <Student> bsc_cs_students = new ArrayList<Student>();   
        bsc_cs_students.add(std2);   
          
        //Constructing list of Poly Students.   
        List <Student> poly_students = new ArrayList<Student>();   
        poly_students.add(std3);   
        poly_students.add(std5);   
            
        Course MCA = new Course("MCA", mca_students);   
        Course BSC_CS = new Course("BSC-CS", bsc_cs_students);  
        Course Poly = new Course("Poly", poly_students);   
            
        List <Course> courses = new ArrayList<Course>();   
        courses.add(MCA);   
        courses.add(BSC_CS);  
        courses.add(Poly);   
            
        // creating object of College.   
        College college = new College("ABES", courses);   
          
        System.out.print("Total number of students in the college "+ college.collegeName +" is "+ college.countStudents());  
    }   
}  


// ----------------------------- OOP - Composition ----------------------------------------------------------- //
/*
we create a class Book that contains data members like author, and title and create another class Library that has a reference to refer to the list of books. A library can have no. of books on the same or different subjects. So, If the Library gets destroyed then All books within that particular library will be destroyed. i.e., books can not exist without a library. The relationship between the library and books is composition.
*/
class Book {

	// Member variables of this class
	public String title;
	public String author;

	// Constructor of this class
	Book(String title, String author)
	{

		// This keyword refers top current instance
		this.title = title;
		this.author = author;
	}
}

// Library class contains list of books.
class Library {

	// Reference to refer to list of books.
	private final List<Book> books;

	// Constructor of this class
	Library(List<Book> books)
	{
		this.books = books;
	}
	
	// Getting the list of books
	public List<Book> getListOfBooksInLibrary()
	{
		return books;
	}
}

class GFG {
	public static void main(String[] args)
	{
		Book b1 = new Book("EffectiveJ Java", "Joshua Bloch");
		Book b2 = new Book("Thinking in Java", "Bruce Eckel");
		Book b3 = new Book("Java: The Complete Reference", "Herbert Schildt");

		List<Book> book = new ArrayList<Book>();
		book.add(b1);
		book.add(b2);
		book.add(b3);

		Library library = new Library(book);

		List<Book> books = library.getListOfBooksInLibrary();
		for (Book bk : books) {
			System.out.println("Title : " + bk.title
							+ " and "
							+ " Author : " + bk.author);
		}
	}
}




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
