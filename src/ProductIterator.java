package assignDP.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductIterator implements ListIterator{

    int prodLst;
    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if(prodLst<prod.size()){
            return true;
        }
        return false;
    }

    @Override
    public Object Next() {
        // TODO Auto-generated method stub
        if(this.hasNext()){
            return prod.get(prodLst++);
        }
        return null;
    }

    @Override
    public void MoveToHead() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Remove() {
        // TODO Auto-generated method stub
        
    }

    ArrayList<String> prod = new ArrayList<String>();

    public ProductIterator() throws IOException{
        File file = new File("src/ProductInfo.txt");
        //System.out.println("ProductIterator constructor: ");
        System.out.println("Iterator Pattern is implemented: ");
        BufferedReader  prodIterBR = new BufferedReader(new FileReader(file));
        String str;

        while((str = prodIterBR.readLine())!=null){
            prod.add(str);
        }
        prodIterBR.close();
    }
}