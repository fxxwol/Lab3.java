package task3.service;

import task1.Bill;
import task1.Product;
import task1.service.BuyHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class TotalProductCountPerBuyer {
    public static Map<Product, Integer> getTotalProductCount(final BuyHistory history) {
        final List<Map<Product, Integer>> eachProductTotalCount = new ArrayList<>();
        for (final Bill b : history.getListOfBills()) {
            eachProductTotalCount.add(b.getProducts());
        }
        return eachProductTotalCount.stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue)));
    }
}
