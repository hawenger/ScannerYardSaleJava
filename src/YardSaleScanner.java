import java.util.Scanner;
import java.util.Random;

// Hannah Wenger

public class YardSaleScanner {
	
	public static void main(String[] args) {
	
		double money = 53.00;
		
		Scanner askJeeves = new Scanner(System.in);
		
		System.out.println("\n\nHello.\nWelcome to what's left of Ebay!\nYou have $" + money + " to spend.\n");
		double postPurchaseFunds = yardSale(askJeeves, money);
		System.out.println("You spent a total of $" + (money - postPurchaseFunds) + ".\n\nThanks for junking!");
	}
	
	public static double yardSale(Scanner s, double money) {
		double postPurchaseFunds = 0; // Total to return
		
		//Variables to store most expensive item
		//String priciestItemName = ""; 
		double priciestItemCost = 0;
		
		//Counting items purchased
		int quantityCount = 0;
		
		//Loop for User Prompts
		while(money >= 5.0) {
			
			//Random item cost for user prompt
			double price = pricePick(); 
			
			//Random item for user prompt
			String item = itemPick();
			
			System.out.println("\nYou'd like to purchase\n" + item + " for $" + price + "?\n\n Type True or False");
			
			if(s.hasNextBoolean()) {
				boolean answer = s.nextBoolean();
				
				if(answer && price >= 10) {
					System.out.println("\nYou said you weren't going to spend more than $10 on something. \nI can't let you break that promise.");
				
				
				} else if(answer) {
					
					//Taking in item quantity
					System.out.println("\nHow many would you like?");
					
					if(s.hasNextInt()) {
						
						int quantity = s.nextInt();
						
						if(quantity <= 0) {
							
							System.out.println("\nGuess you changed your mind? Let's see what else is available.");
							
						} else if(money - (price * quantity) < 0) {
							
							System.out.println("\nNah. That's gonna put you over your budget. Let's try something else.");
							
						} else {
							
							System.out.println("\nSweet purchase.");//\n\n" + "Quantity : " + quantity + "\n" + "Item : " + item + "\n" + "You Paid : $" + Math.ceil(quantity * price) + "\n");
							
							quantityCount = quantityCount + quantity;
							
							
							if(price > priciestItemCost) {
								
								priciestItemCost = price;
								//priciestItemName = item;
								
							}
							money = money - (price * quantity);
							
						}
					
					} else {
						
						s.nextLine();
						System.out.println("\nOops, looks like someone else snatched it up while you were fumbling...");
					}
					
				} else if(!answer) {
					
					if(price >= 10.0) {
						System.out.println("\nYou said you weren't going to spend more than $10 on something.\nWay to stick to your guns.");
					} else {
						System.out.println("\nSmart choice.");
					}
				}
				
			} else {
				s.nextLine();
				System.out.println("\nOops, looks like someone else snatched it up while you were fumbling...");
			}
			
			if(money > 5.0) {
			System.out.println("\nYour wallet: $" + money);
			}
			
				
			}
		
		postPurchaseFunds = money;
		System.out.println("\nYou seem lighter.  You have $" + money + " left over.");
		System.out.println("You purchased " + quantityCount + " items. What a lush!");
		System.out.println("Your most expensive item cost $" + priciestItemCost + "!");
		
		return postPurchaseFunds;
		
		}
	
	public static int randomNumber(int arrayLength) { // Method for array selection randomization
		Random rand = new Random();
		int randNum = rand.nextInt(arrayLength);
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
	
}
