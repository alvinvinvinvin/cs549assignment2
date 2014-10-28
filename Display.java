/*
 * Han Chen
 * CS 549 Assignment 3
 * 10/23/2014
 * @version 1.0
 */

/*
 * *********************************
 * This is Display class designed for 
 * displaying sorted cards and 
 * process of counting scores of 
 * each suit of cards.
 * *********************************
 */

/*
 * Properties: 
 * @ArrayList<Card> clover; 
 * @ArrayList<Card> heart;
 * @ArrayList<Card> diamond;
 * @ArrayList<Card> spade;
 * Method:
 * @countDisplay;
 * @countResult;
 * @comparingResult;
 */

import java.util.*;
import myEnum.myEnums.Suit;

public class Display {
		
	/*
	 * Each list following will contain the list of cards by different suits.
	 */
		public ArrayList<Card> clover = new ArrayList<Card>();
		public ArrayList<Card> heart = new ArrayList<Card>();
		public ArrayList<Card> diamond = new ArrayList<Card>();
		public ArrayList<Card> spade = new ArrayList<Card>();
		
		
		/*
		 * Method @countDisplay will display the formulae of adding
		 * scores from different suit of @input cards together.
		 * @input: The cards list waiting for being displayed.
		 * @output: The string as result which will be displayed.
		 * @result: The sum score of this suit of card. 
		 * @return: It will return the @output only it has at least one card in the @input list. OW it will return @result as 0.
		 */
		public String countDisplay(ArrayList<Card> input){
			String output = "";
			int result = countResult(input);//Counting the result of adding scores.
			if (input.size()>0) {
				for (int i = 0; i < input.size() - 1; i++) {
					output = output + input.get(i).getValue() + " + ";//Inserting "+" between each score.
				}
				output = output + input.get(input.size() - 1).getValue()
						+ " = " + result;//Adding "=" and result at the end of the sequence of scores.
				return output;
			}
			else return ""+result;//If there is no cards in this suit it will display the result directly. It should be 0.
		}
		
		
		/*
		 * This method @countResult is designed for getting 
		 * the final result of adding score of each card together 
		 * which is from @input cards list.
		 * @input: The card list which we will figure out the total score of it.
		 * @result: The integer will store the final result.
		 * @return: return the @result.
		 */
		public int countResult(ArrayList<Card> input){
			int result = 0;
			for(int i = 0; i<input.size(); i++){
				result = result + input.get(i).getValue();//Adding these scores together.
			}
			return result;
		}
		
		/*
		 * @comparingResult method implemented counting result from each card list by method @countResult and
		 * comparing the result therefore to get which result is the greatest one.
		 * @c: Clover suit card list.
		 * @h: Heart suit card list.
		 * @s: Spade suit card list.
		 * @d: Diamond suit card list.
		 * @output: The String of output result after comparing.
		 * @clover: The instantiated card to store information of suit(clover) and scores for being compared with others later.
		 * @heart: The instantiated card to store information of suit(heart) and scores for being compared with others later.
		 * @spade: The instantiated card to store information of suit(spade) and scores for being compared with others later.
		 * @diamond: The instantiated card to store information of suit(diamond) and scores for being compared with others later.
		 * @greatest: The instantiated card class as a temp to store the information for comparing process.
		 * @return: For return the comparing result.
		 */
		public String comparingResult(ArrayList<Card> c, ArrayList<Card> h, ArrayList<Card> s, ArrayList<Card> d){
			String output = "";
			Card clover = new Card(Suit.CLOVER, countResult(c));
			Card heart = new Card(Suit.HEART, countResult(h));
			Card spade = new Card(Suit.SPADE, countResult(s));
			Card diamond = new Card(Suit.DIAMOND, countResult(d));
			Card greatest = clover;//Assuming clover's result as the greatest score and then comparing it with others.
			if(heart.result>greatest.result){
				greatest = heart;//If heart's result is greater then set heart's result as the greatest one so far.
			}
			if(spade.result>greatest.result){
				greatest = spade;//If spade's result is greater then set spade's result as the greatest one so far.
			}
			if(diamond.result>greatest.result){
				greatest = diamond;//If diamond's result is greater then set heart's result as the greatest one.
			}
			output = greatest.getSuit().toString();//Convert the result to string.
			return output;
			
		}
		
}