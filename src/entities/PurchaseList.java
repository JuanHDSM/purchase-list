package entities;

import java.util.ArrayList;
import java.util.List;

public class PurchaseList {
    
    private Product product;

    private List<Product> list = new ArrayList<>();

    public PurchaseList() {
    }

    public PurchaseList(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getList() {
        return list;
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public void removeProduct(Product product) {
        list.remove(product);
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public double total() {
        double sum = 0.0;
        for (Product product : list) {
            sum += product.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Product product : list) {
            sb.append(product);
        }
        sb.append(String.format("Total: %.2f", total()));

        return sb.toString();
    }
}
