public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart();
        Smartphone smartphone1 = new Smartphone(
                "Apple",
                "iPhone15",
                "None",
                15,
                128,
                200,
                300);
        Smartphone smartphone2 = new Smartphone(
                "Samsung",
                "Galaxy S23",
                "none",
                11,
                128,
                100,
                500);
        Tablet tablet1 = new Tablet(
                "Apple",
                "iPad Pro",
                "none",
                12.9F,
                256,
                300,
                1200);
        Notebook notebook1 = new Notebook(
                "Lenovo",
                "Legion 5 Pro",
                "none",
                16,
                1024,
                1400,
                2000);

        warehouse.addProduct(smartphone1);
        warehouse.addProduct(smartphone2);
        warehouse.addProduct(tablet1);
        warehouse.addProduct(notebook1);

        cart.addProduct(smartphone1);
        cart.addProduct(notebook1);
        menu.searchBy(warehouse, cart);
    }
}