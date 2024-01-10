import java.util.List;

interface Product {

    public String getModel();

    public void setModel(String model);

    public String getDescription();

    public void setDescription(String description);

    public float getPurchasePrice();

    public void setPurchasePrice(float purchasePrice);

    public float getSellingPrice();

    public void setSellingPrice(float sellingPrice);

    public String getManufacturer();

    public void setManufacturer(String manufacturer);

    public void setID(int id);

    public Integer getID();

    public ProductType getType();

}
