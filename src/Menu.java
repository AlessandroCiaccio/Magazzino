import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Warehouse warehouse = new Warehouse();

    public void searchBy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("These are your searchByMethods : \n" +
                "For search by model input : 1 \n" +
                "For search by productor input : 2 \n" +
                "For search by selling price input : 3 \n" +
                "For search by purchase price input :  4 \n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("What model do you want to search?");
                String model = scanner.nextLine();
               ArrayList<Product> byModel = warehouse.searchByModel(model);
               if(byModel.size() == 0){
                   System.out.println("This model is not present in the warehouse");
               }
               else {
                   System.out.println(byModel);
               }
            }
            case 2: {
                System.out.println("What manufacturer do you want to search?");
                String manufacturer = scanner.nextLine();
                warehouse.searchByManufacturer(manufacturer);
                ArrayList<Product> byManufacturer = warehouse.searchByManufacturer(manufacturer);
                if(byManufacturer.size() == 0){
                    System.out.println("This manufacturer is not present in the warehouse");
                }
                else {
                    System.out.println(byManufacturer);
                }
            }
            case 3: { System.out.println("What selling price do you want to search?");
                int sellingPrice = scanner.nextInt();
                warehouse.searchBySellingPrice(sellingPrice);
                ArrayList<Product> bySellingPrice = warehouse.searchBySellingPrice(sellingPrice);
                if(bySellingPrice.size() == 0){
                    System.out.println("This selling price is not present in the warehouse");
                }
                else {
                    System.out.println(bySellingPrice);
                }
            }
            case 4: {System.out.println("What purchase price do you want to search?");
                int purchasePrice = scanner.nextInt();
                warehouse.searchByPurchasePrice(purchasePrice);
                ArrayList<Product> byPurchasePrice = warehouse.searchBySellingPrice(purchasePrice);
                if(byPurchasePrice.size() == 0){
                    System.out.println("This purchase price is not present in the warehouse");
                }
                else {
                    System.out.println(byPurchasePrice);
                }
            }
            case 5: {
            }
            default: {

            }
        }
    }
}
