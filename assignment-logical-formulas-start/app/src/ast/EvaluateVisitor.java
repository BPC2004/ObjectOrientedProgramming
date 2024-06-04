package ast;

import java.util.Map;

public class EvaluateVisitor implements FormulaVisitor <Boolean> {
    private final Map<String, Boolean> env;

    public EvaluateVisitor(Map<String, Boolean> env){
        this.env = env;
    }

    @Override
    public Boolean visit(Not form) {
        return !form.getOperand().accept(this);
    } 

    @Override
    public Boolean visit(ast.BinaryOperator form) {
        return form.getBinOp().apply(form.getLeft().accept(this), form.getRight().accept(this));
    }

    @Override
    public Boolean visit(Constant form) {
        return form.getVal();
    }

    @Override
    public Boolean visit(Atom form) {
        return env.get(form.getString());
    }
}
