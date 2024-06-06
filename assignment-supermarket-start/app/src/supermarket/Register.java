package supermarket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Register {

	// Make sure that CONVEYOR_SIZE + BIN_SIZE >= Customer.MAX_ITEMS, otherwise
	// danger of deadlock
	private static final int CONVEYER_SIZE = 10, BIN_SIZE = 10;
	private Lock myLock = new ReentrantLock();
	private ConveyorBelt<Item> conveyor;
    private ConveyorBelt<Item> bin;

	public Register(){
		conveyor = new ConveyorBelt<>(CONVEYER_SIZE);
        bin = new ConveyorBelt<>(BIN_SIZE);
	}

	public void putOnBelt(Item article) throws InterruptedException {
		conveyor.putIn(article);
	}

	public Item removeFromBelt() throws InterruptedException {
		return conveyor.removeFrom();
	}

	public void putInBin(Item article) throws InterruptedException {
		bin.putIn(article);
	}

	public Item removeFromBin() throws InterruptedException {
		return bin.removeFrom();
	}

	public void claim() {
		myLock.lock();
	}

	public void free() {
		myLock.unlock();
	}
}
