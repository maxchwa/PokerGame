/* Max Chwa
 * Card.java - A template for a Card.
*/

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
		//make a card with suit s and value v
		suit = s;
		rank = r;
	}

	public Card(String cardInCode){

		String suitLetter = cardInCode.substring(0, 1);

		if (suitLetter.equals("s")) {
			suit = 1;
		} else if (suitLetter.equals("h")) {
			suit = 2;
		} else if (suitLetter.equals("c")) {
			suit = 3;
		} else {
			suit = 4;
		}

		String rankInString = cardInCode.substring(1, cardInCode.length());

		if (rankInString.equals("1")) {

			rank = 1;

		} else if (rankInString.equals("2")) {

			rank = 2;

		} else if (rankInString.equals("3")) {

			rank = 3;

		} else if (rankInString.equals("4")) {

			rank = 4;

		} else if (rankInString.equals("5")) {

			rank = 5;

		} else if (rankInString.equals("6")) {

			rank = 6;

		} else if (rankInString.equals("7")) {

			rank = 7;

		} else if (rankInString.equals("8")) {

			rank = 8;

		} else if (rankInString.equals("9")) {

			rank = 9;

		} else if (rankInString.equals("10")) {

			rank = 10;

		} else if (rankInString.equals("11")) {

			rank = 11;

		} else if (rankInString.equals("12")) {

			rank = 12;

		} else if (rankInString.equals("13")) {

			rank = 13;

		}


	}

	public int suit() {
		return suit;
	}

	public int rank() {
		return rank;
	}
	
	public int compareTo(Card c){

		if (rank > c.rank) {

			return 1;

		} else if (rank < c.rank) {

			return -1;

		}

		if (rank > c.rank) {

			return 1;

		} else if (rank < c.rank) {

			return -1;

		} else {

			return 0;
		
		}

		// use this method to compare cards so they 
		// may be easily sorted

	}
	
	public String toString(){

		String cardName = "";

		if (rank == 1) {

			cardName += "Ace";

		}  else if (rank == 2) {

			cardName += "Two";

		}  else if (rank == 3) {

			cardName += "Three";

		}  else if (rank == 4) {

			cardName += "Four";

		}  else if (rank == 5) {

			cardName += "Five";

		}  else if (rank == 6) {

			cardName += "Six";

		}  else if (rank == 7) {

			cardName += "Seven";

		}  else if (rank == 8) {

			cardName += "Eight";

		}  else if (rank == 9) {

			cardName += "Nine";

		}  else if (rank == 10) {

			cardName += "Ten";

		}  else if (rank == 11) {

			cardName += "Jack";

		} else if (rank == 11) {

			cardName += "Jack";

		} else if (rank == 12) {

			cardName += "Queen";

		} else if (rank == 13) {

			cardName += "King";

		} 

		if (suit == 1) {
			cardName += " of Spades";
		} else if (suit == 2) {
			cardName += " of Hearts";
		} else if (suit == 3) {
			cardName += " of Clubs";
		} else if (suit == 4) {
			cardName += " of Diamonds";
		}


		return cardName;

		// use this method to easily print a Card object
	}

	public String cardInCode() {
	
		String cardInCode = "";
		if (suit == 1) {
			cardInCode += "s";
		} else if (suit == 2) {
			cardInCode += "h";
		} else if (suit == 3) {
			cardInCode += "c";
		} else if (suit == 4) {
			cardInCode += "d";
		}

		cardInCode += rank;

		return cardInCode;
	}
	// add some more methods here if needed

}