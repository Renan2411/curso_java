import entities.Order;
import entities.enums.OrderStatus;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Instanciando direto com a ENUM
        Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

        //Instanciando com String
        Order order2 = new Order(1080, new Date(), OrderStatus.valueOf("SHIPPED"));

        System.out.println(order);
        System.out.println(order2);

    }
}