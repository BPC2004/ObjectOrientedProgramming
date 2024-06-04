package factory;

public interface Product {
    double getPrice();
    void setPrice(double Price);
    
    void accept(ProductVisitor visitor);

    default void multiplyPrice(double discount) {
        setPrice(getPrice() * discount);
    };
}
