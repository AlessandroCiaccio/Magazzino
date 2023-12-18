import org.junit.*;

import java.util.ArrayList;

public class WarehouseTest {

    @Test
    public void ifIAddAProductAndIsAdded() {
        Warehouse warehouse = new Warehouse();
        Smartphone smartphone1 = new Smartphone(
                "Apple",
                "iPhone15",
                "None",
                15,
                128,
                200,
                300);
        Boolean check = warehouse.addProduct(smartphone1);
        Assert.assertTrue(check);
    }

    @Test
    public void ifIAddAProductAndIsNull() {
        Warehouse warehouse = new Warehouse();
        Smartphone smartphone1 = null;
        Boolean check = warehouse.addProduct(smartphone1);
        Assert.assertFalse(check);
    }

    @Test
    public void checkIfListReturnedBySearchByTypeIsNotNull() {
        Warehouse warehouse = new Warehouse();
        ProductType productType = ProductType.NOTEBOOK;
        ArrayList<Product> resultList = warehouse.searchByType(productType);
        Assert.assertNotNull(resultList);
    }

    @Test
    public void checkIfListReturnedBySearchByTypeHasCorrectType() {
        Warehouse warehouse = new Warehouse();
        ProductType productType = ProductType.NOTEBOOK;
        ArrayList<Product> resultList = warehouse.searchByType(productType);
        Boolean isDifferentType = !resultList
                .stream()
                .filter(product -> product.getType() != productType)
                .toList()
                .isEmpty();
        
        Assert.assertFalse(isDifferentType);
    }
}