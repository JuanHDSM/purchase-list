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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : list) {
            sb.append(product);
        }
        return sb.toString();
    }
}
