package com.example.loan_management.customer;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.time.Period;

public class Customer {
    private String name;
    private LocalDate dob;
    private double loanAmount;
    private double requestedInterestRate;
    private double actualInterestRate;
    private int tenure;
    private boolean isMinor;
    //constructor with no parramneter and without id

    public Customer() {
    }
    public Customer(LocalDate dob, double loanAmount, double requestedInterestRate, double actualInterestRate, int tenure, boolean isMinor) {
        this.dob = dob;
        this.loanAmount = loanAmount;
        this.requestedInterestRate = requestedInterestRate;
        this.actualInterestRate = actualInterestRate;
        this.tenure = tenure;
        this.isMinor = isMinor;
    }

    //constructor with parrameters
    public Customer(String name, LocalDate dob, double loanAmount, double requestedInterestRate, double actualInterestRate, int tenure) {
        this.name = name;
        this.dob = dob;
        this.loanAmount = loanAmount;
        this.requestedInterestRate = requestedInterestRate;
        this.actualInterestRate = actualInterestRate;
        this.tenure = tenure;
        this.isMinor = check_Minor(dob);
    }
    //checking age of the customer (check minor major)
    //simple method
    private boolean check_Minor(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() < 18;
    }
    //adding getter and setter with to string

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getRequestedInterestRate() {
        return requestedInterestRate;
    }

    public void setRequestedInterestRate(double requestedInterestRate) {
        this.requestedInterestRate = requestedInterestRate;
    }

    public double getActualInterestRate() {
        return actualInterestRate;
    }

    public void setActualInterestRate(double actualInterestRate) {
        this.actualInterestRate = actualInterestRate;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public boolean isMinor() {
        return isMinor;
    }

    public void setMinor(boolean minor) {
        isMinor = minor;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", loanAmount=" + loanAmount +
                ", requestedInterestRate=" + requestedInterestRate +
                ", actualInterestRate=" + actualInterestRate +
                ", tenure=" + tenure +
                ", isMinor=" + isMinor +
                '}';
    }
}
