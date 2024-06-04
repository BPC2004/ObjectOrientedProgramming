package ast;

public class Not implements Formula {
    private Formula operand;
    private final int precedence = 4;
    
    public Not(Formula oper){
        this. operand = oper;
    }

    public Formula getOperand(){
        return operand;
    }

    @Override
    public <R> R accept(FormulaVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public int getPrecedence(){
        return precedence;
    }
}