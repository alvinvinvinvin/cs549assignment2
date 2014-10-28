/*
 * Han Chen
 * CS 549 Assignment 3
 * 10/23/2014
 * @version 1.0
 */

/*
 * *********************************
 * This is Generator class designed for 
 * Initializing cards, shuffling cards, 
 * sorting cards and so on.
 * *********************************
 */

/*
 * Properties: 
 * @integer sizeOfSuit;
 * @integer sizeOfFace;
 * @integer CARD_NUM; 
 * Method:
 * @init;
 * @shuffle;
 * @pick;
 * @sortBySuit;
 * @sortByFace;
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import myEnum.myEnums.Suit;
import myEnum.myEnums.Face;

public class Generator {
	
	final static int sizeOfSuit = Suit.values().length;//The number of types of suit.
	final static int sizeOfFace = Face.values().length;//The number of types of Face.
	static int CARD_NUM = sizeOfSuit * sizeOfFace;//The integer is set for determine the total number of cards in one stack.
	
	/*
	 * This method @init is designed for initialize a stack of cards.
	 * @param cards: Preparing a card array for containing cards.
	 * @param index: The index number of @cards which will be used for moving pointer.
	 * @param suit: The suit we get from suit enumeration.
	 * @param face: The face we get from face enumeration.
	 * @return cards: Returning initialized cards.
	 */
	public Card[] init(){
		Card[] cards = new Card[CARD_NUM];//Set an empty card array for containing @CARD_NUM of initialized cards.
		int index = 0;
		for(Suit suit: Suit.values()){
			for(Face face: Face.values()){
				cards[index++]=new Card(suit, face);//Initializing cards by assigning suits and faces one by one.
			}
		}
		return cards;
	}
	
	/*
	 * This method @shuffle will shuffle the cards initialized 
	 * earlier for ensuring the cards picked from stack
	 * are random.
	 * @input: Cards initialized earlier.
	 * @cards: A list for contain the @input.
	 * @size: The number of cards.
	 * @return: Return the shuffled cards array.
	 */
	public Card[] shuffle(Card[] input){
		List<Card> cards = new ArrayList<Card>();
		Collections.addAll(cards, input);//Converting cards array to list.
		Collections.shuffle(cards);//Call shuffle() method to shuffle the list.
		final int size = cards.size();
		Card[] output = (Card[]) cards.toArray(new Card[size]);//Convert the shuffled list to array.
		return output;
	}
	
	/*
	 * The @pick method is designed for picking random 
	 * number @num of cards from @input card array.
	 * @input: Shuffled and initialized cards.
	 * @num: The number determining how many cards we will pick from stack.
	 * @r: The instantiation of Random class.
	 * @output: The Card array for containing picked cards.
	 * @container: The list for contain @input.
	 * @j: The random index of @container.
	 */
	public Card[] pick(Card[] input, int num){
		Random r = new Random();
		Card[] output = new Card[num];
		List<Card> container = new ArrayList<Card>();
		Collections.addAll(container, input);//Converting the @input to list.
		int j=0;
		for(int i = 0; i<num; i++ ){
			j=r.nextInt(CARD_NUM);//Generate a random number from 0 to 51 and set it as index of list.
			output[i] = container.get(j);//Put this element to the @output array.
			container.remove(j);//Remove this element from previous list ensuring it won't be selected next time in this loop.
			CARD_NUM--;//Therefore the size of list is also declined.
		}
		return output;
	}
	
	/*
	 * This @sortBySuit method will sort the @input card array by suit.
	 * @input: The card array waiting for being sorted.
	 * @dis: Instantiation of Display class for containing different sorted cards by their suits.
	 * @length: Number of @input's elements.
	 * @suit: Containing the suit of each card for determining which suit it belongs to.
	 * @return: Return the @dis.
	 */
	public Display sortBySuit(Card[] input){
		Display dis = new Display();
		int length = input.length;
		Suit suit;
		for(int i = 0; i<length; i++){
			suit = input[i].getSuit();//Getting the suit of each card.
			if(suit.equals(Suit.CLOVER)){
				dis.clover.add(input[i]);//Add this card to clover list if its suit is clover.
			}
			else if(suit.equals(Suit.HEART)){
				dis.heart.add(input[i]);//Add this card to hear list if its suit is heart.
			}
			else if(suit.equals(Suit.SPADE)){
				dis.spade.add(input[i]);//Add this card to spade list if its suit is spade.
			}
			else if(suit.equals(Suit.DIAMOND)){
				dis.diamond.add(input[i]);//Add this card to diamond list if its suit is diamond.
			}
		}
		return dis;
	}
	
	/*
	 * This method @sortByFace will sort the @input card array by their face.
	 * @input: The card array we will sort.
	 * @return: Return the sorted array.
	 */
	public ArrayList<Card> sortByFace(ArrayList<Card> input){
		Collections.sort(input);
		return input;
	}
}