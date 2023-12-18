public class WarehouseManager {
    private static Warehouse warehouse;

    public WarehouseManager() {
        if (warehouse == null) {
            warehouse = new Warehouse();
        }
    }

    public static Warehouse getWarehouse() {
        if (warehouse == null) {
            warehouse = new Warehouse();
        }
        return warehouse;
    }
}
