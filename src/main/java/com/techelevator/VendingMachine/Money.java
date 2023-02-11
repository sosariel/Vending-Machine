package com.techelevator.VendingMachine;

public class Money {

    private int moneyFed;

    public Money(){
        this.moneyFed = 0;
    }

    public void addMoney(int amount){
        this.moneyFed += amount;
    }

    public int getMoneyFed() {
        return this.moneyFed;
    }
}
