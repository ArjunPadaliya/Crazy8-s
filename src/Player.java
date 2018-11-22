import java.util.ArrayList;

public class Player {
	
	public String name;
	public ArrayList<String> hand;
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
	
	public String getCards()
	{
		return Deck.getInstance().dealCards();
	}
}
