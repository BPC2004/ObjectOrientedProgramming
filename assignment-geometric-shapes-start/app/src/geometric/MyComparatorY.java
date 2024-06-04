package geometric;

import java.util.*;

public class MyComparatorY implements Comparator<Geometric>{

    public int compare(Geometric shape1, Geometric shape2){
        if(shape1 == null || shape2 == null){
            return 1;
        }
        if(shape1.bottomBorder() > shape2.bottomBorder()){
            return 1;
        }
        else if(shape1.bottomBorder() < shape2.bottomBorder()){
            return -1;
        }
        return 0;
    }
}
