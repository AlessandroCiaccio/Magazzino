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
                300,
                1);
        Smartphone smartphone1 = new Smartphone("Apple", "iPhone15", "none",10,10,150,400,2);
        warehouse.addProduct(smartphone);
        warehouse.addProduct(smartphone1);
        menu.searchBy(warehouse);
    }
}