package blackjack;

import java.util.Scanner;
/* Rules followed for the implementation:
 * 	 	1. Each player gets two cards initially. 
 * 		2. Scoring points are assigned as mentioned in the provided document
 * 		3. For each round, each player can choose to “hit” or “stay”.
 * 		4. If the players chooses to hit, calculate the sum of cards in his hand. If it exceeds 21, he/she loses.Else, other player continues.
 * 		5. I have assumed that both the players do not continue to choose "Stay" indefinitely.
 * 		6. As soon as the player exceeds 21, the other player wins the game.
 * 		7. I have not considered the case where in the actual game, the person who has the closest sum to 21,
 * 		   wins the game( since I am playing with only two players ).
 * 		8. I have considered only 1 deck of cards rather than multiple decks.
 * 		9. For the sake of simplicity, I am not hiding any of the player's card(opponent) while printing in order to better 
 * 		   understand how the game is progressing. 
 *     10. In order to view the player's hands after every turn, feel free to uncomment the line 74/75/95/96.
 *     11. In case of an invalid input character, I have considered that the user will skip the next turn of the other player in order to continue with a fair game. 
 */
public class Tester {
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Deck deckOfCards = new Deck();
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		// Initially assign two cards to each player
		player1.addCard(deckOfCards.getNextCardFromDeck());
		player2.addCard(deckOfCards.getNextCardFromDeck());
		player1.addCard(deckOfCards.getNextCardFromDeck());
		player2.addCard(deckOfCards.getNextCardFromDeck());
		// Displays initial hand of Player 1
		System.out.println(" Player 1 Initial Hand :");
		player1.displayHand();
		//Displays initial hand of Player 2
		System.out.println(" Player 2 Initial Hand :");
		player2.displayHand();
		String choice = "";
		boolean player1Status = true;
		boolean player2Status = true;
		/*
		 * Core logic of the game implemented here :
		 * 
		 * 	1. Until the player1 or player2 is busted, keep accepting Hit or Stay using H/S characters from console.
		 *  2. Player 1 chooses H/S
		 *  	If H :
		 *  		a. Add the card to his hand.
		 *   		b. In the Player class, the function checkHandSum() checks whether the sum exceeds 21 or not.
		 *   		c. If 
		 *   			i) handSum > 21, player 1 is busted and we break out of the loop.
		 *   			ii)handSum<=21 , continue with player 2
		 *   	If S:
		 *   		a. Continue with player 2's choice of H/S
		 *   3. Perform the same steps for Player 2.
		 *   4. After breaking out of the loop, check which players status was responsible for breaking out of the loop.
		 *   5. Print the player's hand who busted as the sum of cards in his hand > 21
		 * 
		 *   Assumptions
		 *   1. The players do not continuously keep calling S as that will not progress the game.
		 *  
		 * 
		 */
		while(player1Status && player2Status)
		 
		{
			System.out.println("Player 1: Hit or Stay ? (H/S) : ");
			choice = input.next();
			System.out.println();
			if(choice.equals("H") || choice.equals("h"))
			{
				player1Status = player1.addCard(deckOfCards.getNextCardFromDeck());
				//System.out.println(" Player 1 Hand after H/S:");
				//player1.displayHand();
				if(!player1Status)
					break;
			}
			else if (choice.equals("S") || choice.equals("s"))
			{
				System.out.println("No changes in Player 1's hand as he chooses to Stay");
			}
			else
			{
				System.out.println("Invalid character.Please skip Player2's turn in order to continue a fair game.");
			}
			
			System.out.println("Player 2: Hit or Stay ? (H/S) : ");
			choice = input.next();
			System.out.println();
			
			if(choice.equals("H"))
			{
				player2Status = player2.addCard(deckOfCards.getNextCardFromDeck());
				//System.out.println(" Player 2 Hand after H/S:");
				//player2.displayHand();
				if(!player2Status)
					break;
			}
			else if (choice.equals("S") || choice.equals("s"))
			{
				System.out.println("No changes in Player 2's hand as he chooses to Stay");
			}
			else
			{
				System.out.println("Invalid character.Please skip Player1's next turn in order to continue a fair game.");
			}
			
		}
		if(!player1Status)
		{
			System.out.println(" Player 1 Hand :");
			player1.displayHand();
			System.out.println("Player 2 wins");
		}
		else
		{
			System.out.println(" Player 2 Hand :");
			player2.displayHand();
			System.out.println("Player 1 wins");
		}
		input.close();
		
	}

}
