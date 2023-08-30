import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Client client;
        Order order;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Birth Date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        client = new Client(name, email, birthDate);

        System.out.println();

        System.out.println("Enter order data");

        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        order = new Order(status, client);

        System.out.print("How many items to this order: ");
        int n = sc.nextInt();

        System.out.println();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            Product product;

            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            product = new Product(productName, price);

            OrderItem orderItem = new OrderItem(quantity, price, product);

            order.addItem(orderItem);
        }

        System.out.println();
        System.out.println(order);
    }
}