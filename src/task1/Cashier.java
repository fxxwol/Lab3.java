package task1;

public class Cashier {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Cashier(final String name) {
        this.name = name;
    }
    public Bill giveBill (final Buyer buyer){
        return buyer.getBill();
    }
}
