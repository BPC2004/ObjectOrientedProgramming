package supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Customer implements Callable<Integer> {

	public static final int MAX_ITEMS = 20;
	private final Store store;
	private final int customerNumber;
	private final int numberOfItemsWanted;
	private final Random GENERATOR;
	private static List<Item> basket;
	
	public int getNumberOfItemsWanted() {
		return numberOfItemsWanted;
	}

	public Customer(int number, Store store) {
		this.store = store;
		GENERATOR = new Random();
		customerNumber = number;
		numberOfItemsWanted = GENERATOR.nextInt(MAX_ITEMS) + 1;
		basket = new ArrayList<>();
	}
	
	@Override
	public Integer call() {
		int numberOfItemsBought = 0;
		try{
			basket = store.getItems(numberOfItemsWanted);
			int nrRegister = GENERATOR.nextInt(Store.NUMBER_OF_CHECKOUTS);
			Register checkout = store.claimRegister(nrRegister);
			checkout.claim();
			for(Item i : basket) checkout.putOnBelt(i);
			checkout.putOnBelt(null);
			while(checkout.removeFromBin() != null){ 
				numberOfItemsBought++;
			}
			System.out.println("Customer " + customerNumber + " is checking out at register " + nrRegister);
			checkout.free();
			System.out.println("Number of items bought:" + numberOfItemsBought);
		} catch(InterruptedException e){
			return numberOfItemsBought;
		}
		return numberOfItemsBought;
	}
}
