package taxi;

/**
 * Trains bring a number of passengers to a station in the Taxi simulation
 */
public class Train implements Runnable{

	public static final int TRAIN_TRIPS = 10;
	public static final int MIN_TRAVELLERS = 60;
	public static final int MAX_TRAVELLERS = 90;
	public static final int TRAVEL_TIME = 3000;
	private int nrOfPassengers;
	private final Station station;
	private int nrOfTrips = 0;

	public Train(Station station) {
		this.station = station;
		this.nrOfPassengers = 0;
	}

	/**
	 * Populate this train with number nrOfPassengers
	 *
	 * @param number the number of passengers of this train
	 */
	public void loadPassengers(int number) {
		nrOfPassengers = number;
	}

	/**
	 * empties this train and augment the number of Passengers at the station with
	 * this nrOfPassenegers
	 * @throws InterruptedException 
	 */
	public void unloadPassengers() throws InterruptedException{
		nrOfTrips += 1;
		station.enterStation(nrOfPassengers);
	}

	public void closeStation() {
		station.close();
	}

	public int getNrOfTrips() {
		return nrOfTrips;
	}

	@Override
	public void run(){
		try {
			for (int i = 0; i < TRAIN_TRIPS; i++){
				Thread.sleep(Util.getRandomNumber(TRAVEL_TIME - 300, TRAVEL_TIME + 300));
				loadPassengers(Util.getRandomNumber(MIN_TRAVELLERS, MAX_TRAVELLERS));
				unloadPassengers();
			}
			closeStation();
		} catch (InterruptedException e) {}
	}
}