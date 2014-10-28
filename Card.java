/*
 * Han Chen
 * CS 549 Assignment 3
 * 10/23/2014
 * @version 1.0
 */

/*
 * *********************************
 * This is Card class designed for 
 * the model of card including get 
 * and set methods.
 * *********************************
 */

/*
 * Properties: 
 * @integer result;
 * @Suit suit;
 * @Face face; 
 * Method:
 * @Card;
 * @getSuit;
 * @setSuit;
 * @getFace;
 * @setFace;
 * @toString;
 * @compareTo;
 * @getValue;
 */

import myEnum.myEnums.Suit;
import myEnum.myEnums.Face;

public class Card implements Comparable<Card> {

	
	public int result = 0;//For storing the total scores for each suit.
	
	
	
	private Suit suit;

	 private Face face;
	 
	 /*
	  * Constructors:
	  * 
	  */
	 public Card(){}
	 
	 public Card(Suit suit, Face face) {
	  this.suit = suit;
	  this.face = face;
	 }
	 
	 public Card(Suit suit, int result){
		 this.suit = suit;
		 this.result = result;
	 }
	 
	 /*
	  * "get" and "set" methods:
	  */
	 public Suit getSuit() {
	  return suit;
	 }

	 public void setSuit(Suit suit) {
	  this.suit = suit;
	 }

	 public Face getFace() {
	  return face;
	 }

	 public void setFace(Face face) {
	  this.face = face;
	 }
	 
	 /*
	  * Setting Card class's own toString method for display 
	  * the card in string instead of displaying picture in terminal.
	  * 
	  */
	 public String toString() {
	  return "<" + this.getSuit() + " " + this.getFace() + ">";
	 }

	 /**
	  * Comparing two faces of two cards (only comparing faces)
	  * <li>if this > other £¬return 1</li>
	  * <li>if this = other £¬return 0</li>
	  * <li>if this < other £¬return -1</li>
	  * 
	  */
	 public int compareTo(Card other) {
		  int res = 0;
		  int self = this.getValue();
		  int oelf = other.getValue();
		  res = (self == oelf) ? 0 : ((self > oelf) ? 1 : -1);
		  return res;
	 }
	
	/*Get the value of face for comparing.
	 * @seq: It is for getting the face value.
	 * @c: The content of @seq.
	 * @return: Return the value combining each face.
	 */
	public int getValue() {
		  String seq = this.getFace().toString();//Convert the face value to string.
		  if (seq.matches("\\d+")) //Using regular expression to check the value of face.
		  {
			  return Integer.parseInt(this.getFace().toString());//Converting it to integer if it is from "2" to "10".
		  } 
		  else //OW getting the value matching the specific face.
		  {
			   char c = seq.charAt(0);
			   switch (c) {
			   case 'J':
				   return 11;
			   case 'Q':
				   return 12;
			   case 'K':
				   return 13;
			   case 'A':
				   return 14;//"ACE"'s value is 14 based on the requirement.
			   default:
				   return 0;
			   }
		  }
	 }
}