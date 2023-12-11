public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Warehouse warehouse = new Warehouse();
        Cart cart = new Cart(warehouse);


        menu.searchBy(warehouse, cart);
    }
    }
