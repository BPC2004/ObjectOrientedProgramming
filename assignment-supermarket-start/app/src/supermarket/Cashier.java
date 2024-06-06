package supermarket;

import java.util.concurrent.Callable;

public class Cashier implements Callable<Void> {

	private final Register checkout;

	public Cashier(Register checkout) {
		this.checkout = checkout;
	}

	@Override
	public Void call() {
		try{
			while(true){
				checkout.putInBin(checkout.removeFromBelt());
			}
		}catch (InterruptedException e){
			return null;
		}
	}
}
