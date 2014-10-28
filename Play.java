/*
 * Han Chen
 * CS 549 Assignment 3
 * 10/23/2014
 * @version 1.0
 */
/*
 * *********************************
 * This is Play class designed for 
 * main class to run the program.
 * For more details please check
 * each method or class.
 * *********************************
 */

/*
 * Properties: 
 * @Generator g;
 * @integer lowerBound;
 * @integer upperBound;
 * @integer numOfCards;
 * Method:
 * @main;
 * @test;
 */

import java.util.Random;

public class Play{
	
	static Generator g = new Generator();//Instantiation of Generator class.
	
	static int lowerBound = 1;//Ensuring the program will pick at least one card from stack.
	static int upperBound = Generator.CARD_NUM;//Ensuring the program will not pick more than @CARD_NUM cards from stack.
	static int numOfCards = (new Random().nextInt(upperBound-lowerBound))+lowerBound;//Generating random number in bound.
	
	/*
	 * @main method to run the program.
	 */
	public static void main(String args[]){
		test();
	}
	
	/*
	 * This method is designed for combine all components together to generate the program.
	 * @cards: Card array for containing cards picked from initialized and shuffled card stack.
	 * @dis: Instantiation of Display class.
	 * @result: The string to display the comparing result.
	 */
	public static void test(){
		
		
		/*
		 * @init() method will initialize a stack of cards. 
		 * @shuffle method will shuffle the cards initialized.
		 * @pick method will pick the @numOfCards number of cards from shuffled stack.
		 */
		Card[] cards = g.pick(g.shuffle(g.init()), numOfCards);
		
		/*
		 * Sort the picked cards by suit first. 
		 * Second, sort each suit of cards by face value and put them to the list they belong to.
		 */
		Display dis = g.sortBySuit(cards);
		dis.clover = g.sortByFace(dis.clover);
		dis.diamond = g.sortByFace(dis.diamond);
		dis.heart = g.sortByFace(dis.heart);
		dis.spade = g.sortByFace(dis.spade);
		
		/*
		 * Displaying the @numOfCards number of picked cards from @upperBound number of cards.
		 */
		System.out.println();
		System.out.println(numOfCards+" cards were picked from "+upperBound+" cards: \n");
		for(int i = 0; i<cards.length; i++){
			System.out.printf("%-13s",cards[i]);
			if((i+1)%3 == 0)//Line feed after each 3 cards displayed.
				System.out.println();
		}
		System.out.println();
		System.out.println("===========================================\n");
		System.out.println("Sorted cards: \n");
		
		//Display sorted cards.
		System.out.println(dis.clover);
		System.out.println(dis.heart);
		System.out.println(dis.spade);
		System.out.println(dis.diamond);
		
		System.out.println("===========================================\n");
		System.out.println("Counting scores: \n");
		
		//Display the process of counting scores of each suit.
		System.out.println("Clover: "+dis.countDisplay(dis.clover));
		System.out.println("Heart: "+dis.countDisplay(dis.heart));
		System.out.println("Spade: "+dis.countDisplay(dis.spade));
		System.out.println("Diamond: "+dis.countDisplay(dis.diamond)+"\n");
		
		//Display the result of comparing.
		String result = dis.comparingResult(dis.clover, dis.heart, dis.spade, dis.diamond);
		System.out.println(result+" has won in this game");
	}

}