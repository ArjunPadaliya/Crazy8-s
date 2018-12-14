import java.util.ArrayList;
import java.util.Scanner;

public class Crazy8sRun {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Player> playerObjects = new ArrayList<Player>();
		int numberOfPlayers;
		int playerTurn = 0;
		int cardNum;
		String topCard = null;
		boolean isNumber;
		
		System.out.println("\n_____________________\n");
		System.out.println(" Welcome to Crazy8s!");
		System.out.println("_____________________\n\n");
		
		//TAKING IN NUMBER OF PLAYERS//
		System.out.print("Please enter the number of players: ");
		do {
			while (true) {
				if (scanner.hasNextInt()) {
					numberOfPlayers = scanner.nextInt();
					isNumber = true;
					if (!(numberOfPlayers > 5) && !(numberOfPlayers < 2))
						break;
					System.out.println("Enter at least 2 players and less than 5 players");

				} else {
					System.out.printf("Please enter a valid number: ");
					isNumber = false;
					scanner.next();
				}
			} 
		} while (!(isNumber));
	
		//System.out.printf("%d players will be playing the game\n", numberOfPlayers);
		
		System.out.printf("\n");
		
		//TAKING IN PLAYER NAMES//
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
				System.out.println("Enter less than 10 letters for name");
			}
			Player temp = new Player(name);
			playerObjects.add(temp);
		}
		
		
		System.out.printf("\n");
		
		
		//DISPLAYING PLAYERS//
		for (int i=0; i<playerObjects.size(); i++)
		{
			System.out.println("Player "+ playerObjects.get(i).getName() + " joined the game");
		}
		
		System.out.printf("\n");
		
		System.out.println("\n~ To play a card, enter a number corresponding to the cards position in your hand.");
		System.out.println("~ If you do not have a card to play, press 0 to pick up a card.\n");
		
		//GENERATING CARDS FOR EACH PLAYERS HAND//
		for (int i=0; i<5; i++)
		{
			for (int j=0; j<playerObjects.size(); j++)
			{
				playerObjects.get(j).setHand();
			}
		}
		
		//CYCLING THROUGH PLAYERS AND PROMPTING THEM TO PLAY A CARD//
		while(true)
		{
			playerTurn = playerTurn % numberOfPlayers;
			if(playerObjects.get(playerTurn).getHand() == null)
			{
				break;
			}
			while(true)
			{
				while(true)
				{
					System.out.print(playerObjects.get(playerTurn).getName()+" please enter the card number you would like to play " +playerObjects.get(playerTurn).sortHand() + ":" );
					cardNum = scanner.nextInt();
					if (!(playerObjects.get(playerTurn).getHand().size() < cardNum))
					{		
							break;
					}
					System.out.println("Please enter a valid card number");
				}
				topCard = playerObjects.get(playerTurn).play(cardNum);
				if(topCard != null)
					break;
			}
			playerTurn++;
			System.out.println("\nTop Card: " +topCard);
		}
	}

}
