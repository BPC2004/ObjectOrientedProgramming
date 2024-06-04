package filefinder;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			String goal = "needle.txt";
			String root = "haystack";
			FileFinder ff = new FileFinder(root);
			ff.findFile(goal);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
