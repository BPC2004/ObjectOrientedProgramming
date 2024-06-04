package quadtrees;

import java.io.Writer;

public class WhiteLeaf implements QuadTreeNode{
    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        bitmap.fillArea(x, y, width, true);
    }

	public void writeNode(Writer out){
        try{
            out.write("01");
		} catch(Exception E){
			System.out.println(E);
		}
    }
}
