import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<String> arrayOfCards = new ArrayList<String>();
	private ArrayList<String> graveYardCards = new ArrayList<String>();
	private String topCard = "";
	private static Deck deckObj;
	
	
	private Deck()
	{
		String[] cards = {"1D", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "11D", "12D", "13D",
						"1S", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "11S", "12S", "13S",
						"1H", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "11H", "12H", "13H",
						"1C", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "11C", "12C", "13C"};
		
		for(int i =  0; i < cards.length; i++)
		{
		     arrayOfCards.add(cards[i]);
		}
		shuffle();
		flip();
		
	}
	
	private void shuffle()
	{
		Collections.shuffle(arrayOfCards);
	}
	
	private void reset()
	{
		arrayOfCards.addAll(graveYardCards);
		graveYardCards.clear();
		shuffle();
	}
	
	private void flip()
	{
		graveYardCards.add(arrayOfCards.get(0));	
		arrayOfCards.remove(0);
		topCard = graveYardCards.get(graveYardCards.size() -1);
	}
	
	private int getNumber(String card)
	{
		return card.charAt(0);
	}
	
	private char getSuit(String card)
	{
		return card.charAt(1);
	}
	
	private void playTurn(String card)
	{
		if (getNumber(card) == 8)
		{
			System.out.println("Number 8 works");
		}
		else if (getNumber(card) == getNumber(topCard))
		{
			System.out.println("Card number matches");
		}
		else if (getSuit(card) == getSuit(topCard))
		{
			System.out.println("Card suit matches");
		}
	}
	
	protected String dealCards()
	{
		String temp = arrayOfCards.get(0);
		arrayOfCards.remove(0);
		return temp;
	}
	
	public static Deck getInstance()
	{
		if (deckObj == null)
		{
			deckObj = new Deck();
		}
		return deckObj;
	}
}
