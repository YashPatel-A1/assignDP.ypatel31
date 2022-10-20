package assignDP.src;

public abstract class Person {

    private ProductMenu theProductMenu;

    public abstract void showMenu();
    
    public void showAddButton(){    System.out.println("Method: showAddButton");    }

    public void showViewButton(){    System.out.println("Method: showViewButton");    }

    public void showRadioButton(){    System.out.println("Method: showRadioButton");    }

    public void showLabels(){

    }

    public abstract ProductMenu CreatProductMenu();

    public void add(){
        System.out.println("Add item to ProductMenu");
    }

    public Person(MeatProductMenu productMenu){

    }
}
