package com.techelevator.VendingMachine;

public class Candy extends VendingMachineProducts{


    public Candy(String slot, String name, double price, String category) {
        super(slot, name, price, category);
    }

    @Override
    public void displayMessage() {
        System.out.println("Munch Munch, Mmm Mmm Good!");
    }
}
