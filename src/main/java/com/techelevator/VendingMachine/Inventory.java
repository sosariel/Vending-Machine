package com.techelevator.VendingMachine;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<VendingMachineProducts> items;

    public Inventory(String fileName){
        items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String slot = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String category = parts[3];
                switch (category){
                    case "Chip":
                        items.add(new Chip(slot, name, price, category));
                        break;
                    case "Candy":
                        items.add(new Candy(slot, name, price, category));
                        break;
                    case "Drink":
                        items.add(new Drink(slot, name, price, category));
                        break;
                    case "Gum":
                        items.add(new Gum(slot, name, price, category));
                        break;
                    default:
                        items.add(new VendingMachineProducts(slot, name, price, category));
                        break;
                }

            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public List<VendingMachineProducts> getAllSlotItems() {
        return items;
    }

    public VendingMachineProducts getSlotItem(String slot){
        for (VendingMachineProducts item : items){
            if(item.getSlot().equals(slot)){
                return item;
            }
        }
        return null;
    }


}
