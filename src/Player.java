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
}
