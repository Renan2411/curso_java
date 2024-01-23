package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class UsedProduct extends Product{
    private Date manufactureDate;

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        return this.name + "(used) $ " + this.price + " (Manufacture date: " + sdf.format(this.manufactureDate) + ")";
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
}
