package factory;

public class Visit implements ProductVisitor {
    public void visit(Chair chair){
        if(chair.getMaterial() == "wooden"){
            chair.multiplyPrice(0.85);
        }
        if(chair.getMaterial() == "metal"){
            chair.multiplyPrice(1.12);
        }
    }
    public void visit(Fridge fridge){
        if(fridge.getBrand() == "Samsung"){
            fridge.multiplyPrice(0.95);
        }
    } 
    public void visit(TV tv){
        if(tv.getConnectorCount("DP") >= 2){
            tv.multiplyPrice(0.7);
        }
    }
}
