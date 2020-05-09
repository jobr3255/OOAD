// 1.  What Pattern is this?
// 2.  Fix all the ??? and make it go.
// 3.  What's a better name for Thing1
// 4.  What's a better name for Thing2

abstract class Thing2
{
	???;

}
class ConcreteThing2 extends Thing2
{
	public void makeHouse()
	{            
		???("Original House is complete. It is closed for modification.");            
	}
}

abstract class AbstractThing1 extends Thing2
{
	protected Thing2 thing2 ;
	public void setTheThing2(Thing2 c)
	{
		thing2 = c;
	}
	public void makeHouse()
	{
		if (thing2 != null)
		{
			thing2.makeHouse();//Delegating the task
		}
	}
}
//A floor thing1
class FloorThing1 extends AbstractThing1
{
	public void ???()
	{   
		super.???();		
		//Decorating now.
		???("***Floor thing1 is in action***");
		addFloor();
		//You can put additional stuff as per your need
	}
	private void addFloor()
	{
		???("I am making an additional floor on top of it.");
	}
}
//A paint thing1
class PaintThing1 extends AbstractThing1
{
	public void ???()
	{
		super.???();	
		//Decorating now.
		???("***Paint thing1 is in action now***");
		paintTheHouse();
		//You can add additional stuffs as per your need
	}
	private void paintTheHouse()
	{
		???("Now I am painting the house.");         
	}
}

public class Thing1PatternExample {

	public static void main(String[] args) {
		???("***Thing1 pattern Demo***\n");
		//AbstractThing1 abstractThing1 = new AbstractThing1();//Compile time error
		ConcreteThing2 withoutThing1 = new ConcreteThing2();
		withoutThing1.makeHouse();
		???("_________________"); 

		//Using a thing1 to add floor
		???("Using a Floor thing1 now."); 
		//FloorThing1 floorThing1 = new FloorThing1();
		AbstractThing1 floorThing1 = new FloorThing1();
		floorThing1.setTheThing2(withoutThing1);
		floorThing1.makeHouse();
		???("_________________"); 

		//Using a thing1 to add floor to original house and then paint it.
		???("Using a Paint thing1 now."); 
		//PaintThing1 paintThing1 = new PaintThing1();
		AbstractThing1 paintThing1 = new PaintThing1();
		//Adding results from floor thing1
		paintThing1.setTheThing2(floorThing1);
		paintThing1.makeHouse();
		???("_________________");
		

	}
}