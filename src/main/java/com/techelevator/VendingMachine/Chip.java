package com.techelevator.VendingMachine;

public class Chip extends VendingMachineProducts {


    public Chip(String slot, String name, double price, String category) {
        super(slot, name, price, category);
    }

    @Override
    public void displayMessage() {
        System.out.println("Crunch Crunch, It's Yummy!");
    }


}


