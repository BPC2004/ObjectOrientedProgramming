package filefinder;

import java.io.File;
import java.io.IOException;

public class FileFinder implements Runnable{
	private final File rootDir;
	private String fileName;

	public FileFinder(String root) throws IOException {
		rootDir = new File(root);
		if (!(rootDir.exists() && rootDir.isDirectory())) {
			throw new IOException(root + " is not a directory");
		}
	}

	private FileFinder(File rootDir, String fileName){
		this.rootDir = rootDir;
		this.fileName = fileName;
	}

	public void findFile(String file) {
		this.fileName = file;
		run();
	}

	@Override
	public void run() {
		File[] files = rootDir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.getName().equals(fileName)) {
					System.out.println("Found at: " + file.getAbsolutePath());
				} else if (file.isDirectory()) {
					Thread thread = new Thread(new FileFinder(file, fileName));
					thread.start();
				}
			}
		}
	}
}
