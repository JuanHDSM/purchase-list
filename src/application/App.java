package application;

import java.util.Scanner;

import entities.GroceryList;
import entities.Product;
import enums.Priority;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Gostaria de iniciar a lista S/N? ");
        char res = sc.next().charAt(0);

        if(res == 'S') {
            creatList();
        }

        sc.close();
    }

    public static void creatList() {

        Scanner sc = new Scanner(System.in);

        GroceryList list = new GroceryList();

        System.out.print("Qual valor você gostaria de gastar? R$ ");
        Double maxValue = sc.nextDouble();
        String name = null;
        Double valorAtual = maxValue;

        do {
            sc.nextLine();
            System.out.print("Digite o nome do produto: ");
            name = sc.nextLine().toUpperCase();
            System.out.print("Digite o preço do produto: R$ ");
            Double price = sc.nextDouble();
            System.out.print("Digite a quantidade do produto: ");
            int qtd = sc.nextInt();
            System.out.print("Digite a prioridade do produto ALTA/MEDIA/BAIXA: ");
            Priority priority = Priority.valueOf(sc.next().toUpperCase());

            Product product = new Product(name, price, qtd, priority);

            maxValue -= product.subtotal();

            if(maxValue >= 0) {
                ((GroceryList) list).addProduct(product);
                System.out.println();
                System.out.printf("Saldo atualizado: %.2f%n%n", maxValue);
            }
            else {
                ((GroceryList) list).removeProduct(product);
                maxValue += product.subtotal();
                System.out.println();
                System.out.println("Seu saldo é insuficiente para esta compra, tente um produto com valor inferior.");
                System.out.printf("Saldo atualizado: %.2f%n%n" , maxValue);
            }

            valorAtual = maxValue;

        } while(valorAtual > 0);

        System.out.println();
        System.out.println("Lista de compras");
        System.out.println();
        System.out.println(list);

        updateList(list);

        sc.close();
    }

    public static void updateList(GroceryList list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Gostaria de remover ou modificar um produto da lista R/M? ");
        char res = sc.next().charAt(0);

        if(res == 'R') {
            sc.nextLine();
            System.out.println("Digite o nome do produto que gostaria de remover: ");
            String name = sc.nextLine().toUpperCase();

            System.out.println(list);

            while(hasProduct(list, name)) {
                System.out.println("ACHOU!");
                sc.next();
            }

        }

        sc.close();
    }

	public static boolean hasProduct(GroceryList list, String name) {
		Product emp = list.getProducts().stream().filter(x -> x.getName() == name).findFirst().orElse(null);
		return emp != null;
	}

}
