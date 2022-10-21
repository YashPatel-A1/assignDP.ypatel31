package assignDP.src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<String> buyerName = new ArrayList<>();
    ArrayList<String> sellerName = new ArrayList<>();
    ArrayList<String> buyerPwd = new ArrayList<>();
    ArrayList<String> sellerPwd = new ArrayList<>();

    public UserInfo loginMethod() throws IOException{
        UserInfo user = new UserInfo();

        File fileB = new File("src/BuyerInfo.txt");
        BufferedReader brB = new BufferedReader(new FileReader(fileB));

        File fileS = new File("src/SellerInfo.txt");
        BufferedReader brS = new BufferedReader(new FileReader(fileS));

        String str;

        boolean allowUser = true;
        boolean hasBuyer = false;
        boolean hasSeller = false;

        while ((str= brB.readLine())!=null){
            String[] tempBuyer = str.split(":");
            buyerName.add(tempBuyer[0]);
            buyerPwd.add(tempBuyer[1]);
        }

        while ((str= brS.readLine())!=null){
            String[] tempSeller = str.split(":");
            sellerName.add(tempSeller[0]);
            sellerPwd.add(tempSeller[1]);
        }

        Scanner scName = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String uName = scName.next();

        Scanner scPwd = new Scanner(System.in);
        System.out.println("Enter Password: ");
        String pwd = scPwd.next();

        Scanner scUType = new Scanner(System.in);
        System.out.println("Choose User Type:\t0 for Buyer\t1 for Seller:\nType: ");
        int uType = scUType.nextInt();

        user.userName = uName;
        user.userType = uType;

        for(int i=0;i<buyerName.size();i++){
            if(uName.equals(buyerName.get(i)) && pwd.equals(buyerPwd.get(i))){
                hasBuyer = true;
            }
        }

        for(int i=0;i<sellerName.size();i++){
            if(uName.equals(sellerName.get(i)) && pwd.equals(sellerPwd.get(i))){
                hasSeller = true;
            }
        }

        if(uType==0){
            if(hasBuyer==true){
                System.out.println("Logged in system as Buyer\n");
            }
            else {
                System.out.println("Invalid credentials");
                System.exit(0);
            }
            Person buyer = new Buyer(new MeatProductMenu());
            System.out.println("Bridge Pattern is implemented: ");
            buyer.add();
            buyer.showMenu();
        }
        else if(uType==1) {
            if(hasSeller==true){
                System.out.println("Logined in system as Seller\n");
            }
            else {
                System.out.println("Invalid credentials");
                allowUser = false;
                System.exit(0);
            }
            Person seller = new Seller(new MeatProductMenu());
            System.out.println("\nBridge Pattern is implemented: ");
            seller.showMenu();
        }
        //System.out.println("User: " +user);
        return user;
    }
}
