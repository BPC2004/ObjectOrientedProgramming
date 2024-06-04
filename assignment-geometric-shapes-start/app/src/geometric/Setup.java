package geometric;

import java.util.Arrays;

public class Setup{
    private Geometric[] listShapes;
    private Geometric bin;
    private int nrOfShapes = 0;

    public Setup(int amount) {
        listShapes = new Geometric[amount];
    }

    public Geometric[] getShapes() {
        return listShapes;
    }

    public Geometric getShape(int index){
        return listShapes[index];
    }
    
    public void addShape(Geometric shape){
        listShapes[nrOfShapes] = shape;
        nrOfShapes++;
    }

    public void move(int index, int dx, int dy){
        listShapes[index].move(dx, dy);
    }

    public void removeShape(int index){
        for(int j = index; j < listShapes.length - 1; j++){
            listShapes[j] = listShapes[j + 1];
        }
        listShapes[listShapes.length - 1] = bin;
        nrOfShapes--;
    }

    public void removeByX(double filter){
        final FilterByX filterX = new FilterByX(filter);
        for(int i = 0; i < listShapes.length; i++){
            if(filterX.searchByFilter(listShapes[i])){
                for(int j = i; j < listShapes.length - 1; j++){
                    listShapes[j] = listShapes[j + 1];
                }
                listShapes[listShapes.length - 1] = bin;
                i--;
                nrOfShapes--;
            }
        }
    }

    public void removeByY(double filter){
        final FilterByY filterY = new FilterByY(filter);
        for(int i = 0; i < listShapes.length; i++){
            if(filterY.searchByFilter(listShapes[i])){
                for(int j = i; j < listShapes.length - 1; j++){
                    listShapes[j] = listShapes[j + 1];
                }
                listShapes[listShapes.length - 1] = bin;
                i--;
                nrOfShapes--;
            }
        }
    }

    public void removeByR(double filter){
        final FilterByArea filterR = new FilterByArea(filter);
        for(int i = 0; i < listShapes.length; i++){
            if(filterR.searchByFilter(listShapes[i])){
                for(int j = i; j < listShapes.length - 1; j++){
                    listShapes[j] = listShapes[j + 1];
                }
                listShapes[listShapes.length - 1] = bin;
                i--;
                nrOfShapes--;
            }
        }
    }

    @Override
    public String toString() {
        String list = "";
        for (int i = 0; i < nrOfShapes; i++){
            String temp = listShapes[i].toString() + "\n";
            list += temp;
        }
        return list;
    }

    public void sortByX(){
        Arrays.sort(listShapes, new MyComparatorX());
    }

    public void sortByY(){
        Arrays.sort(listShapes, new MyComparatorY());
    }

    public void sortByArea(){
        Arrays.sort(listShapes, new MyComparatorR());
    }
}
