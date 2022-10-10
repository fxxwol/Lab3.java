package task3.service;

import task1.Product;
import task1.Storage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortProduct {
    public static List<Product> sortByName(final Storage storage){
        return storage.getProductsList()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }
    public static List<Product> sortByPrice(final Storage storage){
        return storage.getProductsList()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }
}
