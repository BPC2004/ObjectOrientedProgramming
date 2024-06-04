package geometric;

public class FilterByX implements GeoPredicate {
    private double filter;

    public FilterByX(double filter){
        this.filter = filter;
    }

    public boolean searchByFilter(Geometric shape) {
        if(shape == null){
            return false;
        }
        return shape.leftBorder() < filter;
    }
}