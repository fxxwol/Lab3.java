package task1;

public class Buyer {
    private String name;
    private Bill bill;

    public Buyer(final Bill bill) {
        this.bill = bill;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(final Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "task1.Buyer{" +
                "name='" + name + '\'' +
                ", bill=" + bill +
                '}';
    }
}
