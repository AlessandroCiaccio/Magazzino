import java.util.*;

public class Warehouse {
    public Warehouse() {
        initialize();
    }

    private List<Product> productList = new ArrayList<>();
    private int lastID = 0; //we keep the last id to "generate" product ids when stored

    @Override
    public String toString() {
        return "Warehouse{" + "productsList=" + productList + ", lastID=" + lastID + '}';
    }

    //TODO delete getid() == 0 logic
    // replace map with list
    // add addQuantity logic (quantity as a member of product class)
    public Boolean addProduct(Product product) {
        if (product == null) {
            return false;
        } else if (product.getID() == null) {
            productList.add(product);
            product.setID(lastID);
            ++lastID;
            return true;
        } else {
            productList.add(product);
            return true;
        }
    }

    public void orderingList() {
        productList.sort(Comparator.comparing(Product::getID));
    }

    public Product getProductByID(int id) {
        return productList.get(id);
    }

    public void printProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products in storage.");
            return;
        }

        System.out.println("Products list:");
        for (var values : productList) {
            if (values == null) {
            } else {
                System.out.println(values);
            }
        }
    }

    @Deprecated
    static <M, N> Integer countObjects(N obj, Map<M, N> map) {
        int count = 0;
        for (var element : map.values()) {
            if (obj.equals(element)) { //two products, with different ids but same model etc will add to the quantity
                count++;
            }
        }
        return count;
    }

    Integer countObjects(ProductType type) {
        int count = 0;
        for (var element : productList) {
            if (type.equals(element.getType())) {
                count = count++;
            }
        }
        return count;
    }

    public int getQuantityByProduct(Product product) {
        ProductType productType = product.getType();
        return countObjects(productType);
    }

    public void deleteProductById(Integer productID) throws Exception {
        Integer index = null;
        for (Product product : productList) {
            if (Objects.equals(product.getID(), productID)) {
                index = productList.indexOf(product);
            }
        }
        try {
            productList.remove((int) index);
        } catch (NullPointerException e){
            System.out.println("The selected ID is invalid");
        }
    }

    public ArrayList<Product> searchByType(ProductType type) //return list and "main" takes care of it?
    {
        var productsByTypeList = new ArrayList<Product>();
        for (var values : productList) {
            if (values.getType() == type) {
                productsByTypeList.add(values);
            }
        }
        return productsByTypeList;
    }

    public ArrayList<Product> searchByModel(String model) {
        ArrayList<Product> byModel = new ArrayList<>();
        for (Product element : productList) {
            if (element.getModel().equals(model)) {
                byModel.add(element);
            }
        }
        return byModel;
    }

    public ArrayList<Product> searchByManufacturer(String manufacturer) {
        ArrayList<Product> byManufacturer = new ArrayList<>();
        for (Product element : productList) {
            if (element.getManufacturer().equals(manufacturer)) {
                byManufacturer.add(element);
            }
        }
        return byManufacturer;
    }

    public ArrayList<Product> searchBySellingPrice(SortingType type) {
        ArrayList<Product> bySellingPrice = new ArrayList<>(productList);
        switch (type) {
            case Ascending -> bySellingPrice.sort(Comparator.comparing(Product::getSellingPrice));
            case Descending -> bySellingPrice.sort(Comparator.comparing(Product::getSellingPrice).reversed());
        }
        return bySellingPrice;
    }


    public ArrayList<Product> searchByPurchasePrice(SortingType type) {
        ArrayList<Product> byPurchasePrice = new ArrayList<>(productList);
        switch (type) {
            case Ascending -> byPurchasePrice.sort(Comparator.comparing(Product::getPurchasePrice));
            case Descending -> byPurchasePrice.sort(Comparator.comparing(Product::getPurchasePrice).reversed());
        }
        return byPurchasePrice;
    }

    public ArrayList<Product> searchByPurchasePriceRange(int priceMin, int priceMax) {
        ArrayList<Product> byPriceRange = new ArrayList<>();
        for (Product element : productList) {
            if (element.getPurchasePrice() >= priceMin && element.getPurchasePrice() <= priceMax) {
                byPriceRange.add(element);
            }
            byPriceRange.sort(Comparator.comparing(Product::getPurchasePrice));
        }
        return byPriceRange;
    }

    public ArrayList<Product> searchBySellingPriceRange(int priceMin, int priceMax) {
        ArrayList<Product> byPriceRange = new ArrayList<>();
        for (Product element : productList) {
            if (element.getSellingPrice() >= priceMin && element.getSellingPrice() <= priceMax) {
                byPriceRange.add(element);
            }
            byPriceRange.sort(Comparator.comparing(Product::getSellingPrice));
        }
        return byPriceRange;
    }

    private void initialize() {
        Smartphone smartphone1 = new Smartphone(
                "Apple",
                "iPhone15",
                "None",
                15,
                128,
                200,
                300);
        Smartphone smartphone2 = new Smartphone(
                "Samsung",
                "Galaxy S23",
                "none",
                11,
                128,
                100,
                500);

        Tablet tablet1 = new Tablet(
                "Apple",
                "iPad Pro",
                "none",
                12.9F,
                256,
                300,
                1200);

        Notebook notebook1 = new Notebook(
                "Lenovo",
                "Legion 5 Pro",
                "none",
                16,
                1024,
                1400,
                2000);

        this.addProduct(smartphone1);
        this.addProduct(smartphone2);
        this.addProduct(notebook1);
        this.addProduct(tablet1);
    }

    public List<Product> returnList() {
        return productList;
    }
}


