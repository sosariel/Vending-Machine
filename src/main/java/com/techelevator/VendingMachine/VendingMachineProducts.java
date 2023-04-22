package com.techelevator.VendingMachine;


public class VendingMachineProducts {

    private String slot;
    private String name;
    private double price;
    private String category;

    public VendingMachineProducts(String slot, String name, double price, String category) {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void displayMessage(){
        System.out.println("Quote");
    }


}
