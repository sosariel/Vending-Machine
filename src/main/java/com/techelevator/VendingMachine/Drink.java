package com.techelevator.VendingMachine;

public class Drink extends VendingMachineProducts{


    public Drink(String slot, String name, double price, String category) {
        super(slot, name, price, category);
    }

    @Override
    public void displayMessage() {
        System.out.println("Glug Glug, Chug Chug!");
    }
}
