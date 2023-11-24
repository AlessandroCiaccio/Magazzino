import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Warehouse warehouse = new Warehouse();

    // If you're adding a search method add the proper information in the lines below
    public void searchBy(Warehouse warehouse, Cart cart) {
        String again = null;
        Scanner scanner = new Scanner(System.in);
        do {
            /*+
                "For search by             input : 6 \n" +*/

            System.out.println("""
                                  MENU'\s
                    To search by model input : 1\s
                    To search by manufacturer input : 2\s
                    To search by selling price input : 3\s
                    To search by purchase price input :  4\s
                    To search by type input : 5\s
                    To search by price range input : 7\s
                    To see the total of the cart input : 8\s
                    To confirm the purchase input  : 9""");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("What model do you want to search?");
                    String model = scanner.next();
                    ArrayList<Product> byModel = warehouse.searchByModel(model);
                    if (byModel.size() == 0) {
                        System.out.println("This model is not present in the warehouse");
                    } else {
                        System.out.println(byModel);
                    }
                }
                case 2 -> {
                    System.out.println("What manufacturer do you want to search?");
                    String manufacturer = scanner.next();
                    ArrayList<Product> byManufacturer = warehouse.searchByManufacturer(manufacturer);
                    if (byManufacturer.size() == 0) {
                        System.out.println("This manufacturer is not present in the warehouse");
                    } else {
                        System.out.println(byManufacturer);
                    }
                }
                case 3 -> {
                    System.out.println("""
                            Do you want the price in ascending or descending order \s
                            For ascending order input : 1\s
                            For descending order input : 2\s""");
                    int order = scanner.nextInt();
                    if (order != 1 && order != 2) {
                        System.out.println("Wrong input");
                    } else {
                        ArrayList<Product> bySellingPrice = warehouse.searchBySellingPrice(order);
                        if (bySellingPrice.size() == 0) {
                            System.out.println("This selling price is not present in the warehouse");
                        } else {
                            System.out.println(bySellingPrice);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("""
                            Do you want the price in ascending or descending order \s
                            For ascending order input : 1\s
                            For descending order input : 2\s""");
                    int order = scanner.nextInt();
                    if (order != 1 && order != 2) {
                        System.out.println("Wrong input");
                    } else {

                        ArrayList<Product> byPurchasePrice = warehouse.searchBySellingPrice(order);
                        if (byPurchasePrice.size() == 0) {
                            System.out.println("This purchase price is not present in the warehouse");
                        } else {
                            System.out.println(byPurchasePrice);
                        }
                    }
                }
                case 5 -> {
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
            /*case 6-> {
            }*/
                case 7 -> {
                    System.out.println("""
                            What price range do you want to search for\s
                            To search for purchase price input : 0
                            To search for selling price input : 1
                            """);
                    int whichRange = scanner.nextInt();
                    if (whichRange != 0 && whichRange != 1) {
                        System.out.println("Wrong input");
                    } else if (whichRange == 0) {
                        System.out.println("Insert the lower price of the price range");
                        int priceMin = scanner.nextInt();
                        System.out.println("Insert the higher price of the price range");
                        int priceMax = scanner.nextInt();
                        ArrayList<Product> byPriceRange = warehouse.searchByPurchasePriceRange(priceMin, priceMax);
                        if (byPriceRange.size() == 0) {
                            System.out.println("This purchase price is not present in the warehouse");
                        } else {
                            System.out.println(byPriceRange);
                        }
                    } else {
                        System.out.println("Insert the lower price of the price range");
                        int priceMin = scanner.nextInt();
                        System.out.println("Insert the higher price of the price range");
                        int priceMax = scanner.nextInt();
                        ArrayList<Product> byPriceRange = warehouse.searchBySellingPriceRange(priceMin, priceMax);
                        if (byPriceRange.size() == 0) {
                            System.out.println("This selling price is not present in the warehouse");
                        } else {
                            System.out.println(byPriceRange);
                        }
                    }
                }
                case 8 -> {
                    System.out.println("The total of the products in the cart is: " + cart.calculateTotalPrice());
                }
                case 9 -> {
                    cart = null;
                    System.gc();
                    cart = new Cart();
                }
                default -> {
                    System.out.println("Error: input not present in the system.");
                }
            }
            System.out.println("\nTo close input 0, otherwise press any key");
            again = scanner.next();
        } while (again != "0");
    }
}
