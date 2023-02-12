package com.techelevator.VendingMachine;

public class Chip extends Item
{
    public Chip(String name, String price)
    {
        super(name, price);
    }

    @Override
    public String getSound()
    {
        return "\"Crunch Crunch, It's Yummy!\"";
    }
}
