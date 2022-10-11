package task1;

import java.time.LocalDate;
import java.util.Map;

public class Bill {

    private Map<Product, Integer> products;
    private LocalDate date;

    public Bill(final Map<Product, Integer> products, final LocalDate date) {
        this.products = products;
        this.date = date;
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
        double total = 0;
        for (final Map.Entry<Product, Integer> e : products.entrySet()) {
            total += e.getKey().getPrice() * e.getValue();
        }
        return total;
    }
    @Override
    public String toString() {
        return " Bill{" + products +
                '}';
    }
}
