import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Smartphone implements Product {

    private String type;
    private String manufacturer;
    private String model;
    private String description;
    private float display;
    private float memory;
    private float purchasePrice;
    private float sellingPrice;
    private int id;

    public Smartphone(String type,
                      String manufacturer,
                      String model,
                      String description,
                      float display,
                      float memory,
                      float purchasePrice,
                      float sellingPrice,
                      int id) {
        this.type = type;
        this.manufacturer = manufacturer;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String productor) {
        this.manufacturer = productor;
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

    @Override
    public String toString() {
        return "Smartphone{" +
                "type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", display=" + display +
                ", memory=" + memory +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", id=" + id +
                '}';
    }

    @Override
    public void searchByModel(List<Product> list) {
        List <Product> byModel = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've entered search by model. Please enter what model are you interested in");
        String model = scanner.nextLine();
        for (Product element : list){
            if(element.getModel().equals(model)){
                byModel.add(element);
            }
        }
        System.out.println(byModel);
    }


    @Override
    public void searchByProductor(List<Product> list) {
        List <Product> byProductor = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("You've entered search by productor. Please enter what productor are you interested in");
        String productor = scanner.nextLine();
        for (Product element : list){
            if(element.getManufacturer().equals(productor)){
                byProductor.add(element);
            }
        }
        System.out.println(byProductor);
        }
    }

