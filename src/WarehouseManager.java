public class WarehouseManager {
    private static Warehouse warehouse;

    public static Warehouse getWarehouse() {
        if (warehouse == null) {
            warehouse = new Warehouse();
        }
        return warehouse;
    }
}
