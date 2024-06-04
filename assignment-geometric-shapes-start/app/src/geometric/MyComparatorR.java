package geometric;

import java.util.*;

public class MyComparatorR implements Comparator<Geometric>{

    public int compare(Geometric shape1, Geometric shape2){
        if(shape1 == null || shape2 == null){
            return 1;
        }
        else if(shape1.area() > shape2.area()){
            return 1;
        }
        else if(shape1.area() < shape2.area()){
            return -1;
        }
        return 0;
    }
}
