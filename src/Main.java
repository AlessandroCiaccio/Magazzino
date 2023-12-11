public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Cart cart = new Cart();
       Warehouse warehouse =  WarehouseManager.getWarehouse();
       
        menu.searchBy(warehouse, cart);
    }
}
