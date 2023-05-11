package entities;

import java.util.ArrayList;
import java.util.List;

import enums.Delivery;

public class GroceryList {
    
    private List<Product> products =  new ArrayList<>();
    private Delivery delivery;

    public GroceryList() {
    }

    public GroceryList(Delivery delivery) {
        this.delivery = delivery;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public List<Product> getList() {
        return products;
    }

    public void addProduct (Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public boolean filterProduct(List<Product> list, String name) {
        Product prod =  list.stream().filter(x -> x.getName() == name).findFirst().orElse(null);
        return prod != null;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double total() {
        double sum = 0.0;

        for (Product product : products) {
            sum += product.subtotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        int id = 0;
        StringBuilder sb = new StringBuilder();

        for (Product product : products) {
            id++;
            sb.append(id);
            sb.append(" - ");
            sb.append(product);
        }

        return sb.toString();
    }

}
