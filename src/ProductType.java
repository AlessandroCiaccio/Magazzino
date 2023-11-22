public enum ProductType {

    NOTEBOOK("Notebook"), SMARTPHONE("Smartphone"), TABLET("Tablet");

    private String type;

    private ProductType(String a) {
        this.type = a;
    }

    public static boolean isAcceptedProductType(String str) {
        try {
            ProductType.valueOf(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return type;
    }
}