package ast;

public class Atom implements Formula{
    private String string;

    public Atom(String string){
        this.string = string;
    }
    
    @Override
    public <R> R accept(FormulaVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Override
    public int getPrecedence() {
        return 4;
    }

    public Object getString() {
        return this.string;
    }
}
