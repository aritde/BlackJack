package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand;
	public Player(String name)
	{
		this.name = name;
		hand = new ArrayList<>();
		
	}
	// Function to add a card to the players hand.
	// This function also makes a call to check whether the sum of cards in hand is <=21 or not.Returns T/F accordingly.
	public boolean addCard(Card c)
	{
		// Add the card to the players hand
		hand.add(c);
		//Calculate the sum of cards currently in the players hand
		int sumOfHand = checkHandSum();
		// Check if the player has busted
		if(sumOfHand<=21)
			return true;
		else
			return false;
		
	}
	public int checkHandSum()
	{
		int sum = 0;
		int numOfAces = 0;
		for(Card c: hand)
		{
			// In case of an Ace, initially consider its contribution as 11 points. If the total exceeds 21, 
			//switch its contribution as 1 point in the while loop below
			if(c.getValue()==1)
			{
				numOfAces++;
				sum+=11;
			}
			//In case of face cards (i.e. jack, queen, or king) consider its contribution as 10 points.
			else if(c.getValue()>10)
			{
				sum+=10;
			}
			// For other cards, consider its contribution as its equivalent
			else
				sum+=c.getValue();
		}
		// If the sum exceeds 21 and the player happens to have any ace in his hand, its contribution is reduced by 10point
		// to ensure its net worth is 1 point
		while(sum>21 && numOfAces>0)
		{
			sum-=10;
			numOfAces--;
		}
		return sum;
	}
	// Displays the current hand of the player
	public void displayHand()
	{
		for(Card c: hand)
			System.out.println(c.getValue() +" of "+ c.getSuit());
	}

}
