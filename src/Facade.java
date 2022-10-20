package assignDP.src;

import java.io.File;
import java.io.IOException;

public class Facade {

    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;
    UserInfo info = new UserInfo();
    private Login lPerson;

    public boolean login() throws IOException {
        System.out.println("Facade Pattern is implemented: ");
        info = lPerson.loginMethod();
        return true;
    }

    public void addTrading(String userName, int userType, String productName){
        System.out.println("Method: addTrading");
    }


    public void viewTrading() { System.out.println("Method: viewTrading");   }

    public void decideBidding() { System.out.println("Method: decideBidding");   }

    public void discussBidding() { System.out.println("Method: discussBidding");   }

    public void submitBidding() { System.out.println("Method: submitBidding");   }

    public void remind() { System.out.println("Method: remind");   }

    public void createUser(UserInfoItem userinfoitem) {

    }

    public void createProductList() { System.out.println("Method: createProductList");   }

    public void attachProductToUser() { System.out.println("Method: attachProductToUser");   }

    public void selectProduct() { System.out.println("Method: selectProduct");   }

    public void productOperation() { System.out.println("Method: productOperation");   }


    public void Facade() throws IOException{
        DataBase();
        createProductList();
        lPerson = new Login();
    }

    public void DataBase() throws IOException{
        File dataBase = new File("src/dataBase.txt");
        if(dataBase.createNewFile()){}
        else{}
    }





}