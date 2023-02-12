package com.techelevator.VendingMachine;

import java.util.Map;
import java.util.TreeMap;

import java.io.FileReader;

public class Inventory
{
    private FileReader fileReaderObject;
    private TreeMap<String, Integer> inventoryList = new TreeMap<String, Integer>();

    public Inventory(FileReader fileReaderObject)
    {
        this.fileReaderObject =fileReaderObject;
        stocksVendingMachineAtStartup();
    }

    public void stocksVendingMachineAtStartup()
    {
        for (String[] item : fileReaderObject.inventoryAsArrayList())
        {
            int initialStock = 5;
            inventoryList.put(item[0], initialStock);
        }
    }

    public Map<String, Item> vendingMachineStock()
    {
        return fileReaderObject.createMapOfLocationAndItems();
    }

    public void substractFromInventory(String slotLocation)
    {
        inventoryList.put(slotLocation, inventoryList.get(slotLocation) - 1);
    }

    public int returnCurrentInventory(String slotLocation)
    {
        return inventoryList.get(slotLocation);
    }

    public Map<String, Integer> returnInventoryMap()
    {
        return inventoryList;
    }
}

