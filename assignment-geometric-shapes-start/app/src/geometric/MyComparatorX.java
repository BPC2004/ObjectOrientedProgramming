package geometric;

import java.util.*;

public class MyComparatorX implements Comparator<Geometric>{

    public int compare(Geometric shape1, Geometric shape2){
        if(shape1 == null || shape2 == null){
            return 1;
        }
        if(shape1.leftBorder() > shape2.leftBorder()){
            return 1;
        }
        else if(shape1.leftBorder() < shape2.leftBorder()){
            return -1;
        }
        return 0;
    }
}
