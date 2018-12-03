import java.util.ArrayList;

public class Player {
	
	public String name;
	public ArrayList<String> hand = new ArrayList<String>();
	public int bank;
	
	public Player(String name)
	{
		this.name = name;
		this.bank = 500;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getBank()
	{
		return this.bank;
	}
	
	public void setHand()
	{
		this.hand.add(Deck.getInstance().dealCards());
	}
	
	public ArrayList<String> getHand()
	{
		return this.hand;
	}
	
	public String play(int num)
	{
		if (num == 0)
		{
			hand.add(Deck.getInstance().playTurn("0"));
			return Deck.getInstance().getTopCard();
		}
		String card = hand.get(num-1);
		//System.out.println("Player card: " +card);
		String topCard = Deck.getInstance().playTurn(card);
		if (topCard != null)
			hand.remove(num-1);
		if (hand.isEmpty())
		{
			System.out.println("\n" + name + " has won the game");
			System.exit(0);
		}
		return topCard;
	}
}
