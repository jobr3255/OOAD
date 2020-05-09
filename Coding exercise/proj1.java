// 1.  What Pattern is this?
// 2.  Fix all the ??? and make it go.
// 3.  What's a better name for Thing1
// 4.  What's a better name for Thing2

import java.util.*;

interface Thing1
{
	???;
}
class Thing1Type implements Thing1
{
	String nameOfThing1;
	public Thing1Type(String name)
	{
		this.nameOfThing1 = name;
	}   
	@Override
	public void update(int updatedValue) 
	{
		System.out.println( nameOfThing1+" has received an alert: Updated myValue in Thing2 is: "+ updatedValue);
	}
}
interface Thing2Interface
{
	???;
	???;
	???;
}
class Thing2 implements Thing2Interface
{
	private int flag;
	public int getFlag() 
	{
		return flag;
	}
	public void setFlag(int flag) 
	{
		this.flag = flag;
		//Flag value changed. So notify registered users/Thing1s.
		notifyRegisteredUsers(flag);
	}
	List<Thing1> Thing1List = new ArrayList<Thing1>();    
	@Override
	public void register(Thing1 anThing1) {
		Thing1List.add(anThing1);

	}
	@Override
	public void unregister(Thing1 anThing1) {
		Thing1List.remove(anThing1);		
	}
	@Override
	public void notifyRegisteredUsers(int updatedValue) 
	{
		for (Thing1 thing1 : Thing1List)
			thing1.update(updatedValue);
	}
}
public class Thing1PatternExample {

	public static void main(String[] args) {
		System.out.println(" ***Thing1 Pattern Demo***\n");
		//We have 3 Thing1s
		Thing1 myThing11 = new ???("Roy");
		Thing1 myThing12 = new ???("Kevin");
		Thing1 myThing13 = new ???("Bose");
		Thing2 thing2 = new ???();
		//Registering the Thing1s-Roy,Kevin,Bose
		thing2.register(myThing11);
		thing2.register(myThing12);
		thing2.register(myThing13);
		System.out.println(" Setting Flag = 5 ");
		thing2.setFlag(5);           
		//Unregistering an Thing1(Roy))
		thing2.unregister(myThing11);
		//No notification this time Roy. Since it is unregistered.
		System.out.println("\n Setting Flag = 50 ");            
		thing2.setFlag(50);
		//Roy is registering himself again
		thing2.register(myThing11);
		System.out.println("\n Setting Flag = 100 ");
		thing2.setFlag(100);
	}
}