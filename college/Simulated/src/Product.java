public class Product {
    
    private int code;
    private String description;
    private double unityValue;
    private double amountSelled;
    private double total;

    public Product(int codigo,String description, double value, double amountSelled){
        this.code = codigo;
        this.description = description;
        this.unityValue = value;
        this.amountSelled = amountSelled;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnityValue() {
        return this.unityValue;
    }

    public void setUnityValue(double unityValue) {
        this.unityValue = unityValue;
    }

    public double getAmountSelled() {
        return this.amountSelled;
    }

    public void setAmountSelled(double amountSelled) {
        this.amountSelled = amountSelled;
    }

    public double getTotal(){
        return this.total;
    }

    public void calculateTotal(){
        this.total = this.amountSelled * this.unityValue;
    }


}
