/* Max Chwa
 * Deck.java - A template for a Deck of Cards.
*/

public class Deck {
	
	private Card[] cards;
	private int top; // the index of the top of the deck

	// add more instance variables if needed
	
	public Deck(){

		top = 0;

		cards = new Card[52];
	
		for (int i = 0; i < 52; i++) {

			cards[i] = new Card(i%4 + 1, i/4 + 1);

		}
	
	}
	
	public void shuffle(){
		// shuffle the deck here
		for (int i = 0; i < 50; i++) {
			int placementOne = (int) (Math.random() * 52);
			int placementTwo = (int) (Math.random() * 52);

			Card temp = cards[placementOne];
			cards[placementOne] = cards[placementTwo];
			cards[placementTwo] = temp;
		}
	}
	
	public Card deal(){
		// deal the top card in the deck

		top++;

		if (top == 53) {

			top = 1;

		} 

		return cards[top - 1];

	}

	public int getTop() {

		return top;

	}
	
	// add more methods here if needed

}
