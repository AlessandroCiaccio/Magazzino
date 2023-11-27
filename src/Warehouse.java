import java.util.*;

public class Warehouse {

    private Map<Integer, Product> productsMap = new HashMap<Integer, Product>();
    private int lastID = 0; //we keep the last id to "generate" product ids when stored

    @Override
    public String toString() {
        return "Warehouse{" + "productsMap=" + productsMap + ", lastID=" + lastID + '}';
    }

    public void addProduct(Product product) {
        productsMap.put(lastID, product);
        product.setID(lastID);
        ++lastID;
    }
    public void addProductFromCart(Product product) {
        productsMap.put(product.getID(), product);
    }

    public Product getProductByID(int id) {
        return productsMap.get(id);
    }

    public void printProducts() {
        if (productsMap.isEmpty()) {
            System.out.println("No products in storage.");
            return;
        }

        System.out.println("Products list:");
        for (var values : productsMap.values()) {
            System.out.println(values);
        }
    }

    static <M, N> Integer countObjects(N obj, Map<M, N> map) {
        int count = 0;
        for (var element : map.values()) {
            if (obj.equals(element)) { //two products, with different ids but same model etc will add to the quantity
                count++;
            }
        }
        return count;
    }

    public int getQuantityByProduct(Product product) {
        ProductType productType = product.getType();
        return countObjects(product, productsMap);
    }

    public void deleteProductById(int productID) {
        var product = productsMap.get(productID);
        if (product == null) {
            System.out.println("Product not found");
            return;
        }
        productsMap.remove(productID);
    }

    public ArrayList<Product> searchByType(ProductType type) //return list and "main" takes care of it?
    {
        var productsByTypeList = new ArrayList<Product>();
        for (var values : productsMap.values()) {
            if (values.getType() == type) {
                productsByTypeList.add(values);
            }
        }
        return productsByTypeList;
    }

    public ArrayList<Product> searchByModel(String model) {
        ArrayList<Product> byModel = new ArrayList<>();
        for (Product element : productsMap.values()) {
            if (element.getModel().equals(model)) {
                byModel.add(element);
            }
        }
        return byModel;
    }

    public ArrayList<Product> searchByManufacturer(String manufacturer) {
        ArrayList<Product> byManufacturer = new ArrayList<>();
        for (Product element : productsMap.values()) {
            if (element.getManufacturer().equals(manufacturer)) {
                byManufacturer.add(element);
            }
        }
        return byManufacturer;
    }

    public ArrayList<Product> searchBySellingPrice(int order) {
        ArrayList<Product> bySellingPrice = new ArrayList<>();
        for (Product element : productsMap.values()) {
            bySellingPrice.add(element);
        }
        if (order == 1) {
            bySellingPrice.sort(Comparator.comparing(Product::getSellingPrice));
        } else if (order == 2) {
            bySellingPrice.sort(Comparator.comparing(Product::getSellingPrice).reversed());
        }
        return bySellingPrice;
    }


    public ArrayList<Product> searchByPurchasePrice(int order) {
        ArrayList<Product> byPurchasePrice = new ArrayList<>();
        for (Product element : productsMap.values()) {
            byPurchasePrice.add(element);
        }
        if (order == 1) {
            byPurchasePrice.sort(Comparator.comparing(Product::getSellingPrice));
        } else if (order == 2) {
            byPurchasePrice.sort(Comparator.comparing(Product::getSellingPrice).reversed());
        }
        return byPurchasePrice;
    }

    public ArrayList<Product> searchByPurchasePriceRange(int priceMin, int priceMax) {
        ArrayList<Product> byPriceRange = new ArrayList<>();
        for (Product element : productsMap.values()) {
            if (element.getPurchasePrice() >= priceMin && element.getPurchasePrice() <= priceMax) {
                byPriceRange.add(element);
            }
            byPriceRange.sort(Comparator.comparing(Product::getPurchasePrice));
        }
        return byPriceRange;
    }

    public ArrayList<Product> searchBySellingPriceRange(int priceMin, int priceMax) {
        ArrayList<Product> byPriceRange = new ArrayList<>();
        for (Product element : productsMap.values()) {
            if (element.getSellingPrice() >= priceMin && element.getSellingPrice() <= priceMax) {
                byPriceRange.add(element);
            }
            byPriceRange.sort(Comparator.comparing(Product::getSellingPrice));
        }
        return byPriceRange;
    }
    public Map<Integer, Product> returnMap(){
        return productsMap;
    }
}


