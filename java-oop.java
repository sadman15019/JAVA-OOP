// Online Java Compiler
// Use this editor to write, compile and run your Java code online
class Student
{
    int roll;
    String name;
    double cgpa;
    //default constructor
    Student()
    {
        roll=20;
        name="sadman";
        cgpa=3.73;  
    }
    
    //parametarized constructor
    
    Student(int roll, String name ,double cgpa)
    {
        this.roll=roll; // this.roll refers to class variable, roll refers to paramter for this constructor
        this.name=name;
        this.cgpa=cgpa;
    }
     //copy constructor
    
    Student( Student x)
    {
        this.roll=x.roll;
        this.name=x.name;
        this.cgpa=x.cgpa;
    }
}
public class Main
{
    public static void main(String[] args)
    {
       Student s1= new Student(21,"asdasd",435.4);
       System.out.println(s1.name);
    }
}



// Abstract class
abstract class Animal {  //cannot be instantiated directly without subclass, gives error
  // Abstract method (does not have a body)
  public abstract void Sound();
  // Regular method
  public void sleep() {  //default access specifier is private if public is not mentioed
    System.out.println("Zzz");
  }
}

// Subclass (inherit from Animal)
class Cow extends Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The cow says: mooooooo");
  }
}

public class Main {
  public static void main(String[] args) {
    Cow mycow = new Cow(); // Create a Cow object by invisible default constructor
    mycow.Sound();
    mycow.sleep();
  }
}

/*************  POLYMORPHISM  ********************/

class Animal {
  public void animalSound() {
    System.out.println("The animal makes a sound");
  }
}

class Pig extends Animal {
  public void animalSound() {
    System.out.println("The pig says: wee wee");  //function overriding, runtime polymorphism
  }
}

class Dog extends Animal {
  public int a;
  public void animalSound() {
    System.out.println("The dog says: bow wow");  //function overriding, runtime polymorphism
  }
  public static void a(){
   System.out.println("aaaaa");
  }
}

class Main {
  public static void main(String[] args) {
    Animal myAnimal = new Animal();
    Animal myPig = new Pig();   //super class instance point to subclass ,can only access all the inherited member variables and methods 
    Animal myDog = new Dog();   //super class instance point to subclass ,can only access all the inherited member variables and methods 
    Dog d1=new Dog();  
    d1.a=10;    // memeber class variable,not inherited       
    myDog.a=10; // "Gives Error" as myDog is an instance of animal class, cannot access member variables that are not inherited from Animal class
    System.out.println(myDog.a);  // "Gives error"
        
    myAnimal.animalSound();  //The animal makes a sound"
    myPig.animalSound();    //The pig says: wee wee"
    myDog.animalSound();    //The dog says: bow wow"
    d1.animalSound();     //The dog says: bow wow"
  }
}


Static Method and variables is shared by all instance of a class, thats why it can be accessed without creating an objects
public class Main {
  // Static method
  static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Public method
  public void myPublicMethod() {
    System.out.println("Public methods must be called by creating objects");
  }

  // Main method
  public static void main(String[ ] args) {
    myStaticMethod(); // Call the static method
    // myPublicMethod(); This would output an error

    Main myObj = new Main(); // Create an object of Main
    myObj.myPublicMethod(); // Call the public method
  }
}


////------calling superclass constructor-------///
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called.");
    }
}

class Dog extends Animal {
    String breed;

    // Constructor for Dog class
    public Dog(String name, String breed) {
        super(name); // Calling superclass constructor explicitly, this is must as superclass constructor is parametarized and has no default constructor definition
        this.breed = breed;
        System.out.println("Dog constructor called.");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", "Golden Retriever");
        System.out.println("My dog's name is " + myDog.name + " and breed is " + myDog.breed);
    }
}

///----multilevel inheritance-------///
class A{
    
}
class B extends A{
    
}
class C extends B{
    
}

public class Main {
    public static void main(String[] args) {
       A a= new B();  //this is right
       A a= new C();  //this is also right cause this inherits all the properties of A class, so this is also subclass of A
    }
}

////////----multiple inheritance not allowed in java----///




////////----hierarchical  inheritance----///

class A{
    
}
class B extends A{
    
}
class C extends A{
    
}

///------  Has-A relationship-----///

public class Address {  
String city,state,country;  
  
public Address(String city, String state, String country) {  
    this.city = city;  
    this.state = state;  
    this.country = country;  
}  
  
} 

public class Emp {  
int id;  
String name;  
Address address;  
  
public Emp(int id, String name,Address address) {  
    this.id = id;  
    this.name = name;  
    this.address=address;  
}  
  
void display(){  
System.out.println(id+" "+name);  
System.out.println(address.city+" "+address.state+" "+address.country);  
}  
  
public static void main(String[] args) {  
Address address1=new Address("gzb","UP","india");  
Address address2=new Address("gno","UP","india");  
  
Emp e=new Emp(111,"varun",address1);  
Emp e2=new Emp(112,"arun",address2);  
      
e.display();  
e2.display();  
      
}  
}  

/----- Java Interface ---------/

// Interface
interface Animal {
  public void animalSound(); // interface method (does not have a body)
  public void sleep(); // interface method (does not have a body)
}

// Pig "implements" the Animal interface
class Pig implements Animal {
  public void animalSound() {
    // The body of animalSound() is provided here
    System.out.println("The pig says: wee wee");
  }
  public void sleep() {
    // The body of sleep() is provided here
    System.out.println("Zzz");
  }
}

class Main {
  public static void main(String[] args) {
    Pig myPig = new Pig();  // Create a Pig object
    myPig.animalSound();
    myPig.sleep();
  }
}


/------ Implementing multiple inheritance---/

interface FirstInterface {
  public void myMethod(); // interface method
}

interface SecondInterface {
  public void myOtherMethod(); // interface method
}

class DemoClass implements FirstInterface, SecondInterface {
  public void myMethod() {
    System.out.println("Some text..");
  }
  public void myOtherMethod() {
    System.out.println("Some other text...");
  }
}

class Main {
  public static void main(String[] args) {
    DemoClass myObj = new DemoClass();
    myObj.myMethod();
    myObj.myOtherMethod();
  }
}




