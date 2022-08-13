package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date Date;
    private OrderStatus status;
    private Client client;

    List<OrderItem> items = new ArrayList<>();

    public Order(){}

    public Order(java.util.Date date, OrderStatus status, Client client) {
        Date = date;
        this.status = status;
        this.client = client;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItems(OrderItem item){
        items.add(item);
    }
    public void removeItems(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0.0;
        for(OrderItem it : items){
            sum += it.subTotal();
        }

        return sum;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(Date) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }







}
