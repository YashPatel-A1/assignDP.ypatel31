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

        File fileB = new File("src/BuyerInfo");
        BufferedReader brB = new BufferedReader(new FileReader(fileB));

        File fileS = new File("src/SellerInfo");
        BufferedReader brS = new BufferedReader(new FileReader(fileS));

        String str;

        boolean allowUser = true;
        boolean hasBuyer = false;
        boolean hasSeller = false;

        while ((str= brB.readLine())!=null){
            String[] tempBuyer = str.split(":");
            sellerName.add(tempBuyer[0]);
            buyerPwd.add(tempBuyer[1]);
        }

        while ((str= brS.readLine())!=null){
            String[] tempSeller = str.split(":");
            sellerName.add(tempSeller[0]);
            buyerPwd.add(tempSeller[1]);
        }

        Scanner scName = new Scanner(System.in);
        System.out.println("Enter Username: ");
        String userName = scName.next();

        Scanner scPwd = new Scanner(System.in);
        System.out.println("Enter Password: ");
        String pwd = scPwd.next();

        Scanner scUType = new Scanner(System.in);
        System.out.println("Choose User Type:\t0 for Buyer\t1 for Seller:\nType: ");
        int userType = scUType.nextInt();

        user.userName = userName;
        user.userType = userType;

        for(int i=0;i<buyerName.size();i++){
            if(userName.equals(buyerName.get(i)) && pwd.equals(buyerPwd.get(i))){
                hasBuyer = true;
            }
        }

        for(int i=0;i<sellerName.size();i++){
            if(userName.equals(sellerName.get(i)) && pwd.equals(sellerPwd.get(i))){
                hasSeller = true;
            }
        }

        if(userType==0){
            if(hasBuyer){
                System.out.println("Logined as Buyer");
            }
            else {
                System.out.println("Invalid credentials");
                allowUser = false;
                System.exit(0);
            }
            Person buyer = new Buyer(new MeatProductMenu());
            System.out.println("Bridge Pattern is implemented: ");
            buyer.add();
            buyer.showMenu();
        }
        if(userType==1) {
            if(hasSeller){
                System.out.println("Logined as Seller");
            }
            else {
                System.out.println("Invalid credentials");
                allowUser = false;
                System.exit(0);
            }
            Person seller = new Seller(new MeatProductMenu());
            System.out.println("Bridge Pattern is implemented: ");
            seller.showMenu();
        }
        return user;
    }
}
