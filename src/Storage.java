import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private List productsList = new ArrayList<Product>();
    private Map productsMap = new HashMap<Integer, Product>();
    private int lastID = 0; //we keep the last id to "generate" product ids when stored

    public Storage(Product product) {
        productsMap.put(lastID, product);
        productsList.add(product);
        //product.setID(lastID);
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

    /*public void searchByType(ProductType type) //return list and "main" takes care of it?
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
    }*/

    static <T> List<Integer> indexOfAll(T obj, List<T> list) {
        final List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (obj.equals(list.get(i))) { //two products, with different ids but same model etc will add to the quantity
                indexList.add(i);
            }
        }
        return indexList;
    }

    /*public int getQuantityByProduct(Product product) {
        ProductType = product.getType();
        var list = indexOfAll(product, productsList);
        return list.size();
    }*/

    public void deleteProductsById(int productID) {
        var product = productsMap.get(productID);
        if (product != null) {
            productsList.remove(product);
        }
        productsMap.remove(productID);
    }
}
