import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Warehouse warehouse = new Warehouse();

    // If you're adding a search method add the proper information in the lines below
    public void searchBy(Warehouse warehouse, Cart cart) {
        String again = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("             MENU' \n" +
                    "For search by model input : 1 \n" +
                    "For search by manufacturer input : 2 \n" +
                    "For search by selling price input : 3 \n" +
                    "For search by purchase price input :  4 \n" +
                    "For search by type input : 5 \n"/*+
                "For search by             input : 6 \n" +
                "For search by             input : 7 \n" */ +
                    "To see the total of the cart input : 8 \n" +
                    "To confirm the purchase : 9");

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
                }
                break;
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
                }
                break;
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
                }
                break;
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
                }
                break;
                case 5: {
                    System.out.println("What type of product are you looking for: ");
                    String type = scanner.next().toUpperCase();
                    boolean isValidType = ProductType.isAcceptedProductType(type); //we check if this type is valid
                    if (isValidType) {
                        var productsByType = warehouse.searchByType(ProductType.valueOf(type));
                        if (productsByType.isEmpty()) {
                            System.out.println("No products of type " + type);

                        }

                        System.out.println("Products of type: " + type);
                        for (var values : productsByType) {
                            System.out.println(values);
                        }
                    } else {
                        System.out.println("There is no type named \"" + type + "\".");
                    }
                }
                break;
            /*case 6: {
            break;
            }
            case 7: {
            break;
            }*/
                case 8: {
                    System.out.println("The total of the products in the cart is: " + cart.calculateTotalPrice());
                    break;
                }
                case 9: {
                    cart = null;
                    System.gc();
                    cart = new Cart();
                    break;
                }

                default: {
                    System.out.println("Error: input not present in the system.");
                }
                break;
            }
            System.out.println("\nTo close input 0, otherwise press any key");
            again = scanner.next();
        }
        while (again != "0");
    }
}
