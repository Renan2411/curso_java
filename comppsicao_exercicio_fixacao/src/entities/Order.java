package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static final SimpleDateFormat birthDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat momentFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;
    Client client;
    List<OrderItem> items = new ArrayList<>();

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
        this.moment = new Date();
    }

    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeItem(OrderItem item) {
        this.items.remove(item);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMARY: \n");
        sb.append("Order moment : ").append(momentFormat.format(this.moment)).append("\n");
        sb.append("Client: ").append(this.client.getName()).append(" (").append(birthDateFormat.format(this.client.getBirthDate())).append(") - ").append(this.client.getEmail()).append("\n");
        sb.append("Order Items \n");

        for (OrderItem item : items){
            sb.append(item.getProduct().getName()).append(", ").append(item.getPrice()).append(", Quantity: ").append(item.getQuantity()).append(", Subtotal: $").append( String.format("%.2f", item.subTotal())).append("\n");
        }

        sb.append("Total price: $").append(this.total());

        return sb.toString();
    }

    public double total() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.subTotal();
        }

        return total;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
