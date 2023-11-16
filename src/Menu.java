import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Warehouse warehouse = new Warehouse();

    // If you're adding a search method add the proper information in the lines below
    public void searchBy(Warehouse warehouse) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("These are your searchByMethods : \n" +
                "For search by model input : 1 \n" +
                "For search by manufacturer input : 2 \n" +
                "For search by selling price input : 3 \n" +
                "For search by purchase price input :  4 \n");
                /*"For search by             input : 5 \n" +
                "For search by             input : 6 \n" +
                "For search by             input : 7 \n" );*/

        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                System.out.println("What model do you want to search?");
                String model = scanner.next();
                ArrayList<Product> byModel = warehouse.searchByModel(model);
                if (byModel.size() == 0) {
                    System.out.println("This model is not present in the warehouse");
                } else {
                    System.out.println(byModel);
                }
                break;
            }
            case 2: {
                System.out.println("What manufacturer do you want to search?");
                String manufacturer = scanner.next();
                warehouse.searchByManufacturer(manufacturer);
                ArrayList<Product> byManufacturer = warehouse.searchByManufacturer(manufacturer);
                if (byManufacturer.size() == 0) {
                    System.out.println("This manufacturer is not present in the warehouse");
                } else {
                    System.out.println(byManufacturer);
                }
                break;
            }
            case 3: {
                System.out.println("Do you want the price in ascending or descending order  \n" +
                        "For ascending order input : 1 \n" +
                        "For descending order input : 2 ");
                int order = scanner.nextInt();
                if (order != 1 && order != 2) {
                    System.out.println("Wrong input");
                } else {
                    warehouse.searchBySellingPrice(order);
                    ArrayList<Product> bySellingPrice = warehouse.searchBySellingPrice(order);
                    if (bySellingPrice.size() == 0) {
                        System.out.println("This selling price is not present in the warehouse");
                    } else {
                        System.out.println(bySellingPrice);
                    }
                }
                break;
            }
            case 4: {
                System.out.println("Do you want the price in ascending or descending order  \n" +
                        "For ascending order input : 1 \n" +
                        "For descending order input : 2 ");
                int order = scanner.nextInt();
                if (order != 1 && order != 2) {
                    System.out.println("Wrong input");
                } else {
                    warehouse.searchByPurchasePrice(order);
                    ArrayList<Product> byPurchasePrice = warehouse.searchBySellingPrice(order);
                    if (byPurchasePrice.size() == 0) {
                        System.out.println("This purchase price is not present in the warehouse");
                    } else {
                        System.out.println(byPurchasePrice);
                    }
                }
                break;
            }

            /*case 5: {
            break;
            }
            case 6: {
            break;
            }
            case 7: {
            break;
            }*/
            default: {
                System.out.println("Error: input not present in the system.");
            }
            break;
        }
    }
}
