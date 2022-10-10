package task1;

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
    public void addProduct(final Product productToAdd, final Integer amount, final Storage storage){
        for (final Map.Entry<Product, Integer> e : products.entrySet()) {
            if(e.getKey().equals(productToAdd)){
                e.setValue(storage.getProducts().get(e.getKey()) + amount);
            }
            else {
                products.put(productToAdd, amount);
            }
        }
    }
    public void removeProduct(final Product productToRemove){
        products.entrySet().removeIf(entry -> entry.getKey().equals(productToRemove));
        /*for (final Map.Entry<Product, Integer> e : products.entrySet()) {
            if(e.getKey().equals(productToRemove)){
                products.remove(productToRemove);
            }
            else {
                System.out.println(productToRemove.getName() +  " isn't in the storage");
            }
        }*/
    }
}
