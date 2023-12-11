import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    // If you're adding a search method add the proper information in the lines below
    public void searchBy(Warehouse warehouse, Cart cart) {
        Scanner scanner = new Scanner(System.in);
        String again;
        do {
            System.out.println("""
                                  MENU'\s
                    0:  To print all products in the store\s          
                    1:  To search by model\s
                    2:  To search by manufacturer\s
                    3:  To search by selling price\s
                    4:  To search by purchase price\s
                    5:  To search by type\s
                    6:  To search by price range\s
                    7:  To add to cart\s
                    8:  To remove from cart\s 
                    9:  To print the products in the cart\s
                    10: To see the total of the cart\s
                    11: To confirm the purchase""");

            int choice = scanner.nextInt();
            switch (choice) {
                case 0 -> {
                    warehouse.printProducts();
                }
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
                case 6 -> {
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
                case 7 -> {
                    System.out.println("Input the id of the product that you want to add : ");
                    int idToAdd = scanner.nextInt();
                    cart.addToCart(idToAdd);
                    WarehouseManager.getWarehouse().deleteProductById(idToAdd);
                }
                case 8 -> {
                    System.out.println("Input the id of the product that you want to remove : ");
                    int idToRemove = scanner.nextInt();
                    cart.removeFromCart(idToRemove);
                }
                case 9 -> {
                    cart.printProducts();
                }
                case 10 ->
                        System.out.println("The total of the products in the cart is: " + cart.calculateTotalPrice());
                case 11 -> {
                    cart = null;
                    System.gc();
                    cart = new Cart();
                }
                default -> System.out.println("Error: input not present in the system.");
            }
            System.out.println("\nTo close the menu input 0, otherwise press any key");
            again = scanner.next();
        } while (!Objects.equals(again, "0"));
    }
}
