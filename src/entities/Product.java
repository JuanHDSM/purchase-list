package entities;

import enums.Priority;

public class Product {
    
    private String name;
    private Double price;
    private Integer qtd;
    private Priority priority;

    public Product() {
    }

    public Product(String name, Double price, Integer qtd, Priority priority) {
        this.name = name;
        this.price = price;
        this.qtd = qtd;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPrice(Priority priority) {
        this.priority = priority;
    }
    
    public Double subtotal() {
        return qtd * price;    

    } 

    @Override
    public String toString() {
        return "Nome do produto: " + name + ", preço do produto: " + String.format("%.2f", price) + ", quantidade: " + qtd + ", Prioridade: " + priority + ", subtotal: R$ " + String.format("%.2f%n", subtotal());
    }    
    
}