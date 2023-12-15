import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

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
}