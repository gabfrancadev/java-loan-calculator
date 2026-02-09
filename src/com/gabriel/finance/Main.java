package com.gabriel.finance;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int loanAmount = 0;
        float interestRate = 0;
        int years = 0;

        while (true) {
            System.out.print("Enter the loan amount (1k - 1M): ");
            loanAmount = scanner.nextInt();
            if (loanAmount >= 1000 && loanAmount <= 1000000) {
                break; 
            }
            System.out.println("Valor incorreto! Adicione um valor entre 1.000 e 1.000.000.");
        }

        while (true) {
            System.out.print("Enter the annual interest rate (in %): ");
            interestRate = scanner.nextFloat();
            if (interestRate > 0 && interestRate <= 30) {
                break;
            }
            System.out.println("Valor incorreto! Adicione um valor entre 0.1 e 30.");
        }

        while (true) {
            System.out.print("Enter the number of years: ");
            years = scanner.nextInt();
            if (years >= 1 && years <= 30) {
                break;
            }
            System.out.println("Valor incorreto! Adicione um valor entre 1 e 30.");
        }

        double monthlyInterestRate = interestRate / 1200;
        int numberOfPayments = years * 12;

        double monthlyPayment = loanAmount * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) / 
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String formattedMonthlyPayment = NumberFormat.getCurrencyInstance().format(monthlyPayment);

        System.out.println("\n--- Resumo do Empréstimo ---");
        System.out.println("O pagamento mensal é: " + formattedMonthlyPayment);
    }
}