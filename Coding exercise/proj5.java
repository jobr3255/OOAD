// 1.  What Pattern is this?
// 2.  Fix all the ??? and make it go.
// 3.  What's a better name for Thing1

import java.util.Random;

public abstract class BasicCar implements ???
{
	public String modelName;
	public int basePrice,onRoadPrice;

	public String getModelname() {
		return modelName;
	}
	public void setModelname(String modelname) {
		this.modelName = modelname;
	}

	public static int setAdditionalPrice()
	{
		int price = 0;
		Random r = new Random();
		//We will get an integer value in the range 0 to 100000
		int p = r.nextInt(100000);
		price = p;
		return price;
	}
	
	public BasicCar ???() throws ???NotSupportedException
	{
		return  (BasicCar)super.???();
	}	
}

class Ford extends BasicCar 
{
	//A base price for Ford
	public int basePrice=100000;
	public Ford(String m)
	{
		modelName = m;
	}  

	@Override
	public BasicCar ???() throws ???NotSupportedException 
	{
		return (Ford)super.???();		
	}
}

class Nano extends BasicCar 
{
	//A base price for Nano
	public int basePrice=100000;
    public Nano(String m)
    {
        modelName = m;
    }   
	@Override	
	public BasicCar ???() throws ???NotSupportedException 
	{
		 return (Nano)super.???();
		 //return this.???();
	}
}

public class Thing1PatternExample
{
	public static void main(String[] args) throws ???NotSupportedException{
		System.out.println("***Thing1 Pattern Demo***\n");
		BasicCar nano = new Nano("Green Nano") ;
		nano.basePrice=100000;

		BasicCar ford = new Ford("Ford Yellow");
		ford.basePrice=500000;        

		BasicCar bc1;
		//Nano
		bc1 = nano.???();
		//Price will be more than 100000 for sure
		bc1.onRoadPrice = nano.basePrice+BasicCar.setAdditionalPrice();
		System.out.println("Car is: "+ bc1.modelName+" and it's price is Rs."+bc1.onRoadPrice);

		//Ford            
		bc1 = ford.???();
		//Price will be more than 500000 for sure
		bc1.onRoadPrice = ford.basePrice+BasicCar.setAdditionalPrice();
		System.out.println("Car is: "+ bc1.modelName+" and it's price is Rs."+bc1.onRoadPrice);        
	}
}
