package task1.service;

import task1.Bill;
import task1.Buyer;
import java.util.List;

public class BuyHistory {
private Buyer buyer;
private List<Bill> listOfBills;

    public BuyHistory(final Buyer buyer, final List<Bill> listOfBills) {
        this.buyer = buyer;
        this.listOfBills = listOfBills;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(final Buyer buyer) {
        this.buyer = buyer;
    }

    public List<Bill> getListOfBills() {
        return listOfBills;
    }

    public void setListOfBills(final List<Bill> listOfBills) {
        this.listOfBills = listOfBills;
    }

    public List<Bill> saveBuyHistory(){
        listOfBills.add(buyer.getBill());
        return listOfBills;
    }
}
