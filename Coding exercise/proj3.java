// 1.  What Pattern is this?
// 2.  Fix all the ??? and make it go.
// 3.  What's a better name for Thing1
// 4.  What's a better name for Thing2

import java.util.LinkedList;

//The common interface
interface Thing1
{
     void startUpOperations();
     void buildBody();
     void insertWheels();
     void addHeadlights();
     void endOperations();
     /*The following method is used to retrieve the object that is constructed.*/
     Thing2 getVehicle();
}
//Car class
class Car implements Thing1
{
    private String brandName;
    private Thing2 thing2;
    public Car(String brand)
    {
        thing2 = new Thing2();
        this.brandName = brand;
    }
    public void ???()
    {   
    	//Starting with brand name
        thing2.add(String.format("Car model is :%s",this.brandName));
    }
    public void ???()
    {
        thing2.add("This is a body of a Car");
    }
    public void ???()
    {
        thing2.add("4 wheels are added");
    }       

    public void ???()
    {
        thing2.add("2 Headlights are added");
    }
    public void ???()
    {   //Nothing in this case
    }

    public Thing2 ???()
    {
        return thing2;
    }	
}
//Motorcycle class
class MotorCycle implements Thing1
{
    private String brandName;
    private Thing2 thing2;        
    public MotorCycle(String brand)
    {
        thing2 = new Thing2();
        this.brandName = brand;
    }
    public void ???()
    {   //Nothing in this case
    }

    public  void ???()
    {
        thing2.add("This is a body of a Motorcycle");
    }

    public void ???()
    {
        thing2.add("2 wheels are added");
    }
    
    public void ???()
    {
        thing2.add("1 Headlights are added");
    }
    public void ???()
    {
        //Finishing up with brand name
        thing2.add(String.format("Motorcycle model is :%s", this.brandName));
    }
    public Thing2 ???()
    {
        return thing2;
    }
}

// Thing2 class 
class Thing2
{
   /* You can use any data structure that you prefer. 
	I have used LinkedList<String> in this case.*/
    private LinkedList<String> parts;
    public Thing2()
    {
        parts = new LinkedList<String>();
    }

    public void add(String part)
    {
       //Adding parts
        parts.addLast(part);
    }

    public void showThing2()
    {
    	System.out.println("\nThing2 completed as below :");
        for (String part: parts)
        System.out.println(part);
    }
}
// Director class 
class Director
{
    Thing1 thing1;
    // Director knows how to use the thing1 and the sequence of steps.
    public void construct(Thing1 thing1)
    {
        this.thing1 = thing1;
        thing1.startUpOperations();
        thing1.buildBody();
        thing1.insertWheels();
        thing1.addHeadlights();
        thing1.endOperations();        
    }
}
public class Thing1PatternExample {

	public static void main(String[] args) {
		System.out.println("***Thing1 Pattern Demo***");
        Director director = new Director();

        Thing1 fordCar = new Car("Ford");
        Thing1 hondaMotorycle = new MotorCycle("Honda");

        // Making Car
        director.construct(fordCar);
        Thing2 p1 = fordCar.getVehicle();
        p1.showThing2();
                    
        //Making MotorCycle
        director.construct(hondaMotorycle );
        Thing2 p2 = hondaMotorycle.getVehicle();
        p2.showThing2();
	}
}