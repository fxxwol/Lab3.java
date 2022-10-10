package task1.service;

import task1.Bill;

import java.util.List;

public class SaveBuyHistory {
    private List<Bill> listBill;

    public SaveBuyHistory(final List<Bill> listBill) {
        this.listBill = listBill;
    }

    public List<Bill> getListBill() {
        return listBill;
    }

    public void setListBill(final List<Bill> listBill) {
        this.listBill = listBill;
    }

    public void addNewCheckInHistory(final Bill bill){
        listBill.add(bill);
    }
}
