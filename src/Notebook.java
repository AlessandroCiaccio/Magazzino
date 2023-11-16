import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Notebook implements Product {
    private String manufacturer;
    private String model;
    private String description;
    private float display;
    private float memory;
    private float purchasePrice;
    private float sellingPrice;
    private int id;


    public Notebook(String manufacturer,
                    String model,
                    String description,
                    float display,
                    float memory,
                    float purchasePrice,
                    float sellingPrice,
                    int id) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.display = display;
        this.memory = memory;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.id = id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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
        return "Notebook{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", display=" + display +
                ", memory=" + memory +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", id=" + id +
                '}';
    }
}
