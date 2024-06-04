package factory;

import java.text.DecimalFormat;

public class Chair implements Product{
    private double price;
    private String material;

    public Chair(double price, String material){
        this.price = price;
        this.material = material;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getMaterial(){
        return material;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "$" + df.format(price) + " " + material + " chair";
    }

    public void accept(ProductVisitor visitor) {
		visitor.visit(this);
	}
}
