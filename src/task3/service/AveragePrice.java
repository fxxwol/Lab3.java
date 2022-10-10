package task3.service;

import task1.Product;
import task1.Storage;

public class AveragePrice {
    public static double getAveragePrice(final Storage storage) {
        return storage.getProductsList()
                .stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(-1);
    }
}
