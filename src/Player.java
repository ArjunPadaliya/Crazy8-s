import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
	
	public ArrayList<String> sortHand()
	{
		Collections.sort(this.hand, new ValueComparator());
		Collections.sort(this.hand, new SuitComparator());
		return this.hand;
	}
	
	public class SuitComparator implements Comparator<String> {
	    @Override
	    public int compare(String o1, String o2) {
	        return o1.charAt(o1.length() - 1) - o2.charAt(o2.length() - 1);
	    }
	}
	
	public class ValueComparator implements Comparator<String> {
	    @Override
	    public int compare(String o1, String o2) {
	        return o1.codePointBefore((o1.length()-2) + (o1.length() - 1)) - o2.codePointBefore((o2.length()-2) + (o2.length() - 1));
	    	
	    }
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
