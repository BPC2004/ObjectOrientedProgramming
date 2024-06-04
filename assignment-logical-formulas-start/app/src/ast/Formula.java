package ast;

public interface Formula {
    public <R> R accept ( PrintVisitor printVisitor);
    int getPrecedence();
}
