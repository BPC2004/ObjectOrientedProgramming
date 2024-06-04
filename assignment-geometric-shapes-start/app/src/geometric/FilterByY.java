package geometric;

public class FilterByY implements GeoPredicate {
    private double filter;

    public FilterByY(double filter){
        this.filter = filter;
    }

    public boolean searchByFilter(Geometric shape) {
        if(shape == null){
            return false;
        }
        return shape.bottomBorder() < filter;
    }
}
