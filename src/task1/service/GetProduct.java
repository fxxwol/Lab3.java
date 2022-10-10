package task1.service;

import task1.Product;
import task1.Storage;

public class GetProduct {
    public static Product getProduct(final Storage storage, final Product productToGet){
        return storage.getProducts().keySet()
                .stream()
                .filter(e -> e.equals(productToGet))
                .findFirst()
                .orElseThrow();
    }
}
