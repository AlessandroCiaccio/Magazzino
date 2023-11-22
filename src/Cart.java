import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public float calculateTotalPrice() {
        float total = 0;
        for (Product product : this.products) {
            total += product.getSellingPrice();
        }
        return total;
    }

    public List<Product> getProducts() {
        return this.products;
    }
}