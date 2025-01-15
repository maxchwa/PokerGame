/* Max Chwa
 * Game.java - A template that creates a Game of video poker.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Player p;
	private Deck cards;
	private Scanner input;
	private int payout;
    private boolean gameOver;
	
	public Game(String[] testHand){

		p = new Player();

		cards = new Deck();

        for (int i = 0; i < 5; i++) {

            Card c = new Card(testHand[i]);

            p.addCard(c);

        }

        input = new Scanner(System.in);

        payout = 0;

        gameOver = false;

    }
		
		// This constructor is to help test your code.
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace-king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
	
	public Game(){
		// This no-argument constructor is to play a normal game
		p = new Player();

		cards = new Deck();
		
        input = new Scanner(System.in);

        payout = 0;

        cards.shuffle();

	}
	
	public void play(){

        if (p.getHandLength() != 0) {

            for (int i = 0; i <= 4; i++) {
        
                p.removeIt(1);

            }

        }

		for (int i = 0; i < 5; i++) {

            if (cards.getTop() == 52) {

                cards.shuffle();

            }

			p.addCard(cards.deal());

		} 

		System.out.println();
        
		System.out.println();

		System.out.println("How many chips are you betting? (1-5)");

        boolean betValidity = false;

        while (betValidity == false) {

    		String bet = input.nextLine();

            int betTwo = Integer.parseInt(bet);

		    p.bets(betTwo);

		    if (bet.length() < 1 || p.getBetSizeValidity() == false) {

                betValidity = false;
                System.out.println("Bet invalid. Please put new bet (1-5, not more than the amount of chips).");
                System.out.println();
		    
            } else {

                betValidity = true;

            }
        
        }

		int cardsToReplace = 0;

		System.out.println();

		System.out.println("Your cards are: " + checkHand(p.getHand()));

		System.out.println();

        String[] placementsChangedArrayString = null;

        boolean acceptableFirstResponse = false;

        while (acceptableFirstResponse == false) {
    
    		System.out.println("Would you like to replace any cards? (Answer 'Yes' or 'No'.)");

	    	String beginReplacing = input.nextLine();

	    	System.out.println();

		    if (beginReplacing.equals("No")) {

                acceptableFirstResponse = true;

			    System.out.println("No cards changed.");

    		} else if (beginReplacing.equals("Yes")) {

                acceptableFirstResponse = true;

	    		System.out.println("If so, enter the placement of each card to be replaced in your hand e.g. '1 3 4' to replace the first, third and fourth cards.");

	    		boolean isAcceptableValue = false;

                while (isAcceptableValue == false) {

    		    	String placementsChanged = input.nextLine();

	    		    placementsChangedArrayString = placementsChanged.split(" ");

	    	    	String [] acceptableValues = {"1", "2", "3", "4", "5"};

	    	    	for (int i = 0; i < placementsChangedArrayString.length; i++) {

		    		    for (int j = 0; j < 5; j++) {

				    	    if (placementsChangedArrayString[i].equals(acceptableValues[j])) {

					    	    isAcceptableValue = true;

					        }

				        }

				        if (isAcceptableValue == false) {

					        System.out.println("Card placement invalid. Please enter new placement.");

				        }

    			    }

                }

			    if (placementsChangedArrayString.length > 5) {

				    System.out.println("Invalid input. Too many cards changed.");

			    }

			    int [] placementsChangedArrayInt = {-1, -1, -1, -1, -1} ;

			    int count = 4;

			    for (int i = 0; i < placementsChangedArrayString.length; i++) {

				    placementsChangedArrayInt[count] = Integer.parseInt(placementsChangedArrayString[i]);

				    count--;

			    }

                for (int i = 0; i < 5; i++) {

				    if (placementsChangedArrayInt[i] != -1) {

					    cardsToReplace++; 

                	    p.removeIt(placementsChangedArrayInt[i]);

				    } 

                }


                System.out.println("");

			    for (int i = 0; i < cardsToReplace; i++) {
	
				    p.addCard(cards.deal());

			    }	

			    System.out.println("Your cards are: " + checkHand(p.getHand()));

		        // this method should play the game			
		
            } else {

			    System.out.println("Answer invalid.");
			    System.out.println();

		    }

        }

		System.out.println();
		assessHand();

		System.out.println();
		p.winnings(payout);

		System.out.println("Current bankroll is: " + p.getBankroll());

        if (p.getBankroll() == 0) {

            System.out.println("Game Over. You lost.");

            gameOver = true;

        } else if (p.getBankroll() >= 100) {

            System.out.println("Game Over. You won!");

            gameOver = true;

        } else {

        }
	
	}
	
	public String checkHand(ArrayList<Card> hand){

		String handInText = "";
		for (int i = 0; i < hand.size(); i++) {

			handInText += (hand.get(i)).toString();

			if (i < hand.size() - 1) {

				handInText += ", ";

			}

		}
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		return handInText;
		
	}

    public boolean getGameOver() {

        return gameOver;

    }

	public void assessHand() {

        boolean pairOne = false;
        boolean pairTwo = false;
        boolean threeOfAKind = false;
        boolean fourOfAKind = false;
        boolean isStraight = true;
        boolean isFlush = false;
        boolean digitsRoyal = false;

        String cardOne = (p.getHand().get(0)).cardInCode();
        String cardTwo = (p.getHand().get(1)).cardInCode();
        String cardThree = (p.getHand().get(2)).cardInCode();
        String cardFour = (p.getHand().get(3)).cardInCode();
        String cardFive = (p.getHand().get(4)).cardInCode();

        int digitOne = Integer.parseInt(cardOne.substring(1, cardOne.length()));
        int digitTwo = Integer.parseInt(cardTwo.substring(1, cardTwo.length()));
        int digitThree = Integer.parseInt(cardThree.substring(1, cardThree.length()));
        int digitFour = Integer.parseInt(cardFour.substring(1, cardFour.length()));
        int digitFive = Integer.parseInt(cardFive.substring(1, cardFive.length()));

        String suitOne = cardOne.substring(0, 1);
        String suitTwo = cardTwo.substring(0, 1);
        String suitThree = cardThree.substring(0, 1);
        String suitFour = cardFour.substring(0, 1);
        String suitFive = cardFive.substring(0, 1);

        int [] intsOfAll = {digitOne, digitTwo, digitThree, digitFour, digitFive};

        for (int i = 0; i < 5; i++) {

            int locmin = i;

            for (int j = i + 1; j < 5; j++) {

                if (intsOfAll[locmin] > intsOfAll[j]) {
                    
                    locmin = j;
                
                }

            }

            int temp = intsOfAll[locmin];

            intsOfAll[locmin] = intsOfAll[i];

            intsOfAll[i] = temp;
        
        }

        for (int i = 0; i < 4; i++) {

            if (intsOfAll[i] + 1 != intsOfAll[i + 1]) {
                isStraight = false;
                break;
            }

        }

        if (intsOfAll[0] == 1 && intsOfAll[1] == 10 && intsOfAll[2] == 11 && intsOfAll[3] == 12 && intsOfAll[4] == 13) {
            isStraight = true;
            digitsRoyal = true; 
        }

        int numberOfSameDigitsFirst = 1;
        boolean oneSameDigitDetected = false;
        int nextStartingPoint = 0;

        for (int i = 0; i < 4; i++) {

            if (intsOfAll[i] == intsOfAll[i + 1]) {

                oneSameDigitDetected = true;
                numberOfSameDigitsFirst++;
                nextStartingPoint = i + 1;

            } else {

                if (oneSameDigitDetected == true) {
                    break;
                }

            }

        }

        if (numberOfSameDigitsFirst == 2) {
            pairOne = true;
        } else if (numberOfSameDigitsFirst == 3) {
            threeOfAKind = true;
        } else if (numberOfSameDigitsFirst == 4) {
            fourOfAKind = true;
        }

        int numberOfSameDigitsSecond = 1;
        oneSameDigitDetected = false;

        if (fourOfAKind == false && nextStartingPoint < 4) {

            for (int i = nextStartingPoint; i < 4; i++) {

                if (intsOfAll[i] == intsOfAll[i + 1]) {

                    oneSameDigitDetected = true;
                    numberOfSameDigitsSecond++;

                } else {

                    if (oneSameDigitDetected == true) {
                            break;
                    }
    
                }

            }

        }

        if(numberOfSameDigitsSecond == 2) {

            if (pairOne == true) {
                pairTwo = true;
            } else {
                pairOne = true;
            }

        }

        if(numberOfSameDigitsSecond == 3) {
            threeOfAKind = true;
        }

        String[] suitsOfAll = {suitOne, suitTwo, suitThree, suitFour, suitFive};
        int numberOfSameSuits = 1;

        for (int i = 1; i <= 4; i++) {

            if (suitOne.equals(suitsOfAll[i])) {
                    numberOfSameSuits++;
            }
    
        }
    
        if (numberOfSameSuits == 5) {
            isFlush = true;
        }

        if (digitsRoyal && isFlush) {
            payout = 250;
            System.out.println("You have a royal flush!");
        } else if (isStraight && isFlush) {
            payout = 50;
            System.out.println("You have a straight flush!");
        } else if (fourOfAKind) {
            payout = 25;
            System.out.println("You have a four of a kind!");
        } else if (threeOfAKind && pairOne) {
            payout = 6;
            System.out.println("You have a full house!");
        } else if (isFlush) {
            payout = 5;
            System.out.println("You have a flush!");
        } else if (isStraight) {
            payout = 4;
            System.out.println("You have a straight!");
        } else if (threeOfAKind) {
            payout = 3;
            System.out.println("You have a three of a kind!");
        } else if (pairOne && pairTwo) {
            payout = 2;
            System.out.println("You have two pairs!");
        } else if (pairOne) {
            payout = 1;
            System.out.println("You have a pair!");
        } else {
            payout = 0;
            System.out.println("Your cards don't come together to form anything...");
        }

    }

	
	// you will likely want many more methods here
	// per discussion in class
}
