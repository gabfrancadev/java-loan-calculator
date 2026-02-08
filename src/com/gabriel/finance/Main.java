package com.gabriel.finance;


import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan amount: ");
        int loanAmount = scanner.nextInt();

        System.out.print("Enter the annual interest rate (in %): ");
        float interestRate = scanner.nextFloat();

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double monthlyInterestRate = interestRate / 1200;

        double monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - Math.pow(1 + monthlyInterestRate, -years * 12));

        String formattedMonthlyPayment =
                NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("The monthly payment is " + formattedMonthlyPayment);
    }
}