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
