package factory;
import java.text.DecimalFormat;
import java.util.*;

public class TV implements EnergyConsumer, Display, Product {
    private double voltage;
    private double current;
    private double price;
    private int horizontal;
    private int vertical;
    private int refreshRate;
    private int bitsPerPixel;
    private String brand;
    private String model;
    private String displayType;
    private List<String> connectors = new ArrayList<>();

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "$" + df.format(price) + " " + brand + " "  + model + ", " + horizontal + "x" + vertical + "x" + bitsPerPixel + "@" + refreshRate + " " + displayType + " display, " + connectors + " " + voltage + "V " + current + "A " + "(" + this.getkWhyearly() + ")";
    }

    public void accept(ProductVisitor visitor) {
		visitor.visit(this);
	}

    public double getVoltage() {
        return voltage;
    }

    public double getCurrent() {
        return current;
    }

    public int getConnectorCount(String type) {
        int count = 0;
        for(String i : connectors){
            if(i == type)
                count++;
        }
        return count;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getDisplayType(){
        return displayType;
    }

    public double getkWhyearly(){
        return this.yearlyPower() * (1.0 / 24);
    }

    private TV(Builder builder) {
        this.horizontal = builder.horizontal;
        this.vertical = builder.vertical;
        this.voltage = builder.voltage;
        this.current = builder.current;
        this.price = builder.price;
        this.refreshRate = builder.refreshRate;
        this.bitsPerPixel = builder.bitsPerPixel;
        this.brand = builder.brand;
        this.model = builder.model;
        this.displayType = builder.displayType;
        this.connectors = builder.connectors;
    }

    public static class Builder {
        // required parameters: 
        private int horizontal, vertical;
        // optional parameters:
        private int refreshRate = 60, bitsPerPixel = 24;
        private String brand = "LG", model = "L27LCD+", displayType = "LCD";
        private double voltage = 240, current = 0.1,  price = 300.00;
        private List<String> connectors = new ArrayList<>();

        public Builder(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }

        public Builder refreshRate(int refreshRate) {
            this.refreshRate = refreshRate;
            return this;
        }

        public Builder bitsPerPixel(int bitsPerPixel) {
            this.bitsPerPixel = bitsPerPixel;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder displayType(String displayType) {
            this.displayType = displayType;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder current(double current) {
            this.current = current;
            return this;
        }

        public Builder voltage(double voltage) {
            this.voltage = voltage;
            return this;
        }

        public Builder addConnector(String connector){
            this.connectors.add(connector);
            return this;
        }

        public Builder connectors(List<String> connectors){
            this.connectors = connectors;
            return this;
        }

        public TV build() {
            return new TV(this);
        }
    }
}