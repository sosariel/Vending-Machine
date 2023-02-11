package com.techelevator;

import com.techelevator.VendingMachine.Money;
import com.techelevator.view.VendingMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


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
	private Money money;

	public VendingMachineCLI(VendingMenu menu) {
		this.menu = menu;
		this.money = new Money();
	}

	public void run() {
		boolean running = true;
		while (running) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			// A switch statement could also be used here.  Your choice.
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayItems();
				// display vending machine items
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				purchaseMenu();
				// do purchase
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				running = false;
			}
		}
	}

	private void displayItems() {
		try {
			Scanner scanner = new Scanner(new File("vendingmachine.csv"));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				menu.getOut().println(line);
			}
			scanner.close();
		} catch (FileNotFoundException e){
			menu.getOut().println("File not found");
		}
	}

	private void purchaseMenu(){
		boolean inPurchaseMenu = true;
		while (inPurchaseMenu){
			String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

			if(purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)){
			menu.getOut().println("Enter amount to deposit:");
			menu.getOut().flush();
			try{
				int amount = Integer.parseInt(menu.getIn().nextLine());
				money.addMoney(amount);
				menu.getOut().println("Current money provided: $" + money.getMoneyFed());
			} catch (NumberFormatException e){
				menu.getOut().println("Please enter a valid amount");
			}
			} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)){

			} else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)){
				inPurchaseMenu = false;
			}
		}
	}


	public static void main(String[] args) {
		VendingMenu menu = new VendingMenu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
