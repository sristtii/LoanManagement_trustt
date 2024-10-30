package com.example.loan_management.customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanService {

    // Simulating a database with a Map
    private Map<Long, Customer> loanDatabase = new HashMap<>();
    private long currentId = 1;
    //USING COLLECTION OTHER THAN DB
    // Constructor to initialize the loanDatabase with some sample customers
    public LoanService() {
        // Adding sample customers
        loanDatabase.put(currentId++, new Customer("sristtiii", LocalDate.of(2004, 1, 4), 10000, 5.0, 3.0, 12));
        loanDatabase.put(currentId++, new Customer("harini", LocalDate.of(2003, 10, 12), 15000, 6.0, 4.5, 24));
    }
    public Customer findById(Long id) {
        return loanDatabase.get(id); // null the customer not there
    }
    public double emi(Customer customer) {
        if (customer.isMinor()) {
            throw new minorormajor("Not eligible for loan Customer is a child (not major).");
        }
        //EMI = P * r * (1 + r)^n / ((1 + r)^n - 1)
        double r = customer.getRequestedInterestRate() / 100;
        double R = r / 12;
        int n = customer.getTenure() * 12;
        return ( customer.getLoanAmount() * R * Math.pow(1 + R, n))
                / (Math.pow(1 + R, n) - 1);
    }

}