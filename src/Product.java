import java.util.List;

interface Product {
    void searchBySellingPrice(List<Product> list);

    void searchByModel(List<Product> list);

    void searchByProductor(List<Product> list);

    public String getManufacturer();

    public String getModel();

    public float getPurchasePrice();

    public float getSellingPrice();

    void searchByPurchasePrice(List<Product> list);
}
