package factory;

import java.util.List;
import java.util.ArrayList;

public class Warehouse {
    private String name;
    private List<Product> products;

    public Warehouse(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public static Warehouse createMyWarehouse() {
        List<Product> products = new ArrayList<>();

        products.add(new Chair(50, "wooden"));
        products.add(new Chair(100, "metal"));
        products.add(new TV.Builder(1920,1080).addConnector("HDMI").addConnector("HDMI").addConnector("DP").build());
        products.add(new TV.Builder(1920,1080).addConnector("HDMI").addConnector("HDMI").addConnector("DP").build());
        products.add(new TV.Builder(1920,1080).price(500.00).brand("Sony").refreshRate(90).displayType("IPS").addConnector("HDMI").addConnector("HDMI").addConnector("DP").addConnector("DP").build());
        products.add(new Fridge(true, 60, "Bosch", 400.00));
        products.add(new Fridge(false, 100, "Samsung", 600.00));

        return new Warehouse("My warehouse", products);
    }

    public void procedure1() {
        for(Product i : products){
            if(i instanceof TV && ((TV)i).getDisplayType() == "LCD"){
                i.multiplyPrice(0.9);
            }
            if(i instanceof Fridge && ((Fridge)i).getFreezer()){
                i.multiplyPrice(1.2);
            }
        }
    }

    public void procedure2() {
        ProductVisitor visitor = new Visit();
        for(Product i : products){
            i.accept(visitor);
        }
    }
    public String toString() {
        String output = "Warehouse 'My warehouse' \n Products: \n";
        for (int j = 0; j < products.size(); j++) {
            output += j + ": \t" + products.get(j).toString() + "\n";
        }
        return output;
    }
}
