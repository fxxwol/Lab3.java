package task2;

import task1.Product;
import task1.Storage;

public class Report {
    private Storage storage;

    public Report(final Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(final Storage storage) {
        this.storage = storage;
    }

    public boolean validateProduct(final Product product) throws EmptyNameException, PriceException {
        if (product.getName().isEmpty()) {
            throw new EmptyNameException("Name can't be empty");
        }
        if (product.getPrice() <= 0) {
            throw new PriceException("Price should be greater than 0");
        }
        return true;
    }

    public boolean validate() throws ProductAmountException, EmptyNameException, PriceException {
        storage.getProducts().forEach((k, v) -> {
            if (v < 0) {
                try {
                    throw new ProductAmountException("Amount can't be less than 0");
                } catch (final ProductAmountException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                validateProduct(k);
            } catch (final EmptyNameException | PriceException e) {
                e.printStackTrace();
            }
        });
        return true;
    }
}
