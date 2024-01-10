public class Main {
    public static void main(String[] args) throws Exception {
        WarehouseManager mywarehouse = new WarehouseManager();
        Menu menu = new Menu();
        Cart cart = new Cart();

        menu.searchBy(cart);
    }
}
