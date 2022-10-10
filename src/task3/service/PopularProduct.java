package task3.service;

import task1.Product;
import task1.service.BuyHistory;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class PopularProduct {
    public static Product getPopularProduct(final List<BuyHistory> allHistories){
        final List<Map<Product, Integer>> totalSell = new ArrayList<>();
        allHistories.forEach((h)-> totalSell.add(TotalProductCountPerBuyer.getTotalProductCount(h)));

        final Map<Product, Integer> mergedTotalSell = totalSell.stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, summingInt(Map.Entry::getValue)));

        final Optional<Map.Entry<Product, Integer>> maxEntry =  mergedTotalSell.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()
                );
        return maxEntry.get().getKey();
    }
}
