import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tablet implements Product {
    private String type;
    private String productor;
    private String model;
    private String description;
    private float display;
    private float memory;
    private float purchasePrice;
    private float sellingPrice;
    private int id;

    public Tablet(String type,
                  String productor,
                  String model,
                  String description,
                  float display,
                  float memory,
                  float purchasePrice,
                  float sellingPrice,
                  int id) {
        this.type = type;
        this.productor = productor;
        this.model = model;
        this.description = description;
        this.display = display;
        this.memory = memory;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getDisplay() {
        return display;
    }

    public void setDisplay(float display) {
        this.display = display;
    }

    public float getMemory() {
        return memory;
    }

    public void setMemory(float memory) {
        this.memory = memory;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void searchByProductor(List<Product> list) {
        List<Product> byProductor = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've entered search by productor. Please enter what productor are you interested in");
        String productor = scanner.nextLine();
        for (Product element : list) {
            if (element.getManufacturer().equals(productor)) {
                byProductor.add(element);
            }
        }
        System.out.println(byProductor);
    }

    @Override
    public String getManufacturer() {
        return null;
    }

    public void searchByModel(List<Product> list) {
        List<Product> byModel = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've entered search by model. Please enter what model are you interested in");
        String model = scanner.nextLine();
        for (Product element : list) {
            if (element.getModel().equals(model)) {
                byModel.add(element);
            }
        }
        System.out.println(byModel);
    }

    public void searchBySellingPrice(List<Product> list) {
        List<Product> bySellingPrice = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've entered search by productor. Please enter what productor are you interested in");
        int sellingPrice = scanner.nextInt();
        for (Product element : list) {
            if (element.getSellingPrice() == (sellingPrice)) {
                bySellingPrice.add(element);
            }
        }
        System.out.println(bySellingPrice);
    }

    public void searchByPurchasePrice(List<Product> list) {
        List<Product> byPurchasePrice = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've entered search by productor. Please enter what productor are you interested in");
        int purchasePrice = scanner.nextInt();
        for (Product element : list) {
            if (element.getPurchasePrice() == (purchasePrice)) {
                byPurchasePrice.add(element);
            }
        }
        System.out.println(byPurchasePrice);
    }
}

