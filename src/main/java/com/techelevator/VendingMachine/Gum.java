package com.techelevator.VendingMachine;

public class Gum extends VendingMachineProducts{


    public Gum(String slot, String name, double price, String category) {
        super(slot, name, price, category);
    }

    @Override
    public void displayMessage() {
        System.out.println("Chew Chew, Pop!");
    }
}
