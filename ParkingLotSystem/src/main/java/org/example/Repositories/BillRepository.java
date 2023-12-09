package org.example.Repositories;

import org.example.Models.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {
    private Map<Long, Bill> billMap = new HashMap<>();
    private Long prevId = 0L;
//
//    public BillRepository() {
//        saveBill(billMap.get(prevId));
//    }

    public Bill saveBill (Bill bill) {
        prevId++;
        bill.setId(prevId);
        billMap.put(prevId, bill);

        return bill;
    }
}
