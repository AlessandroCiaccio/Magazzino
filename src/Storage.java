import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List productsList = new ArrayList<Product>();

    public Storage(Product prod) //to do: check if product is already present: increase quantity
    {
        if(productsList.contains(prod)){
            productsList.indexOf(prod).getQuantity() + prod.getQuantity();
            return;
        }
        productsList.add(prod);
    }

    public void printProducts()
    {
        if(productsList.isEmpty()){
            System.out.println("No products in storage.");
            return;
        }
        
        System.out.println("Products list:");
        for(var values : productsList){
            System.out.println(values);
        }
    }
}
