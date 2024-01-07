import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    // If you're adding a search method add the proper information in the lines below
    public void searchBy(Cart cart) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("""
                                  MENU'\s
                    1:   To print all products in the store\s          
                    2:   To search by model\s
                    3:   To search by manufacturer\s
                    4:   To search by selling price\s
                    5:   To search by purchase price\s
                    6:   To search by type\s
                    7:   To search by price range\s
                    8:   To add to cart\s
                    9:   To remove from cart\s 
                    10:  To print the products in the cart\s
                    11:  To see the total of the cart\s
                    12:  To confirm the purchase\s
                                        
                    0:   To close the program""");

            choice = scanner.nextInt();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    WarehouseManager.getWarehouse().printProducts();
                }
                case 2 -> {
                    System.out.println("What model do you want to search?");
                    scanner.nextLine(); //flush scanner
                    String model = scanner.nextLine().toString();
                    System.out.println(model);
                    try {
                        ArrayList<Product> byModel = WarehouseManager.getWarehouse().searchByModel(model);
                        if (byModel.isEmpty()) {
                            System.out.println("This model is not present in the warehouse");
                        } else {
                            System.out.println(byModel);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("This model is not present in the warehouse");
                    }
                }
                case 3 -> {
                    System.out.println("What manufacturer do you want to search?");
                    String manufacturer = scanner.next();
                    try {
                        ArrayList<Product> byManufacturer = WarehouseManager.getWarehouse().searchByManufacturer(manufacturer);
                        if (byManufacturer.size() == 0) {
                            System.out.println("There are no products from this manufacturer");
                        } else {
                            System.out.println(byManufacturer);
                        }
                    } catch (NullPointerException e) {
                        System.out.println("There are no products from this manufacturer");
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
                        SortingType type;
                        if (order == 1) {
                            type = SortingType.Ascending;
                        } else
                            type = SortingType.Descending;
                        ArrayList<Product> bySellingPrice = WarehouseManager.getWarehouse().searchBySellingPrice(type);
                        if (bySellingPrice.size() == 0) {
                            System.out.println("This selling price is not present in the warehouse");
                        } else {
                            for (Product elemento : bySellingPrice) {
                                System.out.println(elemento);
                            }
                        }
                    }
                }
                case 5 -> {
                    System.out.println("""
                            Do you want the price in ascending or descending order \s
                            For ascending order input : 1\s
                            For descending order input : 2\s""");
                    int order = scanner.nextInt();
                    if (order != 1 && order != 2) {
                        System.out.println("Wrong input");
                    } else {
                        SortingType type;
                        if (order == 1) {
                            type = SortingType.Ascending;
                        } else
                            type = SortingType.Descending;
                        ArrayList<Product> byPurchasePrice = WarehouseManager.getWarehouse().searchByPurchasePrice(type);
                        if (byPurchasePrice.size() == 0) {
                            System.out.println("This purchase price is not present in the warehouse");
                        } else {
                            for (Product elemento : byPurchasePrice) {
                                System.out.println(elemento);
                            }
                        }
                    }
                }
                case 6 -> {
                    System.out.println("What type of product are you looking for: ");
                    String type = scanner.next().toUpperCase();
                    boolean isValidType = ProductType.isAcceptedProductType(type); //we check if this type is valid
                    if (isValidType) {
                        var productsByType = WarehouseManager.getWarehouse().searchByType(ProductType.valueOf(type));
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
                        ArrayList<Product> byPriceRange = WarehouseManager.getWarehouse().searchByPurchasePriceRange(priceMin, priceMax);
                        if (byPriceRange.size() == 0) {
                            System.out.println("This purchase price is not present in the warehouse");
                        } else {
                            for (Product elemento : byPriceRange) {
                                System.out.println(elemento);
                            }
                        }
                    } else {
                        System.out.println("Insert the lower price of the price range");
                        int priceMin = scanner.nextInt();
                        System.out.println("Insert the higher price of the price range");
                        int priceMax = scanner.nextInt();
                        ArrayList<Product> byPriceRange = WarehouseManager.getWarehouse().searchBySellingPriceRange(priceMin, priceMax);
                        if (byPriceRange.size() == 0) {
                            System.out.println("This selling price is not present in the warehouse");
                        } else {
                            for (Product elemento : byPriceRange) {
                                System.out.println(elemento);
                            }
                        }
                    }
                }
                case 8 -> {
                    System.out.println("Input the id of the product that you want to add : ");
                    int idToAdd = scanner.nextInt();
                    try {
                        cart.addToCart(idToAdd);
                        WarehouseManager.getWarehouse().deleteProductById(idToAdd);
                    } catch (NullPointerException e) {
                        System.out.println("This product is not present in the warehouse");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("There are no products with this id in the warehouse");
                    }
                }
                case 9 -> {
                    System.out.println("Input the id of the product that you want to remove : ");
                    int idToRemove = scanner.nextInt();
                    try {
                        WarehouseManager.getWarehouse().addProduct(cart.removeFromCart(idToRemove));
                        WarehouseManager.getWarehouse().orderingList();
                    } catch (NullPointerException e) {
                        System.out.println("This product is not present in the cart");
                    }

                }
                case 10 -> {
                    if (!cart.getProducts().isEmpty()) {
                        cart.printProducts();
                    } else
                        System.out.println("The cart is empty");
                }
                case 11 -> {
                    if (!cart.getProducts().isEmpty()) {
                        System.out.println("The total of the products in the cart is: " + cart.calculateTotalPrice());
                    } else
                        System.out.println("The cart is empty");
                }
                case 12 -> {
                    cart = null;
                    System.gc();
                    cart = new Cart();
                }
                default -> System.out.println("Error: input not present in the system.");
            }
            /*System.out.println("\nTo close the menu input 0, otherwise press any key");
            again = scanner.next();*/
        } while (choice != 0);
    }
}
