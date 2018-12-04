import java.util.ArrayList;
import java.util.Scanner;

public class Crazy8sRun {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Player> playerObjects = new ArrayList<Player>();
		int numberOfPlayers;
		int playerTurn = 0;
		String topCard = null;
		
		System.out.println("Welcome to Crazy8s\n\n");
		
		//rule
		while(true)
		{
			System.out.print("Enter the number of players: ");
			numberOfPlayers = scanner.nextInt();
			if (!(numberOfPlayers > 5) && !(numberOfPlayers < 2))
				break;
			System.out.println("Please enter at least 2 players and less than 5 players");
		}
	
		//System.out.printf("%d players will be playing the game\n", numberOfPlayers);
		
		System.out.printf("\n");
		
		
		for (int i=0; i<numberOfPlayers; i++)
		{
			String name;
			while(true)
			{
				System.out.printf("Enter the name of player %d:", i+1);
				name = scanner.next();
				if (!(name.length()>10))
				{
					break;
				}
				System.out.println("Please enter less than 10 letters for name");
			}
			Player temp = new Player(name);
			playerObjects.add(temp);
		}
		
		
		System.out.printf("\n");
		
		
		
		for (int i=0; i<playerObjects.size(); i++)
		{
			System.out.println("Player "+ playerObjects.get(i).getName() + " joined the game");
		}
		
		System.out.printf("\n");
		
		for (int i=0; i<5; i++)
		{
			for (int j=0; j<playerObjects.size(); j++)
			{
				playerObjects.get(j).setHand();
			}
		}
		
		
		while(true)
		{
			playerTurn = playerTurn % numberOfPlayers;
			if(playerObjects.get(playerTurn).getHand() == null)
			{
				break;
			}
			while(true)
			{
				System.out.print(playerObjects.get(playerTurn).getName()+" please enter the card number you would like to play " +playerObjects.get(playerTurn).getHand() + ":" );
				int cardNum = scanner.nextInt();
				topCard = playerObjects.get(playerTurn).play(cardNum);
				if(topCard != null)
					break;
			}
			playerTurn++;
			System.out.println("\nTop Card: " +topCard);
		}
	}

}
