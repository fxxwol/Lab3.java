package task3;

import task1.Bill;
import task1.Buyer;
import task1.Product;
import task1.Storage;
import task1.service.BuyHistory;
import task3.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(final String[] args) {
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
            put(new Product("Soap", 16), 12);
        }};
        final Map<Product, Integer> billMap2 = new HashMap<>() {{
            put(new Product("Cheese", 45), 5);
            put(new Product("Biscuits", 13), 25);
            put(new Product("Soap", 16), 12);
        }};

        final Storage storage = new Storage(storageMap);
        final Bill billOfBuyer = new Bill(billMap, LocalDate.of(2022, 10, 2));
        final Bill billOfBuyer1 = new Bill(billMap1, LocalDate.of(2022, 10, 8));
        final Bill billOfBuyer2 = new Bill(billMap2, LocalDate.of(2022, 10, 8));

        final List<Bill> listOfBills = new ArrayList<>() {{
            add(billOfBuyer);
            add(billOfBuyer1);
        }};
        final List<Bill> listOfBills1 = new ArrayList<>() {{
            add(billOfBuyer1);
        }};
        final Buyer buyer = new Buyer(billOfBuyer1);
        final Buyer buyer1 = new Buyer(billOfBuyer1);

        System.out.println("Sort by name: \n" + SortProduct.sortByName(storage));
        System.out.println("Sort by price: \n" + SortProduct.sortByPrice(storage));
        System.out.println("Average price: " + AveragePrice.getAveragePrice(storage));

        final BuyHistory history = new BuyHistory(buyer, listOfBills);
        history.addBill(billOfBuyer2);
        final BuyHistory history1 = new BuyHistory(buyer1, listOfBills1);
        final List<BuyHistory> histories = new ArrayList<>() {{
            add(history);
            add(history1);
        }};

        System.out.println("All expenses from 01.10.22 to 09.10.2022: " +
                TimePeriodExpenses.getAllExpensesPerTime(history, LocalDate.of(2022, 10, 1),
                        LocalDate.of(2022, 10, 9)));
        System.out.println(TotalProductCountPerBuyer.getTotalProductCount(history));
        System.out.println(history.getListOfBills() + "\n" + history1.getListOfBills());
        System.out.println(PopularProduct.getPopularProduct(histories).getName());
        System.out.println(BestProfit.getBestProfitPerDay(LocalDate.of(2022, 10, 8), histories));
    }
}
