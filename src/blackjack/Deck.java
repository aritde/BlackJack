package blackjack;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//Class representing a Card
class Card{
	private String suit;
	private int value;
	Card(String suit, int value)
	{
		this.suit = suit;
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}
	public String  getSuit()
	{
		return suit;
	}
	
}
// Class representing a deck
public class Deck {
	private List<Card> cards;
	/*public static void main(String[] args)
	{
		Deck d = new Deck();
		d.constructDeck();
		
	}*/
	public Deck()
	{
		cards = new LinkedList<>();
		constructDeck();
	}
	//Utiltiy function to constructs the deck of card
	public void constructDeck()
	{
		String[] suits = {"Club","Spade","Diamond","Heart"};
		for(String suit : suits)
		{
			for(int i=1;i<=13;i++)
			{
				Card c = new Card(suit,i);
				cards.add(c);
			}
		}
		//displayDeck(cards);
		shuffleCards();
		//System.out.println("Shuffled =");
		//displayDeck(cards);
	}
	// Utility Function to shuffle the deck of cards
	public void shuffleCards()
	{
		Random r = new Random();
		for (int i=2;i<52;i++)
		{
			int randNo = r.nextInt(i);
			Card temp = cards.get(randNo);
			cards.set(randNo, cards.get(i));
			cards.set(i,temp);
		}
	}
	// Utility function for checking the cars in the deck before and after shuffling
	public void displayDeck(List<Card> cards)
	{
		for(Card c : cards)
		{
			System.out.println(c.getValue() +" of "+ c.getSuit());
		}
	}
	// Function that serves a card from the top of the deck to a player.
	// The start of Linked List indicates the top of the desck of cards 
	public Card getNextCardFromDeck()
	{
		Card current = cards.remove(0);
		return current;
	}
}
