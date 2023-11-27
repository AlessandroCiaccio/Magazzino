import java.util.ArrayList;
import java.util.List;

public class Cart {
    final Warehouse warehouse;
    private List<Product> products;

    public Cart(Warehouse warehouse) {
        this.warehouse = warehouse;
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

    public void removeFromCart(int ID) {
        for (Product element : products) {
            if (element.getID() == ID) {
                products.remove(element);
                warehouse.addProductFromCart(element);
                break;
            }
        }
    }
    public void addToCart(int ID) {
        for (Product element : warehouse.returnMap().values()) {
            if (element.getID() == ID) {
                products.add(element);
            }
        }
        warehouse.deleteProductById(ID);
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
        return "Cart{" +
                "products=" + products +
                '}';
    }
}