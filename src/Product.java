import java.util.List;

interface Product {
    void searchByModel(List<Product> list);

    void searchByProductor(List<Product> list);

    public String getManufacturer();

    public String getModel();
}
