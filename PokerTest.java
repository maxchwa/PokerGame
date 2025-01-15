public class PokerTest {
    public static void main(String[] args){

        System.out.println("You start with 50 chips.");

        if (args.length<1){

            Game g = new Game();

            boolean gameEnded = false;

            while (gameEnded == false) {

                g.play();

                gameEnded = g.getGameOver();

            }

        }

        else {

            Game g = new Game(args);
            g.play();
            
        }
    }

}
