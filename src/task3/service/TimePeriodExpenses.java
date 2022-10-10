package task3.service;
import task1.Bill;
import task1.service.BuyHistory;

import java.time.LocalDate;

public class TimePeriodExpenses {
    public static double getAllExpensesPerTime(final BuyHistory history, final LocalDate firstDate, final LocalDate secondDate){
        return history.getListOfBills()
                .stream()
                .filter(e -> e.getDate().isAfter(firstDate) && e.getDate().isBefore(secondDate))
                .mapToDouble(Bill::getTotalPrice)
                .sum();
    }
}
