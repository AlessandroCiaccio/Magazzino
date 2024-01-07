import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Smartphone implements Product {

    private String manufacturer;
    private String model;
    private String description;
    private float display;
    private float memory;
    private float purchasePrice;
    private float sellingPrice;
    private Integer ID = null;
    ProductType type;

    public Smartphone(String manufacturer, String model, String description, float display, float memory, float purchasePrice, float sellingPrice) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.description = description;
        this.display = display;
        this.memory = memory;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.type = ProductType.SMARTPHONE;
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
        return "Smartphone{" +
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
        if (!(o instanceof Smartphone that)) return false;
        return Float.compare(getDisplay(), that.getDisplay()) == 0 && Float.compare(getMemory(), that.getMemory()) == 0 && Float.compare(getPurchasePrice(), that.getPurchasePrice()) == 0 && Float.compare(getSellingPrice(), that.getSellingPrice()) == 0 && Objects.equals(getManufacturer(), that.getManufacturer()) && Objects.equals(getModel(), that.getModel()) && Objects.equals(getDescription(), that.getDescription()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacturer(), getModel(), getDescription(), getDisplay(), getMemory(), getPurchasePrice(), getSellingPrice(), getType());
    }
}

