import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int n;

        System.out.print("Enter the number of products: ");
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1) + " data: ");

            System.out.print("(c/u/i): ");
            char typeProduct = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (typeProduct == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            } else if (typeProduct == 'u') {
                sc.nextLine();

                System.out.print("Manufacture date: ");
                Date manufactureDate = sdf.parse(sc.nextLine());
                products.add(new UsedProduct(name, price, manufactureDate));
            }else{
                products.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("Price Tags: ");

        for(Product product : products){
            System.out.println(product.priceTag());
        }

    }
}