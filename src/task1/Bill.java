package task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bill {

    private Map<Product, Integer> products;
    private double totalPrice;
    private LocalDate date;

    public Bill(final Map<Product, Integer> products, final LocalDate date) {
        this.products = products;
        this.date = date;
        for (final Map.Entry<Product, Integer> e : products.entrySet()) {
            totalPrice += e.getKey().getPrice() * e.getValue();
        }
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(final Map<Product, Integer> products) {
        this.products = products;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public double getTotalPrice(){
        return totalPrice;
    }
    public List<Product> getProductsList() {
        return new ArrayList<>(products.keySet());
    }
    @Override
    public String toString() {
        return " Bill{" + products +
                '}';
    }
}
