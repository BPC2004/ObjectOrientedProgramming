package ast;

public interface FormulaVisitor<Result>{
    Result visit(Not form);
    Result visit (ast.BinaryOperator form);
    Result visit(Constant form);
    Result visit(Atom form);
}
