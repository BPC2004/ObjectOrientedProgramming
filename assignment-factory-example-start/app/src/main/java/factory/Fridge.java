package factory;

import java.text.DecimalFormat;

public class Fridge implements Product, EnergyConsumer{
    private boolean isFreezer;
    private int volume;
    private String brand;
    private double voltage;
    private double current;
    private double price;

    public Fridge(boolean isFreezer, int volume, String brand, double price){
        this.isFreezer = isFreezer;
        this.volume = volume;
        this.brand = brand;
        this.voltage = 240;
        this.current = 2;
        this.price = price;
    }

    public static Fridge createFreezer(String brand, int volume, double price){
        return new Fridge(true, volume, brand, price);
    }

    public static Fridge createFridge(String brand, int volume, double price){
        return new Fridge(false, volume, brand, price);
    }

    public boolean getFreezer(){
        return isFreezer;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getVoltage(){
        return voltage;
    }

    public double getCurrent(){
        return current;
    }

    public String getBrand(){
        return brand;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        String line;
        if (isFreezer)
            line = " fridge with freezer ";
        else
            line = " fridge without freezer ";
        return "$" + df.format(price) + " " + brand + " " + volume + "l" + line + voltage + "V " + current + "A " + "(" + this.yearlyPower() + ")";
    }

    public void accept(ProductVisitor visitor) {
		visitor.visit(this);
	}
}
