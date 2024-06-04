package ast;

import java.util.function.BinaryOperator;

public enum BinOp implements BinaryOperator<Boolean>{
    AndOp("/\\",(b1,b2)-> b1 && b2, 2),
    OrOp("/\\",(b1,b2)-> b1 && b2, 2),
    ImpOp("/\\",(b1,b2)-> !b1 || b2, 2);

    public final String string;
    public final BinaryOperator<Boolean> operator;
    public final int precedence;

    BinOp(String string, BinaryOperator<Boolean> operator, int precedence) {
        this.precedence = precedence;
        this.string = string;
        this.operator = operator;
    }

    public int getPrecedence(){
        return this.precedence;
    }

    public String getString(){
        return this.string;
    }

    @Override
    public Boolean apply(Boolean left, Boolean right) {
        switch (this){
        case AndOp:
            return left && right;
        case OrOp:
            return left || right;
        case ImpOp:
            return !left || right;
        default:
            return null;
        }
    }
    
}
