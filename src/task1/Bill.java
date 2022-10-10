package task1;

import java.util.Map;

public class Bill {

    private Map<Product, Integer> products;
    private double totalPrice;

    public Bill(final Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(final Map<Product, Integer> products) {
        this.products = products;
    }

    public double getTotalPrice(){
        for (final Map.Entry<Product, Integer> e : products.entrySet()) {
            totalPrice += e.getKey().getPrice() * e.getValue();
        }
        return totalPrice;
    }
    @Override
    public String toString() {
        return " Bill{" + products +
                '}';
    }
}
