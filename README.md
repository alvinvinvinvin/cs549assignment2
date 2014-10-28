cs549-2
=======

assgnment2

Write a program in either Java or C# for a card game. The program accepts a set of playing cards as input from only one pack (of 52 cards) and first arranges them in ascending order within their suits. For example, if the following set of cards is given as input,

the program must sort them.

The program must then compute the score for each suit by summing up the value for each card in that suit. For the score, the number cards have their own numeric values. Picture cards have the values as follows:

J = 11, Q = 12, K = 13 and A = 14

Accordingly, in the above example, the scores for each suit will be as follows:

Clover - 2 + 12 + 14 = 28
Hearts - 3 + 6 = 9
Spade - 6 + 7 + 11 = 24
Diamond - 4 + 6 + 9 + 13 = 32
Diamond has won in this game.

Notice that number of cards input to the program is random and hence each suit may get varying number of cards as shown in the example above. The program must output the following:

Input cards as given in the input (may accept from the keyboard or from a file)
Cards in each suit sorted in ascending order
Score for each suit
The winning suit and its score
You do not need to show the pictures for the cards. It is sufficient to indicate the suit and the value (for example, <Spade Q>, <Diamond 3>, and so on).

Please make sure that your program well-documented, and hence is readable and understandable. It will be reused by another student in the class. Moreover, I need to understand the program as well. Remember that this exercise is to demonstrate reuse of code and hence the program must work correctly before someone can REuse it.
