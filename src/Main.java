package assignDP.src;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {
        int run = 1;
        while(run==1){

            System.out.println("You are in main Method");
            Facade facadeDP = new Facade();
            facadeDP.login();

            ProductIterator prodIterator = new ProductIterator();

            System.out.println("Choose product from list: ");
            ListIterator lstIterator;
            int i = 0;


            for(lstIterator = prodIterator;lstIterator.hasNext();){

                String listProd = (String)lstIterator.Next();
                System.out.println(i+": "+listProd);
                i++;
            }


            System.out.println("\nIterator Pattern is implemented: \n");
            facadeDP.attachProductToUser();

            System.out.println("\nVisitor Pattern is implemented: ");
            NodeVisitor nodeVisitor = new Reminder();
            nodeVisitor.visitProduct(new Product());
            nodeVisitor.visitTrading(new Trading());


            System.out.println("To EXIT\tEnter: 0\tElse: 1");
            Scanner sc = new Scanner(System.in);
            run = sc.nextInt();
        }
    }
}
