package task1.service;

import task1.Bill;
import task1.Buyer;
import java.util.List;

public class BuyHistory {
private Buyer buyer;
private List<Bill> bills;

    public BuyHistory(final Buyer buyer, final List<Bill> listOfBills) {
        this.buyer = buyer;
        this.bills = listOfBills;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(final Buyer buyer) {
        this.buyer = buyer;
    }

    public List<Bill> getListOfBills() {
        return bills;
    }

    public void setListOfBills(final List<Bill> listOfBills) {
        this.bills = listOfBills;
    }
public void addBill(final Bill billToAdd){
    bills.add(billToAdd);
}
    public List<Bill> saveBuyHistory(){
        bills.add(buyer.getBill());
        return bills;
    }

    @Override
    public String toString() {
        return "buyer=" + buyer +
                ", listOfBills=" + bills +
                '}';
    }
}
