public class Main {
    public static void main(String[] args) {
        WarehouseManager mywarehouse = new WarehouseManager();
        Menu menu = new Menu();
        Cart cart = new Cart();

        menu.searchBy(cart);
    }
}
