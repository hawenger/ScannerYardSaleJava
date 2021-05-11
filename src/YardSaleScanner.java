import java.util.Scanner;
import java.util.Random;

// Hannah Wenger

public class YardSaleScanner {
	
	public static void main(String[] args) {
	
		double money = 53.00;
		double biggestPurchase = 0;	// Tracking biggest purchase
		
		Scanner repoMan = new Scanner(System.in);
		
		while(money >= 5.0) {
			double pocketChange = yardSale(repoMan, money);
			money = money - pocketChange;
			System.out.println("\nYou have $" + money + " left in your pocket!");
				if(pocketChange > biggestPurchase) {
					biggestPurchase = pocketChange;
				}
		} 
		System.out.println("\nYour pocket feels light at only $" + money + ".\nTime to go home.");
		//System.out.println("You bought " + repoMan. + "items.");
		System.out.println("\nYour most expensive item was $" + biggestPurchase + "!\nYou lush.");
	}
	
	public static int randomNumber(int x) { // Method for array selection randomization
		Random rand = new Random();
		int randNum = rand.nextInt(x);
		return randNum;
	}
	
	public static String itemPick() {
		String items [] = {"some boots", "a bag of pencils", "woodchips", "a dirty hamster cage", "an old can of cambells", "a tattered copy of Men are from Mars,\n Women are From Venus", "old Halloween decorations", "a Marilyn Monroe poster", "a scratched Moby CD", "ugly  doctor's office art", "a used toothbrush", "a waffle maker", "an as see on TV waffle IRON", "Grease on VHS", "ill-fitting clothing", "some guitar strings", "a music box with a human tooth inside", "a singing fish, batteries included!", "kid rock poster covered in hairy tape", "a rusted lawn ornament", "water stained thank you cards", "a furby", "a shoebox of old batteries", "a book you'll never read"};
		int index = randomNumber(items.length);
		return items[index];
	}
	
	public static double pricePick() {
		double prices [] = {12.50, 7.00, 4.75, 0.25, 8.00, 9.25, 3.50, 2.50, 1.00, .50, 3.00, 4.00, 2.00, 1.00, 1.50, 6.00, 6.66, 4.80, 5.10, 0.10, 4.13, 7.77, 9.99 };
		int index = randomNumber(prices.length);
		return prices[index];
	}
	
	
	public static double yardSale(Scanner s, double money) {
		double price = pricePick();
		String item = itemPick();
		
		System.out.println("You'd like to purchase\n" + item + "\nfor $" + price + "?\nTrue or False?");
		boolean answer = s.nextBoolean();
		
			if(answer && price >= 10) {
				System.out.println("\nYou said you weren't going to spend more than $10 on something. \nI can't let you break that promise.");
			
			} else if(answer) {
				System.out.println("\nHow many would you like?");
				int quantity = s.nextInt();
				if(quantity < 0) {
					System.out.println("\nCheeky. Repoed.");
				} else if(quantity == 0) {
					System.out.println("\nGuess you changed your mind.");
				} else if(money - (price * quantity) < 0.0) {
					System.out.println("\nNah. That's gonna put you over your budget. Let's find you something else.");
				} else {
					
					System.out.println("\nSweet purchase.\n\n" + "Quantity : " + quantity + "\n" + "Item : " + item + "\n" + "You Paid : $" + Math.ceil(quantity * price) + "\n");
					return (price * (double)quantity);
				}
			}else if(!answer) {
				if(price >= 10.0) {
				System.out.println("\nYou said you weren't going to spend more than $10 on something.\nWay to stick to your guns.");
				} else {
					System.out.println("\nSmart choice.");
				}
			} else {
				System.out.println("\nOops, looks like someone else snatched it up while you were fumbling...)");
			}
			
		return 0; //change this to the correct amount
	}

}
