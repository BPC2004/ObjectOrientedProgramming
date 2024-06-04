package ast;

public class BinaryOperator implements Formula{
    private BinOp binOp;
    private Formula left, right;

    public BinaryOperator(BinOp operator, Formula left, Formula right){
        this.binOp = operator;
        this.left = left;
        this.right = right;
    }

    public BinOp getBinOp(){
        return this.binOp;
    }

    public Formula getLeft(){
        return this.left;
    }

    public Formula getRight(){
        return this.right;
    }

    public int getPrecedence() {
        return binOp.getPrecedence();
    }
    
    @Override
    public <R> R accept(FormulaVisitor<R> visitor) {
        return visitor.visit(this);
    }

}
