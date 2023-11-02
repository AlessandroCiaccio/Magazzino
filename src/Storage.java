import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List productsList = new ArrayList<Product>();

    public Storage(Product prod) //to do: check if product is already present: increase quantity
    {
        productsList.add(prod);
    }
}
