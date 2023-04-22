package com.techelevator;

import com.techelevator.VendingMachine.Inventory;
import com.techelevator.VendingMachine.Money;
import com.techelevator.VendingMachine.VendingMachineProducts;
import com.techelevator.view.VendingMenu;



public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";


	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT,};
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

	private VendingMenu menu;
	private Inventory inventory;
	private Money money;

	public VendingMachineCLI(VendingMenu menu, Inventory inventory, Money money) {
		this.menu = menu;
		this.inventory = inventory;
		this.money = money;
	}


	public void run() {
		boolean running = true;
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);


			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu();

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				running = false;
			}
		}
	}

	private void displayItems() {
		for(VendingMachineProducts item : inventory.getAllSlotItems()){
			menu.getOut().println(String.format("%-4s %-20s $%-6.2f %s", item.getSlot(), item.getName(), item.getPrice(), item.getCategory()));
		}
		menu.getOut().println();
	}

	private void purchaseMenu(){
		boolean running = true;
		while (running){
			String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				money.feedMoney();
			} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				selectProduct();
			} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
				running = false;
			}
		}
	}

	private void selectProduct(){
		displayItems();
		menu.getOut().println("Enter slot number:");
		menu.getOut().flush();
		String slot = menu.getIn().nextLine();
		VendingMachineProducts item = inventory.getSlotItem(slot);
		if (item != null){
			if (item.getPrice() <= money.getAmount()){
				money.subtractAmount(item.getPrice());
				menu.getOut().println("Dispensing: " + item.getName() + "\nCost: $" + item.getPrice() + "\nMoney remaining: $" + money.getAmount());
				item.displayMessage();
			} else {
				menu.getOut().println("Insufficient funds");
			}
		} else {
			menu.getOut().println("Invalid slot selected");
		}
		menu.getOut().flush();
	}


	public static void main(String[] args) {
		VendingMenu menu = new VendingMenu(System.in, System.out);
		Inventory inventory = new Inventory("vendingmachine.csv");
		Money money = new Money();
		VendingMachineCLI cli = new VendingMachineCLI(menu, inventory, money);
		cli.run();
	}
}
