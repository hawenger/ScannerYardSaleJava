import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.text.DecimalFormat;

//Hannah Wenger

public class YardSaleScanner {

	public static void main(String[] args) {
			
			double money = 53.00; //Can be changed, user buy power
			
			Scanner askJeeves = new Scanner(System.in);
			
			System.out.println("\n\nHello.\nUser7434 to purchase some of your ebay items.\n");
			double postPurchaseFunds = yardSale(askJeeves, money);
			String formattedMoney = moneyFormatter((money - postPurchaseFunds));
			System.out.println("\nUser7434 spent a total of $" + (formattedMoney) + " on your store.\n\nThanks for junking!");

	}
	
	// Method for Validating Item Price User Input
	
	public static double itemPrice(Scanner s, String item) {
		while(true) {
			System.out.println("\nHow much would you like to sell " + item + " for?");
			if(s.hasNextDouble()) {
				double price = s.nextDouble();
				s.nextLine();
				if(price > 0) {

					return price;
				} else {
					s.nextLine();
					System.out.println("\nInvalid price of $" + price + ". Enter a price greater than $0.");
				}
			} else {
				s.nextLine();
				System.out.println("\nWoops. Invalid input. Try again.");
			}
			
		}
		
	}
	
	//Method for Validating Item Quantity User Input
	
	public static int itemQuantity(Scanner s, double price) {
	while(true) {
		System.out.println("\nHow many would you like to sell?");
			if(s.hasNextInt()) { 
				int quantity = s.nextInt();
				s.nextLine();
				if(quantity > 0) {
					return quantity;
				} else {
					s.nextLine();
					System.out.println("\nInvalid quantity of " + quantity + ". Enter a numeric quantity greater than 1.");
				}
			} else {
				s.nextLine();
				System.out.println("\nWoops. Invalid input. Try again");
			}
		}
	}
	
	//Method to calculate remaining money after purchase is made
	public static double walletCalculation(int quantity, double price, double remainingMoney) {
		remainingMoney = remainingMoney - (quantity * price);
		
		return remainingMoney;
	}
	
	//Method to return boolean if purchase was valid
	public static boolean validPurchase(int quantity, double price, double remainingMoney) {
		if(price > 10 || remainingMoney - (quantity * price) < 0) {
			return false;
		} else {
			return true;
		}
				
	}
	
	//Method for array selection randomization
	public static int randomNumber(int arrayLength) { 
		Random rand = new Random();
		int randNum = rand.nextInt(arrayLength);
		return randNum;
	}
	
	//Method to randomly select item for sale
	public static String itemPick() {
		String items [] = {"some boots", "a bag of pencils", "woodchips", "a dirty hamster cage", "an old can of cambells", "a tattered copy of Men are from Mars,\nWomen are From Venus", "old Halloween decorations", "a Marilyn Monroe poster", "a scratched Moby CD", "ugly doctor's office art", "a used toothbrush", "a waffle maker", "an as seen on TV waffle IRON", "Grease on VHS", "ill-fitting clothing", "some guitar strings", "a music box with a human tooth inside", "a singing fish, batteries included!", "a Kid Rock poster covered in hairy tape", "a rusted lawn ornament", "water stained thank-you cards", "a furby", "a shoebox of old batteries", "a book you'll never read"};
		int index = randomNumber(items.length);
		return items[index];
	}
	//Method returning string for pretty money printing without affecting actual value
	public static String moneyFormatter(double money) {
		
	DecimalFormat moneyFormat = new DecimalFormat("0.00");
	String formattedMoney = moneyFormat.format(money);
	
	return formattedMoney;
	}
	
	public static double yardSale(Scanner s, double money) {
		
		//Variable to return and store amount of money user has left in wallet
		double remainingMoney = money;
		
		
		//Linked Lists!!!
		LinkedList<Double> prices = new LinkedList<Double>();
		LinkedList<Integer> quantities = new LinkedList<Integer>();
		LinkedList<Boolean> purchases = new LinkedList<Boolean>();
		LinkedList<Double> remainingCoin = new LinkedList<Double>();
		LinkedList<String> itemPurchased = new LinkedList<String>();
		
		//Begin user Prompts
		while(remainingMoney >= 5.0) {
		
		//Calling random item selection method
		String item = itemPick();
		
		//Price Prompt
		double price = itemPrice(s, item);
		prices.add(price);
		//Quantity Prompt
		int quantity = itemQuantity(s, price);
		quantities.add(quantity);
		//Validate Purchase
		boolean purchased = validPurchase(quantity, price, remainingMoney);
		purchases.add(purchased);
		//Calculate Money Remaining
		if(purchased) {
			remainingMoney = walletCalculation(quantity, price, remainingMoney);
		}
		remainingCoin.add(remainingMoney);
		itemPurchased.add(item);
		String formattedMoney = moneyFormatter(remainingMoney);
		System.out.println(formattedMoney); // This is to show something is happening with prompts before data is displayed
		}
		
		int quantityCount = 0; //Variable to track # of purchases
		double greatestExpense = 0; // Variable to track most expensive purchase
		int j = 0;
		
		
		// Print Results
		for(int i = 0; i < quantities.size(); i++) {
			System.out.println("\n\n\nItem: " + itemPurchased.get(i) + "\n\nPrice: $" + prices.get(i) + "\n\nQuantity: " + quantities.get(i) + "\n\nSold: " + purchases.get(i) + "\n\nUser Wallet: $" + moneyFormatter(remainingCoin.get(i)));
			if(purchases.get(i)) {
				quantityCount = quantities.get(i) + quantityCount;
				if(prices.get(i) * quantities.get(i) > greatestExpense) {
					greatestExpense = prices.get(i) * quantities.get(i);
					j = i;
					
				}
			} 

		}
		
		System.out.println("\n\nUser purchased: " + quantityCount + " items");
		System.out.println("\nMost expensive purchase: $" + greatestExpense + " for " + quantities.get(j) + " of your " + itemPurchased.get(j) + ".\nWow" );

		return remainingMoney;
	}
}
