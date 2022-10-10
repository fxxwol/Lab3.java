package task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Storage {
    private Map<Product, Integer> products;

    public Storage(final Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(final Map<Product, Integer> products) {
        this.products = products;
    }

    public List<Product> getProductsList() {
        return new ArrayList<>(products.keySet());
    }

    public void addProduct(final Product productToAdd, final Integer amount, final Storage storage) {
        products.entrySet().stream()
                .filter(e -> e.getKey().equals(productToAdd))
                .findFirst()
                .ifPresent(p -> p.setValue(storage.getProducts().get(p.getKey()) + amount));
        if (!products.containsKey(productToAdd)) {
            products.put(productToAdd, amount);
        }
    }

    public void removeProduct(final Product productToRemove) {
        products.entrySet().removeIf(entry -> entry.getKey().equals(productToRemove));
    }
}
