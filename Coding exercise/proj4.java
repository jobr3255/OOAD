// 1.  What Pattern is this?
// 2.  Fix all the ??? and make it go.
// 3.  What's a better name for Thing1
// 4.  What's a better name for Thing2
// 5.  What's a better name for Thing3

class Thing1
{
	private int stateId;	
	public Thing1(int stateId)
	{
		this.stateId = stateId;
	}   
	public int getStateId() {
		return stateId;
	}
	/*This class does not have a setter method.
	We need to use this class
    to get the state of the object only.*/

	/*public void setState(String state) {
		this.state = state;
	}*/
}

/* 
// The ‘Thing2’ class
// WikiPedia notes( for your reference):
// Make an object (thing2) itself responsible for:
// 1.Saving its internal state to a(thing1) object and
// 2.Restoring to a previous state from a(thing1) object.
// 3.Only the thing2 that created a thing1 is allowed to access it.
 */
class Thing2
{
	private int stateId;
	public Thing2()
	{
		this.stateId = 0;
		System.out.println(" Thing2 is created with state id : "+ stateId);
	}


	public int getStateId() 
	{
		return stateId;
	}

	public void setStateId(int stateId)	
	{		
		System.out.println(" Setting the state id of the thing2 to : "+ stateId);
		this.stateId= stateId;		
	}
	//Saving its internal state to a(thing1) object
	public ??? saveThing1(int stateId) 
	{
		System.out.println(" Saving thing2's current state id. ");
		//Create thing1 with the current state and return it.
		return new ???(stateId);		
	}

	//Restoring to a previous state from a(thing1) object.
	public void revertThing1(Thing1 previousThing1)
	{
		System.out.println(" Restoring to state id..."+ previousThing1.getStateId());
		this.stateId = previousThing1.getStateId();
		System.out.println(" Current state id of thing2 : "+ stateId);
	}
} 
/*
// The 'Thing3' class.
// 1.A client (thing3) can request a thing1 from the thing2 
// 	 to save the internal state of the thing2 and
// 2.Pass a thing1 back to the thing2 (to restore to a previous state)
// This enables to save and restore the internal state of an thing2 
// without violating its encapsulation.
 */
public class Thing1PatternExample {

	public static void main(String[] args) {
		System.out.println("***Thing1 Pattern Demo***\n");
		//??? is initialized with a state
		??? ??? = new ???();
		??? ???;
		thing2Object.setStateId(1);
		// A client (thing3) can request a thing1 from the thing2 
		//to save the internal state of the thing2
		thing1Object=thing2Object.saveThing1(thing2Object.getStateId());
		System.out.println(" Snapshot #1: Thing2's current state id is saved in thing3.");
		//A client (or thing3) cannot set/modify the thing1's state
		//thing1Object.setState("arbitratyState");//error

		//Changing the state id of Thing2
		thing2Object.setStateId(2);
		thing1Object=thing2Object.saveThing1(thing2Object.getStateId());
		System.out.println(" Snapshot #2: Thing2's current state id is saved in thing3.");

		//Changing the state id of Thing2 again.
		thing2Object.setStateId(3);
		//Reverting back to previous state id.
		thing2Object.revertThing1(thing1Object);
	}

}
