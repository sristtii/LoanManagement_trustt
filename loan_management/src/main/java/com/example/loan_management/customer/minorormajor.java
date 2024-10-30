package com.example.loan_management.customer;

//RUNTIME= handling in try catch itself and throws
public class minorormajor extends RuntimeException {
    public minorormajor(String message){//the outcome error message is message here
        //subclass extending a superclass
        super(message);
    }

}
