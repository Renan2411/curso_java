package entities;

public class OutSourcedEmployee extends Employee {
    private final Double BONUS = 1.10;

    private Double additionalCharge;

    public OutSourcedEmployee(){}

    public OutSourcedEmployee(String name, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public Double payment(){
        return super.payment() + (this.additionalCharge * BONUS);
    }

    public Double getAdditionalCharge(){
        return this.additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge){
        this.additionalCharge = additionalCharge;
    }
}
