package slidingGame;
/**
 * An interface for representing nodes in a state space.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Configuration extends Comparable<Configuration> {
	/**
	 * To obtain the parent of the current configuration, i.e. the configuration
	 * which had this as one of its successors
	 *
	 * @return a reference to the parent
	 */
	public abstract Configuration getParent();

	/**
	 * To obtain the successors for a specific configuration
	 *
	 * @return a collection of configurations containing the successors
	 */
	public abstract Collection<Configuration> successors();

	/**
	 * For marking final / solution configurations.
	 * 
	 * @return true if a this is a solution, false otherwise
	 */
	public abstract boolean isSolution();

	public int getManhattanDistance();

	/**
	 * To build a path from the root configuration to the current one.
	 *
	 * @return a list of successive configurations from the root to 'this'
	 */
	public default List<Configuration> pathFromRoot() {
		List<Configuration> pathFromRoot = new ArrayList<>();
		Configuration current = this;
		while(current != null){
			pathFromRoot.add(current);
			current = current.getParent();
		}
		return pathFromRoot;
	}

}
