
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    @Test
    public void checkIfListReturnedBySearchByModelIsNotNull() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> resultList = warehouse.searchByModel("Legion 5 Pro");
        Assert.assertNotNull(resultList);
    }

    @Test
    public void checkIfListReturnedBySearchByModelIsNullWithInputNull() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> resultList = warehouse.searchByModel(null);
        Assert.assertNotNull(resultList);
    }

    @Test
    public void checkIfListReturnedBySearchByModelIsEmpty() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> resultList = warehouse.searchByModel(null);
        Assert.assertTrue(resultList.isEmpty());
    }

    @Test
    public void checkIfListReturnedBySearchByManufacturerIsNotNull() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> resultList = warehouse.searchByManufacturer("Apple");
        Assert.assertNotNull(resultList);
    }

    @Test
    public void checkIfListReturnedBySearchByManufacturerIsNullWithInputNull() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> resultList = warehouse.searchByManufacturer(null);
        Assert.assertNotNull(resultList);
    }

    @Test
    public void checkIfListReturnedBySearchByManufacturerIsEmpty() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> resultList = warehouse.searchByManufacturer(null);
        Assert.assertTrue(resultList.isEmpty());
    }

    //    @Test @Deprecated
//    public void checkIfList1ReturnedSearchBySellingPriceIsCorrect() {
//        Warehouse warehouse = new Warehouse();
//        ArrayList<Product> resultList = warehouse.searchBySellingPrice(1);
//        ArrayList<Product> sortedList = new ArrayList<>();
//        Smartphone smartphone1 = new Smartphone(
//                "Apple",
//                "iPhone15",
//                "None",
//                15,
//                128,
//                200,
//                300);
//        smartphone1.setID(1);
//        Smartphone smartphone2 = new Smartphone(
//                "Samsung",
//                "Galaxy S23",
//                "none",
//                11,
//                128,
//                100,
//                500);
//        smartphone2.setID(2);
//
//        Tablet tablet1 = new Tablet(
//                "Apple",
//                "iPad Pro",
//                "none",
//                12.9F,
//                256,
//                300,
//                1200);
//        tablet1.setID(4);
//
//        Notebook notebook1 = new Notebook(
//                "Lenovo",
//                "Legion 5 Pro",
//                "none",
//                16,
//                1024,
//                1400,
//                2000);
//        notebook1.setID(3);
//
//        sortedList.add(smartphone1);
//        sortedList.add(smartphone2);
//        sortedList.add(notebook1);
//        sortedList.add(tablet1);
//        sortedList.sort(Comparator.comparing(Product::getSellingPrice));
//        Assert.assertEquals(resultList, sortedList);
//    }
    @Test
    public void testIfSortingIsAscendingWithAscending() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> orderedList = warehouse.searchBySellingPrice(SortingType.Ascending);
        ArrayList<Product> secondList = new ArrayList<>();
        secondList.addAll(orderedList);
        secondList.sort(Comparator.comparing(Product::getSellingPrice));
        Assert.assertEquals(orderedList, secondList);
    }

    @Test
    public void testIfSortingIsAscendingWithDescending() {
        Warehouse warehouse = new Warehouse();
        ArrayList<Product> orderedList = warehouse.searchBySellingPrice(SortingType.Descending);
        ArrayList<Product> secondList = new ArrayList<>();
        secondList.addAll(orderedList);
        secondList.sort(Comparator.comparing(Product::getSellingPrice).reversed());
        Assert.assertEquals(orderedList, secondList);
    }
}