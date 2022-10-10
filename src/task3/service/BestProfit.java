package task3.service;

import task1.Bill;
import task1.service.BuyHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BestProfit {
    public static double getBestProfitPerDay(final LocalDate date, final List<BuyHistory> allHistories) {
        final List<Bill> allBills = new ArrayList<>();
        allHistories.forEach((h) -> allBills.addAll(h.getListOfBills()));

        final List<Bill> allBillsPerDay = allBills
                .stream()
                .filter(b -> b.getDate().equals(date))
                .collect(Collectors.toList());
        return allBillsPerDay
                .stream()
                .max(Comparator.comparing(Bill::getTotalPrice))
                .get().getTotalPrice();
    }
}
