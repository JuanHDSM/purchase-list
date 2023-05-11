package entities;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {
    
    private List<Product> products =  new ArrayList<>();
    private Product product;

    public GroceryList() {
    }

    public GroceryList(Product product) {
        super();
        this.product = product;
    }

    public Product getProduct() {
        return product;
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

    public Object stream() {
        return null;
    }

}
