package task1.service;

import task1.Buyer;
import task1.Storage;

public class SellProduct {
    public static void sellProduct(final Buyer buyer, final Storage storage) {
        storage.getProducts().forEach((k, v) -> {
            buyer.getBill().getProducts().forEach((k1, v1) -> {
                if (k.equals(k1)) {
                    if (v1 <= v && v > 0) {
                        storage.getProducts().put(k, v - v1);
                    } else {
                        System.out.println("We don't have such amount of " + k.getName());
                    }
                }
                if(!storage.getProducts().containsKey(k1)){
                    System.out.println("We don't have " + k1.getName() + " in storage!");
                }
            });
            buyer.getBill().getProducts().entrySet()
                    .removeIf(entry -> entry.getValue() > v ||
                              !storage.getProducts().containsKey(entry.getKey()));
        });
    }
}
