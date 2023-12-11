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

    public Product removeFromCart(int ID) {
        for (Product element : products) {
            if (element.getID() == ID) {
                Product p = element;
                products.remove(element);
                return p;
            }
        }
        return null;
    }

    public void addToCart(int ID) {
        for (Product element : WarehouseManager.getWarehouse().returnMap().values()) {
            if (element.getID() == ID) {
                products.add(element);
            }
        }
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void printProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in the cart.");
            return;
        }

        System.out.println("Products list:");
        for (var values : products) {
            System.out.println(values);
        }
    }

    @Override
    public String toString() {
        return "Cart{" + "products=" + products + '}';
    }

}