package application;

import java.util.Scanner;

import entities.GroceryList;
import entities.Product;
import enums.Delivery;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        GroceryList list = new GroceryList();

        int res;

        do{
            System.out.println("Opção 1 - Comprar");
            System.out.println("Opção 2 - Listar");
            System.out.println("Opção 3 - Atualizar");
            System.out.println("Opção 0 - Sair");
            res = sc.nextInt();

            switch (res) {
                case 1:
                    creatList(list);
                    res = 1;
                    break;
            
                case 2:
                    System.out.println(list);
                default:
                    break;
            }
        }while(res != 0);

        sc.close();
    }

    public static void creatList(GroceryList list) {

        Scanner sc = new Scanner(System.in);
        int res;

        do {
            System.out.println();
            System.out.print("Digite o nome do produto: ");
            String name = sc.next().toUpperCase();
            System.out.print("Digite o preço do produto: R$ ");
            Double price = sc.nextDouble();
            System.out.print("Digite a quantidade do produto: ");
            int qtd = sc.nextInt();

            Product product = new Product(name, price, qtd);

            System.out.println("Entrega  |  Retirada");
            Delivery delivery = Delivery.valueOf(sc.next().toUpperCase());

            list = new GroceryList(delivery);

            list.addProduct(product);

            System.out.println();
            System.out.println(product.getName() + " foi adicionado ao carrinho");

            System.out.println("1 - Continuar comprando | 2 - Sair");
            res = sc.nextInt();
        } while(res == 1);

        sc.close();
    }
}
