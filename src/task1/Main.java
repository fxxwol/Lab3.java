package task1;

import task1.service.BuyHistory;
import task1.service.GetProduct;
import task1.service.SellProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(final String[] args) {
        final Product soap = new Product("Soap", 16);
        final Product banana = new Product("Banana", 20);
        final Map<Product, Integer> storageMap = new HashMap<>() {{
            put(new Product("Banana", 20), 30);
            put(new Product("Apple", 15), 60);
            put(new Product("Orange", 18), 20);
            put(new Product("Soap", 16), 45);
            put(new Product("Cheese", 45), 15);
            put(new Product("Biscuits", 13), 78);
        }};
        final Map<Product, Integer> billMap = new HashMap<>() {{
            put(new Product("Banana", 20), 5);
            put(new Product("Apple", 15), 8);
            put(new Product("Soap", 16), 2);
        }};
        final Map<Product, Integer> billMap1 = new HashMap<>() {{
            put(new Product("Cheese", 45), 5);
            put(new Product("Apple", 15), 8);
            put(new Product("Soap", 16), 2);
        }};

        final Storage storage = new Storage(storageMap);
        final Bill billOfBuyer = new Bill(billMap);
        final Bill billOfBuyer1 = new Bill(billMap1);
        final List<Bill> listOfBills = new ArrayList<>(){{
            add(billOfBuyer);
        }};

        storage.removeProduct(soap);
        System.out.println(storage.getProducts());

        final Buyer buyer = new Buyer(billOfBuyer1);
        final Cashier cashier = new Cashier("Anna");
        System.out.println("Get Apple: " + GetProduct.getProduct(storage, storage.getProducts().keySet().iterator().next()));
        System.out.println("Amount of " + banana.getName() + " before sell: " + storage.getProducts().get(banana));
        System.out.println("Bill before sell: " + billOfBuyer);
        SellProduct.sellProduct(buyer, storage);
        System.out.println("Bill after sell: \n" + cashier.giveBill(buyer) + "\n Total price: " + cashier.giveBill(buyer).getTotalPrice());
        System.out.println("After sell: " + storage.getProducts().get(banana));

        storage.addProduct(soap, 30, storage);
        System.out.println(storage.getProducts());
        final BuyHistory history = new BuyHistory(buyer, listOfBills);
        System.out.println(history.saveBuyHistory());
    }
}
