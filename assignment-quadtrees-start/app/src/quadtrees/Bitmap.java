package quadtrees;


/**
 * Bitmap: A class for representing bitmap;
 */
public class Bitmap {
	// each bit is stored into an two dimensional array
	private final boolean[][] raster;
	private final int bmWidth, bmHeight;

	/**
	 * Creates an empty bitmap of size width * height
	 * 
	 * @param width
	 * @param height
	 */
	public Bitmap(int width, int height) {
		raster = new boolean[width][height];
		bmWidth = width;
		bmHeight = height;
	}

	/**
	 * Gets a bit at the specified position
	 * 
	 * @param x: x coordinate
	 * @param y: y coordinate
	 */
	public boolean getBit(int x, int y) {
		return raster[x][y];
	}

	/**
	 * Sets a bit at the specified position
	 * 
	 * @param x:   x coordinate
	 * @param y:   y coordinate
	 * @param val: the bit value
	 */
	public void setBit(int x, int y, boolean val) {
		raster[x][y] = val;
	}

	/**
	 * Converts a bitmap into a string 1 is represented by '*'; 0 by 'O'
	 * 
	 * @return the string representation
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < bmHeight; y++) {
			for (int x = 0; x < bmWidth; x++) {
				sb.append(raster[x][y] ? '*' : 'O');
			}
			sb.append('\n');
		}
		return sb.toString();
	}

	/**
	 * @return the width of the bitmap
	 */
	public int getWidth() {
		return bmWidth;
	}

	/**
	 * @return the height of the bitmap
	 */
	public int getHeight() {
		return bmHeight;
	}

	/**
	 * Fills a square area of a bitmap with value val
	 * 
	 * @param x:    x coordinate of upper-left corner
	 * @param y:    y coordinate of upper-left corner
	 * @param size: size of the square
	 * @param val:  the bit value
	 */
	public void fillArea(int x, int y, int size, boolean val) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				setBit(x + i, y + j, val);
			}
		}
	}

	public int checkBitmap(int x, int y, int width){
		boolean value = raster[x][y];
		for(int i = x; i < x + width; i++){
			for(int j = y; j < y + width; j++){
				if(raster[i][j] != value){
					return -1;
				}
			}
		}
		if(value) return 1;
		else return 0;
	}

	// This will make the funny picture into a bitmap
	// public void setRaster(){
	// 	int bit = 0;
	// 	String string = 				   ("********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********00000000****************"+
	// 										"******00********00**************"+
	// 										"*****0************0*************"+
	// 										"***000*******0000000************"+
	// 										"**0000******0*******0***********"+
	// 										"**0000******0*******0***********"+
	// 										"**0000*******0000000************"+
	// 										"**0000************0*************"+
	// 										"***000************0*************"+
	// 										"*****0*****00*****0*************"+
	// 										"*****0****0**0****0*************"+
	// 										"*****0****0**0****0*************"+
	// 										"******0000****0000**************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************"+
	// 										"********************************");
	// 	int index = 0;
	// 	for (int y = 0; y < bmHeight; y++) {
	// 		for (int x = 0; x < bmWidth; x++) {
	// 			char c = string.charAt(index++);
	// 			raster[x][y] = (c == '*');
	// 		}
	// 	}
	// }
}
