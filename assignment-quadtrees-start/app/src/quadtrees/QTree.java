package quadtrees;

import java.io.Reader;
import java.io.Writer;

public class QTree {
	private QuadTreeNode root;

	public QTree(Reader input){
		root = readQTree(input);
	}

	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	public void writeQTree(Writer sb) {
		root.writeNode(sb);
	}

	private static QuadTreeNode readQTree(Reader input){
		int bit = 0;
		try{
			if(input.ready())
				bit = input.read();
		} catch(Exception E){
			System.out.println(E);
		}
		if(bit =='0'){
			try{
				if(input.ready())
					bit = input.read();
			} catch(Exception E){
				System.out.println(E);
			}
			if(bit == '1') return new WhiteLeaf();
			else return new BlackLeaf();
		}
		return new GreyNode(readQTree(input), readQTree(input), readQTree(input), readQTree(input));
	}

	public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		int bit = bitmap.checkBitmap(x, y, width); // I know there is a method getBit but i thought this was more efficient and cleaner.
		if(bit == 0) return new BlackLeaf();
		else if(bit == 1) return new WhiteLeaf();
		else if(bit == -1) return new GreyNode(bitmap2QTree(x, y, width / 2, bitmap), 
											   bitmap2QTree(x + width / 2, y, width / 2, bitmap), 
											   bitmap2QTree(x + width / 2, y + width / 2, width / 2, bitmap), 
											   bitmap2QTree(x, y + width / 2, width / 2, bitmap));
		else return null;
	}
}