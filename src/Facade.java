package assignDP.src;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class Facade {

    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;
    UserInfo info = new UserInfo();

    ArrayList<String> productList = new ArrayList<String>();
    ArrayList<Integer> productType = new ArrayList<Integer>();
    ArrayList<String> idx0 = new ArrayList<String >();
    ArrayList<String> idx1 = new ArrayList<String>();

    private Login lPerson;


    public boolean login() throws IOException {
        System.out.println("Facade Pattern is implemented: ");
        info = lPerson.loginMethod();
        return true;
    }

    public void addTrading(String userName, int userType, String productName) throws IOException {
        System.out.println("Method: addTrading");

        int bidCost = decideBidding(userType);
        if(userType==0){
            boolean bidFinal = discussBidding();;
            if(bidFinal){
                submitBidding(userName,userType,productName,bidCost);
            }
            else{   System.out.println("Invalid operation");    }
        }
        else{
            submitBidding(userName,userType,productName,bidCost);
        }
    }


    public void viewTrading() throws FileNotFoundException, IOException {
        System.out.println("Method: viewTrading");

        File file = new File("src\\dataBase");
        BufferedReader tradeingBR = new BufferedReader(new FileReader(file));
        ArrayList<Integer>alUserType=new ArrayList<Integer>();
        ArrayList<String>alUserName=new ArrayList<String>();
        ArrayList<String>alProductName=new ArrayList<String>();
        ArrayList<Integer>bidAddedAL=new ArrayList<Integer>();

        String str;

        while((str=tradeingBR.readLine())!=null){
            String[] data = str.split("---");
            alUserName.add(data[0]);
            alUserType.add(Integer.parseInt(data[1]));
            alProductName.add(data[2]);
            bidAddedAL.add(Integer.parseInt(data[3]));
        }
        System.out.println("Display Tradings method");

    }

    public int decideBidding(int userType) {
        System.out.println("Method: decideBidding");
        Scanner sc = new Scanner(System.in);
        int costB = 0;
        if(userType==0){
            System.out.println("Provide bid value: ");
            costB = sc.nextInt();
        }
        if(userType==1){
            System.out.println("Provide base value of product: ");
            costB = sc.nextInt();
        }
        return costB;
    }

    public boolean discussBidding(){
        System.out.println("Method: discussBidding");
        return false;
    }

    public void submitBidding(String userName, int userType, String productName, int bidCost) throws IOException {
        System.out.println("Method: submitBidding");

        FileWriter fw = new FileWriter("src\\dataBase",true);
        String bidDetails = "\n"+userName+" "+Integer.toString(userType)+" "+productName+" "+Integer.toString(bidCost);
        fw.flush();
        fw.write(bidDetails);
        fw.close();

    }

    public void remind() { System.out.println("Method: remind");   }

    public void createUser(UserInfoItem userinfoitem) {

    }

    public void createProductList() throws IOException {
        //System.out.println("Method: createProductList");

        File file = new File("src/ProductInfo.txt");
        BufferedReader productListBR = new BufferedReader(new FileReader(file));
        String str;

        while((str=productListBR.readLine())!=null){
            productList.add(str);
            String getProduct[] = str.split(":");
            productType.add((getProduct[0].equals("Meat"))?0:1);
            productList.add(getProduct[1]);
        }
    }

    public void attachProductToUser() throws IOException {
        System.out.println("Method: attachProductToUser");

        File file = new File("src/UserProduct.txt");
        BufferedReader attachProListBR = new BufferedReader(new FileReader(file));
        String str;

        while((str=attachProListBR.readLine())!=null){
            String attachPro[] = str.split(":");
            idx0.add(attachPro[0]);
            idx1.add(attachPro[1]);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Product Type: ");
        int prodType = sc.nextInt();
        System.out.println("Trading Menu: ");
        System.out.println("Add Trading operation 0: ");
        System.out.println("View Trading operation 1: ");
        System.out.println("Remove Trading operation 2: ");
        int operationTrade = sc.nextInt();

        System.out.println(" Your selected product is "+productList.get(prodType));
        
        int productCategory = productType.get(prodType);

        if(operationTrade == 0){
            if(productCategory==0){
                ProductMenu meatProdMenu = new MeatProductMenu();
                meatProdMenu.showAddButton();
                addTrading(info.userName,info.userType,productList.get(prodType));
            }
            if(productCategory==1){
                ProductMenu proProdMenu = new ProduceProductMenu();
                proProdMenu.showAddButton();
                addTrading(info.userName,info.userType,productList.get(prodType));
            }
        }
        if(operationTrade==1){
            if(productCategory==0){
                ProductMenu meatProdMenu = new MeatProductMenu();
                System.out.println("Factory Pattern is implemented: ");
                meatProdMenu.showViewButton();
                viewTrading();
            }
            if(productCategory==1){
                ProductMenu proProdMenu = new ProduceProductMenu();
                System.out.println("Factory Pattern is implemented: ");
                proProdMenu.showViewButton();
                viewTrading();
            }

        }

    }



    public void selectProduct() { System.out.println("Method: selectProduct");   }

    public void productOperation() { System.out.println("Method: productOperation");   }


    public Facade() throws IOException{
        //System.out.println("Facade constructor: ");
        DataBase();
        createProductList();
        lPerson = new Login();
    }

    public void DataBase() throws IOException{
        File dataBase = new File("src/dataBase");
        if(dataBase.createNewFile()){}
        else{}
    }





}