import java.util.ArrayList;
import java.util.Scanner;

public class Crazy8sRun {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Player> playerObjects = new ArrayList<Player>();
		
		System.out.println("Welcome to Crazy8s\n\n");
		
		//rule
		
		System.out.println("Enter the number of players:");
		int numberOfPlayers = scanner.nextInt();
	
		//System.out.printf("%d players will be playing the game\n", numberOfPlayers);
		
		System.out.printf("\n");
		
		for (int i=0; i<numberOfPlayers; i++)
		{
			System.out.printf("Enter the name of player %d:", i+1);
			String name = scanner.next();
			Player temp = new Player(name);
			playerObjects.add(temp);
		}
		
		System.out.printf("\n");
		
		/*for (int i=0; i<nameOfPlayers.size(); i++)
		{
			System.out.println("Player "+ nameOfPlayers.get(i) + " joined the game");
		}*/
		
		for (int i=0; i<5; i++)
		{
			for (int j=0; j<playerObjects.size(); j++)
			{
				playerObjects.get(j).setHand();
			}
		}
		
		for (int j=0; j<playerObjects.size(); j++)
		{
			System.out.println("Cards of player " +playerObjects.get(j).getName() +playerObjects.get(j).getHand());
		}
		
	}

}
