/*
 * Han Chen
 * CS 549 Assignment 3
 * 10/23/2014
 * @version 1.0
 */
/*
 * *********************************
 * This is myEnums class designed for 
 * containing types of Card class based
 * on Suit enumeration and Face enumeration.
 * *********************************
 */

/*
 * Properties: 
 * @enum Suit;
 * @enum Face;
 * Method:
 * @toString;
 */

package myEnum;

public class myEnums {
	
	/*
	 * The @Suit enumeration of @Card class.
	 */
	public enum Suit 
	{
		CLOVER { public String toString() { return "Clover"; } },
		HEART { public String toString() { return "Heart"; } },
		SPADE { public String toString() { return "Spade"; } }, 
		DIAMOND { public String toString() { return "Diamond"; } }
	}
	
	/*
	 * The @Face enumeration of @Card class
	 */
	public enum Face 
	{
		DEUCE { public String toString() { return "2"; } }, 
		THREE { public String toString() { return "3"; } }, 
		FOUR { public String toString() { return "4"; } }, 
		FIVE { public String toString() { return "5"; } }, 
		SIX { public String toString() { return "6"; } }, 
		SEVEN { public String toString() { return "7"; } }, 
		EIGHT { public String toString() { return "8"; } }, 
		NINE { public String toString() { return "9"; } }, 
		TEN { public String toString() { return "10"; } }, 
		JACK { public String toString() { return "J"; } }, 
		QUEEN { public String toString() { return "Q"; } }, 
		KING { public String toString() { return "K"; } },
		ACE { public String toString() { return "A"; } }
	}
	
}
