package assignDP.src;

public class Buyer extends Person {

    @Override
    public void showMenu() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ProductMenu CreatProductMenu() {
        // TODO Auto-generated method stub
        return null;
    }

    public Buyer(ProductMenu productMenu){
        super((MeatProductMenu) productMenu);
    }
    
}
