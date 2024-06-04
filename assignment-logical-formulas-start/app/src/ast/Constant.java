package ast;

public enum Constant implements Formula{
    TRUE(true), FALSE(false);
    private Boolean val;

    Constant(Boolean val){
        this.val = val;
    }

    @Override
    public <R> R accept(FormulaVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public int getPrecedence() {
        return 4;
    }

    public Boolean getVal() {
        return this.val;
    }
    
}
