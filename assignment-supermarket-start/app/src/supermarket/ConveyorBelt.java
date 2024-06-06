package supermarket;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConveyorBelt<T>{

	private final List<T> elements;
	private int amount, begin, end;
	private final int size;

	private Lock myLock = new ReentrantLock();
	private Condition beltIsNotFull = myLock.newCondition();
	private Condition beltIsNotEmpty = myLock.newCondition();

	public ConveyorBelt(int size) {
		this.size = size;
		elements = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
            elements.add(null);
        }
		amount = 0;
		begin = 0;
		end = 0;
	}

	public void putIn(T item) throws InterruptedException {
		myLock.lock();
		try{
			while(amount >= size){
				beltIsNotFull.await();
			}
			elements.set(end, item);
			end = (end + 1) % size;
			amount = amount + 1;
			beltIsNotEmpty.signalAll();
		} finally{
			myLock.unlock();
		}
	}

	public T removeFrom() throws InterruptedException { // Assumes there is at least one element
		myLock.lock();
		try{
			while(amount == 0){
				beltIsNotEmpty.await();
			}
			T item = elements.get(begin);
			begin = (begin + 1) % size;
			amount = amount - 1;
			beltIsNotFull.signalAll();
			return item;
		} finally{
			myLock.unlock();
		}
	}
}
