package task2;

import task1.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(final String[] args) {
        final Product soap = new Product("Soap", 16);
        final Map<Product, Integer> storageMap = new HashMap<>() {{
            put(new Product("Banana", 20), 30);
            put(new Product("Apple", 15), 60);
            put(new Product("Orange", 18), 20);
            put(new Product("Cheese", 45), 15);
            put(new Product("Biscuits", 13), 78);
        }};

        final Storage storage = new Storage(storageMap);
        final Report report = new Report(storage);

        try {
            if (report.validateProduct(soap)) {
                storage.addProduct(soap, 30);
                System.out.println(soap.getName() + " was added to storage");
            }
        } catch (final EmptyNameException | PriceException e) {
            e.printStackTrace();
        }
        System.out.println(storage.getProducts());
        try{
            if(report.validate()){
                System.out.println("Storage is ok");
            }
        }catch(final EmptyNameException | PriceException | ProductAmountException e){
            e.printStackTrace();
        }
    }
}
