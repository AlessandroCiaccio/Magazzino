public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Warehouse warehouse = new Warehouse();
        Smartphone smartphone = new Smartphone("Apple",
                "iPhone15",
                "None",
                15,
                10,
                200,

                300);
        Smartphone smartphone1 = new Smartphone("Apple", "iPhone15", "none",10,10,150,400);
        Smartphone smartphone2 = new Smartphone("Apple", "iPhone15", "none",10,10,150,400);
        Smartphone smartphone3 = new Smartphone("Apple", "iPhone15", "none",10,10,150,400);
        Smartphone smartphone4 = new Smartphone("Apple", "iPhone15", "none",10,10,150,400);
        Smartphone smartphone5 = new Smartphone("Apple", "iPhone15", "none",10,10,150,400);

        warehouse.addProduct(smartphone);
        warehouse.addProduct(smartphone1);
        warehouse.addProduct(smartphone2);
        warehouse.addProduct(smartphone3);
        warehouse.addProduct(smartphone4);
        warehouse.addProduct(smartphone5);

        menu.searchBy(warehouse);
    }
}