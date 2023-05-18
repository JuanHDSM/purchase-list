package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;
import entities.PurchaseList;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        PurchaseList purchaseList = new PurchaseList();
        
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
    
           
    
            purchaseList.addProduct( new Product(name, price, quantity));

            System.out.println("1 - Continuar  |  0 - Sair");
            res = sc.nextInt();
            System.out.println();
        } while (res != 0);
    
        System.out.println();
        System.out.println("Lista de compras");
        System.out.println("---------------------------------------------------------------");
        System.out.println(purchaseList);


        String targetFolderStr = "c:\\temp";

        

        String targetFileStr = targetFolderStr + "\\list.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
            
                bw.write(purchaseList.toString());

            System.out.println("Lista criada em: " + targetFileStr);
        }
        catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        sc.close();
    }

}