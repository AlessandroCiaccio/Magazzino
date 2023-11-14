import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Storage {
    private List productsList = new ArrayList<Product>();
    private Map productsMap = new Map<Integer, Product>();
    private int lastID = 0; //we keep the last id to "generate" product ids when stored

    public Storage(Product product) {
        if (productsList.contains(product)) {
            productsList.indexOf(product).getQuantity() + product.getQuantity();
            return;
        }
        productsMap.put(lastID, product);
        ++lastID;
    }

    public void printProducts() {
        if (productsList.isEmpty()) {
            System.out.println("No products in storage.");
            return;
        }

        System.out.println("Products list:");
        for (var values : productsList) {
            System.out.println(values);
        }
    }

    public void searchByType(ProductType type) //return list and "main" takes care of it?
    {
        var productsByTypeList = new ArrayList<Product>();
        for (var values : productsList) {
            if (values.getType() == type) {
                productsByTypeList.add(values);
            }
        }
        if (productsByTypeList.isEmpty()) {
            System.out.println("No products of type " + type);
            return;
        }

        System.out.println("Products of type: " + type);
        for (var values : productsByTypeList) {
            System.out.println(values);
        }
    }

    public void deleteProductsById(int productID) {
        var product = productsMap.get(productID);
        if (product != null) {
            productsList.remove(product);
        }
        productsMap.remove(productID);
    }
}
