package com.example.loan_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementApplication.class, args);
		/*try {
			//trying out without db
			Loan loan = new Loan("sristiiii", "15/05/2005", 120000, 7.9, 12.0, 10);
			System.out.println(loan);
			System.out.println("Monthly Installment based on Requested Interest Rate: " + loan.calculateMonthlyInstallment());
			System.out.println("Monthly Installment based on Actual Interest Rate: " + loan.calculateActualMonthlyInstallment());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}*/
	}

}
