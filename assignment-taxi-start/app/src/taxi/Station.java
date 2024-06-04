package taxi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that holds the number of persons arriving by train at the station and
 * waiting for a taxi
 */
public class Station{
	private Lock myLock = new ReentrantLock();
	private int nrOfPassengersAtStation = 0;
	private int totalNrOfPassengers = 0;
	private boolean isClosed = false;
	private Condition passengerAtStation = myLock.newCondition();
	private Condition noPassengerAtStation = myLock.newCondition();
	

	public void enterStation(int nrOfPassengers) throws InterruptedException {
		myLock.lock();
		try{
			while(nrOfPassengersAtStation > 0){
				noPassengerAtStation.await();
			}
			nrOfPassengersAtStation += nrOfPassengers;
			totalNrOfPassengers += nrOfPassengers;
			System.out.println(nrOfPassengers + " passengers arrived at station");
			passengerAtStation.signalAll();


		} finally{
			myLock.unlock();
		}
	}

	/**
	 * Ask for nrOfPassengers Passengers to leave the station
	 *
	 * @param requestedNrOfPassengers
	 * @return number of passengers actually leaving
	 * @throws InterruptedException 
	 */
	public int leaveStation(int requestedNrOfPassengers) throws InterruptedException {
		myLock.lock();
		try{
			while(nrOfPassengersAtStation == 0){
				passengerAtStation.await();
			}
			int actuallyLeaving = Math.min(requestedNrOfPassengers, nrOfPassengersAtStation);
			nrOfPassengersAtStation -= actuallyLeaving;
			if(nrOfPassengersAtStation == 0){
				noPassengerAtStation.signalAll();
			}
			return actuallyLeaving;
		} finally{
			myLock.unlock();
		}
	}

	public int waitingPassengers() {
		myLock.lock();
		try{
			return nrOfPassengersAtStation;

		} finally{
			myLock.unlock();
		}
	}

	public void close() {
		isClosed = true;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public int getTotalNrOfPassengers() {
		return totalNrOfPassengers;
	}
}