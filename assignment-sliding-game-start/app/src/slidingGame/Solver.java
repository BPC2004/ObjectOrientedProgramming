package slidingGame;

import java.util.*;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 */
public class Solver {
	// A queue for maintaining states that are not visited yet.
	private Queue<Configuration> toExamine;
	// A collection of states that have been visited
	private Collection<Configuration> encountered;

	public Solver(Configuration g) {
		toExamine = new PriorityQueue<>();
		toExamine.add(g);
		encountered = new HashSet<>();
	}

	/**
	 * A skeleton implementation of the solver
	 *
	 * @return a string representation of the solution
	 */
	public String solve() {
		while (!toExamine.isEmpty()) {
			Configuration next = toExamine.remove();
			if(!encountered.contains(next)){
				encountered.add(next);
				if (next.isSolution()) {
					List<Configuration> pathToGreatness =  next.pathFromRoot();
					StringBuilder pathToFullfillness = new StringBuilder();
					for (int i = pathToGreatness.size() - 1; i >= 0; i--) {
						Configuration index = pathToGreatness.get(i);
						pathToFullfillness.append(index.toString() + "\n");
					}
					return pathToFullfillness.toString();
				} else {
					for (Configuration succ : next.successors()) {
						toExamine.add(succ);
					}
				}
			}
		}
		return "Failure!";
	}
}
