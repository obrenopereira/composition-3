package application;

import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner read = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);


        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = read.nextLine();
        System.out.print("Email: ");
        String email = read.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(read.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");

        OrderStatus status = OrderStatus.valueOf(read.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order");
        int N = read.nextInt();

        for (int i=0; i<N; i++){
            System.out.println("Enter #" + (i+1) + " item data");
            System.out.print("Product name: ");
            read.nextLine();
            String productName = read.nextLine();
            System.out.println("Product price: ");
            double productPrice = read.nextDouble();
            System.out.println("Quantity: ");
            int quantity = read.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem it = new OrderItem(quantity, productPrice, product);
            order.addItems(it);

        }

        System.out.println();
        System.out.println(order);

    }

}
