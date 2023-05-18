package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.PurchaseList;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        PurchaseList list;
        int res = 0;

        do {
            System.out.println("DIGITE OS DADOS DOS PRODUTOS");
            System.out.println("---------------------------------------------------------------");
            System.out.print("Digie o nome do produto: ");
            String name = sc.next();
            System.out.print("Digite o preço do produto: ");
            Double price =  sc.nextDouble();
            System.out.print("Digite a quantidade do Produto: ");
            int quantity = sc.nextInt();
    
            Product product = new Product(name, price, quantity);
    
            list = new PurchaseList(product);
    
            list.addProduct(product);

            System.out.println("1 - Continuar  |  0 - Sair");
            res = sc.nextInt();
        } while (res != 0);


        System.out.println();
        System.out.println("Lista de compras");
        System.out.println(list);

        sc.close();
    }

}