import java.util.Scanner;

/***
 * This class implement the main scenario of the othello game.
 * @author Shiva
 * @since 12/04/2020
 */
public class Main {

    /***
     * The main method is the program's entry point.
     * @param args It is an array of command-line arguments for the application
     */
    public static void main(String[] args) {

        //make the board of the game
        Game game = new Game();

        //The game plays while it is not over
        while (!game.gameOver()) {
            //print number of discs of each player
            game.printStatus();
            //show the board
            Game.board.printBoard();
            System.out.println("Turn with: " + game.turn.toString());
            if (game.turn.hasMove()) {
                System.out.println("Please insert a location:");

                int row;
                int column;

                // Get a location from the player until the chosen location be valid
                while (true) {
                    int[] location = game.turn.insertLocation();
                    row = location[0];
                    column = location[1];
                   if (game.turn.validMove(row, column))
                       break;
                   else
                       System.out.println("Invalid location.Please try again...");
                }

                game.turn.move(row, column);
                // After the move of one player, switch the turn
                game.changeTurn();
            } else {
                System.out.println("pass");
                game.changeTurn();
            }
        }
        //end of the game and showing the result
        game.endGame();
    }
}
