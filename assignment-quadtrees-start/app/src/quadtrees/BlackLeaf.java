package quadtrees;

import java.io.Writer;

public class BlackLeaf implements QuadTreeNode{
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        bitmap.fillArea(x, y, width, false);
    }

	public void writeNode(Writer out){
        try{
            out.write("00");
		} catch(Exception E){
			System.out.println(E);
		}
    }
}
