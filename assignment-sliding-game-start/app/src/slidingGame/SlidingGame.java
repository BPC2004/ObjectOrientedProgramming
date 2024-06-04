package slidingGame;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A template of a sliding game
 */
public class SlidingGame implements Configuration {

	public static final int N = 3, SIZE = N * N, HOLE = SIZE;
	/**
	 * The board is represented by a 2-dimensional array; the position of the hole
	 * is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;
	private int manhattanDist = 0;
	private Configuration parent;

	public SlidingGame(int[] start) {
		board = new int[N][N];

		assert start.length == N * N : "Length of specified board incorrect";

		for (int p = 0; p < start.length; p++) {
			board[p % N][p / N] = start[p];
			if (start[p] == HOLE) {
				holeX = p % N;
				holeY = p / N;
			}
		}

		int newMH = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(board[j][i] == N*N){
					continue;
				}
				int currentInt = board[j][i] - 1;
				int targetX = currentInt % N;
				int targetY = currentInt / N;
				newMH += Math.abs(j - targetX) + Math.abs(i - targetY);
			}
		}
		this.manhattanDist = newMH;
	}

	public SlidingGame(SlidingGame parent, Direction dir) {
		board = new int[N][N];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				board[j][i] = parent.board[j][i];
			}
		}
		this.parent = parent;
		int x = parent.holeX + dir.getDX();
		int y = parent .holeY + dir.getDY();
		if(x >= 0 && x < N && y >= 0 && y < N){
			board[parent.holeX][parent.holeY] = board[x][y];
			board[x][y] = HOLE;
			holeX = x;
			holeY = y;
		}

		int newMH = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				int currentInt = board[j][i];
				int targetX = currentInt % N;
				int targetY = currentInt / N;
				newMH += Math.abs(j - targetX) + Math.abs(i - targetY);
			}
		}
		this.manhattanDist = newMH;
	}

	public int getManhattanDistance() {
		return manhattanDist;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				int puzzel = board[col][row];
				buf.append(puzzel == HOLE ? "  " : puzzel + " ");
			}
			buf.append("\n");
		}
		return buf.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof SlidingGame)) return false;
		SlidingGame q = (SlidingGame) o;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[j][i] != q.board[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isSolution() {
		int counter = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[j][i] != counter){
					return false;
				}
				counter++;
			}
		}
		return true;
	}

	@Override
	public Collection<Configuration> successors() {
		Collection<Configuration> successors = new ArrayList<>();
		successors.add(new SlidingGame(this, Direction.NORTH));
		successors.add(new SlidingGame(this, Direction.EAST));
		successors.add(new SlidingGame(this, Direction.SOUTH));
		successors.add(new SlidingGame(this, Direction.WEST));
		return successors;
	}

	@Override
	public int compareTo(Configuration g) {
		return this.manhattanDist - g.getManhattanDistance();
	}

	@Override
	public Configuration getParent() {
		return this.parent;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for ( int x = N-1; x >= 0; x-- ) {
			for ( int y = N-1; y >= 0; y-- ) {
				hash = 31 * hash + board[x][y];
			}
		}
		return hash;
	}
}
