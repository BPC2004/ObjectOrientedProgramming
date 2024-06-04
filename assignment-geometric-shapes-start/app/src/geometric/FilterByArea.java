package geometric;

public class FilterByArea implements GeoPredicate {
    private double filter;

    public FilterByArea(double filter){
        this.filter = filter;
    }

    public boolean searchByFilter(Geometric shape) {
        if(shape == null){
            return false;
        }
        return shape.area() < filter;
    }
}
