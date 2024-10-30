package com.example.loan_management.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;
    //generic  T
    @PostMapping("/calculate")
    public ResponseEntity<?> calculateLoan(@RequestBody Customer customer)  {

        try {
            //instaead the instance is unneccary= directly created customer as autowired used
            //Customer customer = new Customer(name, LocalDate.parse(dob), loanAmount, requestedInterestRate, actualInterestRate, tenure);
            double monthlyInstallment = loanService.emi(customer);
            return ResponseEntity.ok("Monthly Installment: " + monthlyInstallment);
        } catch (minorormajor e) {
            return ResponseEntity.badRequest().body(e.getMessage());//E.MESSAGE is null heere
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getLoanById(@PathVariable Long id) {
        Customer customer = loanService.findById(id); // Assuming you have this method in LoanService
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}