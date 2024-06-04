package ast;

import java.util.function.BinaryOperator;

public class PrintVisitor implements FormulaVisitor <Void, Integer>{
    private StringBuilder result;

    private Boolean getBrack(int left, int right){
        return left <= right;
    }

    public String getResult () { 
        return result.toString (); 
    }


    public StringBuilder visit(Not form) {
        StringBuilder string = new StringBuilder();
        string.append("!");
        if(getBrack(form.getOperand().getPrecedence(), form.getPrecedence())){
            string.append("(" + form.getOperand().accept(this) + ")");
        }
        else{
            string.append(form.getOperand().accept(this) + "");
        }
        return string;
    }

    @Override
    public void visit(BinaryOperator form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
}
