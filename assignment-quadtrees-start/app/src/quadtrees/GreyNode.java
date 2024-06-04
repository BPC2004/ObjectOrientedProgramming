package quadtrees;

import java.io.Writer;

public class GreyNode implements QuadTreeNode{
    private QuadTreeNode  topLeft, topRight, bottomRight, bottomLeft;
    public GreyNode(QuadTreeNode topLeft, QuadTreeNode topRight, QuadTreeNode bottomRight, QuadTreeNode bottomLeft) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
    }

    public void fillBitmap(int x, int y, int width, Bitmap bitmap){
        topLeft.fillBitmap(x, y, width / 2, bitmap);
        topRight.fillBitmap(x + width / 2, y, width / 2, bitmap);
        bottomRight.fillBitmap(x + width / 2, y + width / 2, width / 2, bitmap);
        bottomLeft.fillBitmap(x, y + width / 2, width / 2, bitmap);
    }

	public void writeNode(Writer out){
        try{
            out.write("1");
		} catch(Exception E){
			System.out.println(E);
		}
        topLeft.writeNode(out);
        topRight.writeNode(out);
        bottomRight.writeNode(out);
        bottomLeft.writeNode(out);
    }
}
