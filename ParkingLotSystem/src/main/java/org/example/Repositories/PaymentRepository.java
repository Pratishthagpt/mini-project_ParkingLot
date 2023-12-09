package org.example.Repositories;

import org.example.Models.Payment;
import org.example.Models.PaymentMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PaymentRepository {
    private Map<Long, Payment> paymentMap = new HashMap<>();
    public Payment findById (Long id) {
        return paymentMap.get(id);
    }


    private Long prevId = 0L;
    public void savePayment(Long id, PaymentMode mode, int amount) {
        prevId++;
        Payment payment = new Payment();
        payment.setId(prevId);
        payment.setPaymentMode(mode);
        payment.setAmount(amount);
        paymentMap.put(prevId, payment);
    }

}
