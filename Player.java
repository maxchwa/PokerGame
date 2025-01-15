/* Max Chwa
 * Player.java - A template for a Player of video poker.
*/

import java.util.ArrayList; 

public class Player {
	
		
    private ArrayList<Card> hand; // the player's cards
    private double bankroll = 50;
    private double bet;
    private boolean betSizeValidity;
        
    public Player(){		
        // create a player here
        bankroll = 50;
        hand = new ArrayList<>();
        bet = 0;
        betSizeValidity = false;
    }

     public void addCard(Card c){
	    
        hand.add(c);
        // add the card c to the player's hand
     }

     public void removeCard(Card c){

        for (int i = 0; i < 5; i++){

             if (hand.get(i).compareTo(c) == 0) {
                  hand.remove(i);
                  break;
              }

        }
	    // remove the card c from the player's hand
    }

    public void removeIt(int s) {

        hand.remove(s - 1);

    }
		
    public void bets(double amt) {
            // player makes a bet
        if (amt > bankroll || amt < 1 || amt > 5) {

            betSizeValidity = false;

        } else {

            betSizeValidity = true;

            bet = amt;
        }
    }

    public void winnings(double odds){
        //adjust bankroll if player wins

        bankroll = bankroll - bet + bet * odds;
        bet = 0;

    }

    public double getBankroll(){
        // return current balance of bankroll

        return bankroll;

    }

    public ArrayList<Card> getHand() {
        
        return hand;
    }

    public boolean getBetSizeValidity() {

        return betSizeValidity;

    }

    public int getHandLength() {

        return hand.size();

    }

}
    


