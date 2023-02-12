package com.techelevator.VendingMachine;

public class Drink extends Item
{
    public Drink(String name, String price)
    {
        super(name, price);
    }

    @Override
    public String getSound()
    {
        return "\"Glug Glug, Chug Chug\"";
    }
}
