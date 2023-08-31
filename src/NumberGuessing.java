import java.util.*;

class Game{
	Scanner sc = new Scanner(System.in);
	int number = (int)(50 * Math.random());
	int limit = 5;
	
	void guess() {
		for(int i=1; i<=limit; i++) {
			System.out.println("Enter the number: ");
			int input = sc.nextInt();

			if(number == input) {
				System.out.println("Congratulations! :) You guess the no. in " + i + " attempts.");
				break;
			}
			else if(number>input && i!=limit-1) {
				System.out.println("Give some high value :|");
			}
			else{
				System.out.println("Give some low value :|");
			}
			
			if(i==limit) {
				System.out.println("Sorry! You have exhausted the limits.");
				System.out.println("The number is " + number);
			}
		}
	}
}


public class NumberGuessing {
	public static void main(String[] args) {
		
		System.out.println("Welcome to this Number Guessing game....");
		System.out.println("The no. is between 1 to 50");
		System.out.println("You have 5 attempts to guess the no.");
		System.out.println();
				
		Game g = new Game();
		g.guess();
	}
}
