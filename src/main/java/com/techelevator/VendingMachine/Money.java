package com.techelevator.VendingMachine;

import java.util.Scanner;

public class Money {

    private double amount;

    public Money(){
        amount = 0;
    }

    public void feedMoney(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount to deposit: ");
        double addedAmount = Double.parseDouble(scanner.nextLine());
        while (addedAmount < 0){
            System.out.println("Please enter a valid amount");
            addedAmount = Double.parseDouble(scanner.nextLine());
        }
        amount += addedAmount;
        System.out.println("Current money provided: $" + amount);
    }

    public double getAmount() {
        return amount;
    }

    public void subtractAmount(double amountToSubtract){
        amount -= amountToSubtract;
    }


}
