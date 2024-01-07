import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Tablet implements Product {
    private String manufacturer;
    private String model;
    private String description;
    private float display;
    private float memory;
    private float purchasePrice;
    private float sellingPrice;
    private Integer ID = null;
    ProductType type;


    public Tablet(String manufacturer,
                  String model,
                  String description,
                  float display,
                  float memory,
                  float purchasePrice,
                  float sellingPrice) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.display = display;
        this.memory = memory;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        type = ProductType.TABLET;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
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

    @Override
    public float getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    @Override
    public float getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void setID(int id) {
        this.ID = id;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", display=" + display +
                ", memory=" + memory +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                ", ID=" + ID +
                ", type=" + type +
                '}';
    }

    @Override
    public ProductType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tablet tablet)) return false;
        return Float.compare(getDisplay(), tablet.getDisplay()) == 0 && Float.compare(getMemory(), tablet.getMemory()) == 0 && Float.compare(getPurchasePrice(), tablet.getPurchasePrice()) == 0 && Float.compare(getSellingPrice(), tablet.getSellingPrice()) == 0 && Objects.equals(getManufacturer(), tablet.getManufacturer()) && Objects.equals(getModel(), tablet.getModel()) && Objects.equals(getDescription(), tablet.getDescription()) && getType() == tablet.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacturer(), getModel(), getDescription(), getDisplay(), getMemory(), getPurchasePrice(), getSellingPrice(), getType());
    }
}
