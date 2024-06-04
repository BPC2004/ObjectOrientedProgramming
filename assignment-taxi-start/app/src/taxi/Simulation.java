package taxi;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Simulation {

	/**
	 * Constants for the size of the simulation
	 */
	public static final int TRAIN_TRIPS = 10;
	public static final int MIN_TRAVELLERS = 60;
	public static final int MAX_TRAVELLERS = 90;
	public static final int CAPACITY_SMALL = 4;
	public static final int CAPACITY_LARGE = 7;
	public static final int TIME_SMALL = 2;
	public static final int TIME_LARGE = 3;
	public static final int NR_OF_TAXIS = 4;
	public static final int NR_OF_SMALL_TAXIS = 2;

	/**
	 * main elements of the simulation
	 */
	private final Taxi[] taxis;
	private List<Runnable> threads;
	private final Station station;

	/**
	 * hasEnded: is the simulation finished? nextTaxi: number of the taxi to be use
	 * in next step
	 */

	/**
	 * Constructor: create station and small and large taxis
	 */
	public Simulation() {
		threads = new LinkedList<>();
		station = new Station();
		taxis = new Taxi[NR_OF_TAXIS];
		for (int i = 0; i < NR_OF_TAXIS; i++) {
			taxis[i] = i < NR_OF_SMALL_TAXIS ? new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station)
					: new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
			threads.add(taxis[i]);
		}
		threads.add(new Train(station));
	}

	/**
	 * simulation step: if there are passengers load them in a taxi, otherwise let a
	 * train bring new passengers, or indicate that simulation stops
	 */

	public void start() {
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<?>> results = threads.stream()
                .map(t -> executor.submit(t))
                .collect(Collectors.toList());
		results.forEach(f -> {
			try{
				f.get();
			} catch (InterruptedException | ExecutionException ex){
			}
		});
		executor.shutdown();
		this.showStatistics();
	}

	public void showStatistics() {
		System.out.println("All persons have been transported");
		System.out.println("Total transport time in this simulation:" + calcTotalTime());
		System.out.println("Total number of train travelers: " + getArrivedPassengerCount());
		System.out.println("Total number of persons transported in this simulation: " + getDepartedPassengerCount());
	}

	/**
	 * Calculates the total time of the simulation by looping over all taxis
	 *
	 * @return total time
	 */
	private int calcTotalTime() {
		int time = 0;
		for (Taxi taxi : taxis) {
			time += taxi.calcTotalTime();
		}
		return time;
	}

	/**
	 * Calculates the total number of passengers that has been transported by
	 * looping over all taxis
	 *
	 * @return total number of passengers
	 */
	public int getDepartedPassengerCount() {
		int total = 0;
		for (Taxi taxi : taxis) {
			total += taxi.getTotalNrOfPassengers();
		}
		return total;
	}

	public int getArrivedPassengerCount() {
		return station.getTotalNrOfPassengers();
	}
}