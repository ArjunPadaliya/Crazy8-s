
public class Crazy8sRun {

	public static void main(String[] args) {
		
		//Creates Deck Object
		Deck obj = new Deck();
		
		System.out.println("\n" + "- Print Deck and Print Shuffled Deck - ");
		//Prints the ArrayList of cards
		System.out.println(obj.arrayOfCards);
		
		//Shuffles and then prints the array of cards
		obj.shuffle(obj.arrayOfCards);
		System.out.println(obj.arrayOfCards);
		
		//Prints discard pile and deck after filling the graveYard arrayList with elements from the arrayOfCards arrayList
		System.out.println("\n" + "- Flip function -");
		for (int x = 0; x < 52; x++)
		{
			obj.flip();
			
		}
		System.out.println("Discarded cards: ");
		System.out.println(obj.graveYardCards);
		System.out.println("Array of cards: ");
		System.out.println(obj.arrayOfCards);
		
		//Shuffles and resets the deck using the discard pile
		System.out.println("\n" + "- Reset function - ");
		obj.reset();
		System.out.println("Discarded cards: ");
		System.out.println(obj.graveYardCards);
		System.out.println("Array of cards: ");
		System.out.println(obj.arrayOfCards);
		
	}

}
