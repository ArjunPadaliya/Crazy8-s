import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {
	private ArrayList<String> arrayOfCards = new ArrayList<String>();
	private ArrayList<String> graveYardCards = new ArrayList<String>();
	Scanner scanner = new Scanner(System.in);
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
		System.out.println("Top card: " +topCard);
		
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
		if(getNumber(arrayOfCards.get(0)) == 8)
			shuffle();
		graveYardCards.add(arrayOfCards.get(0));	
		arrayOfCards.remove(0);
		topCard = graveYardCards.get(graveYardCards.size() -1);
	}
	
	private int getNumber(String card)
	{
		String temp = "";
		if (card.startsWith("#"))
			return 0;
		for (int i=0; i<card.length(); i++)
		{
			if (Character.isDigit(card.charAt(i)) == true)
			{
				temp += card.charAt(i);
			}
		}
		//System.out.println(Integer.parseInt(temp));
		return Integer.parseInt(temp);	
	}
	
	private char getSuit(String card)
	{
		return card.charAt(card.length()-1);
	}
	
	protected String playTurn(String card)
	{
		//System.out.println("Card played: " +card);
		if(this.topCard != null)
		{
			if (getNumber(card) == 8)
			{
				while(true)
				{
					System.out.print("Please select the card suit [C, D, H, S]: ");
					int cardSuit = scanner.nextInt();
					if (cardSuit == 1)
					{
						topCard = "#C";
						return topCard;
					}
					else if (cardSuit == 2)
					{	
						topCard = "#D";
						return topCard;
					}
						
					else if (cardSuit == 3)
					{
						topCard = "#H";
						return topCard;
					}
					else if (cardSuit == 4)
					{
						topCard = "#S";
						return topCard;
					}
					else
					{
						System.out.println("Please enter a valid number to select a card");
					}
				}
			}
			if (getNumber(card) == 0)
			{
				String temp = arrayOfCards.get(0);
				arrayOfCards.remove(0);
				return temp;
			}
			else if (getNumber(card) == getNumber(topCard))
			{
				System.out.println("Card number matches");
				this.topCard = card;
			}
			else if (getSuit(card) == getSuit(topCard))
			{
				System.out.println("Card suit matches");
				this.topCard = card; 
			}
			else
			{
				System.out.println("Please play a card that matches top card's suit or number");
				return null;
			}
			//System.out.println("Deck topcard: " +topCard);
			return topCard;
		}
		return null;
	}
	
	protected String dealCards()
	{
		String temp = arrayOfCards.get(0);
		arrayOfCards.remove(0);
		return temp;
	}
	
	protected static Deck getInstance()
	{
		if (deckObj == null)
		{
			deckObj = new Deck();
		}
		return deckObj;
	}

	protected String getTopCard() {
		return topCard;
	}
}
