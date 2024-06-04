package factory;

public class App {
    public static void main(String[] args) {
        Warehouse warehouse = Warehouse.createMyWarehouse();

        System.out.println("Initial warehouse:\n");
        System.out.println(warehouse);

        warehouse.procedure1();
        System.out.println("After procedure 1:\n");
        System.out.println(warehouse);

        warehouse.procedure2();
        System.out.println("After procedure 2:\n");
        System.out.println(warehouse);
    }
}
