package project3;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import project3.rental.car.CarFactory;
import project3.store.CarRentalStore;
import project3.customer.*;

/**
 * Main entry point to the application
 */
public class Main {
	public static void main( String[] args ) {
		Simulator simulator = Simulator.getSimulator();
		simulator.setDefaultCustomers();
    simulator.setDefaultStore();
		simulator.setNumDays(35);
		simulator.run();
	}
}
