package entities;

public class ImportedProduct extends Product{

    private Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFree) {
        super(name, price);
        this.customsFee = customsFree;
    }

    @Override
    public String priceTag(){
        return this.name + " $ " + String.format("%.2f", this.totalPrice()) + " (Customs fee: $ " + this.customsFee + ")";
    }

    public Double totalPrice(){
        return this.price + this.customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
}
