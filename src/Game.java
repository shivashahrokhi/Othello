import java.util.Scanner;

/***
 * This class contains necessary items for implementing the othello game like a board and 2 players and methods for managing the game.
 * @author Shiva
 * @since 12/04/2020
 */
public class Game {

    //The 8x8 board of othello
    public static Board board;
    //The player with black discs
    private Player black;
    //The player with white discs
    private Player white;
    //Who is turn to play
    public Player turn;

    /***
     * Game constructor makes the game and initialize the fields.
     */
    public Game() {
        //make the board
        this.board = new Board();
        //make the black player
        this.black = new Player('b');
        //make the white player
        this.white = new Player('w');
        //First turn is for black
        this.turn = black;
    }

    /***
     * This method changes the turn of playing.
     */
    public void changeTurn() {
        if (turn == black)
            turn = white;
        else
            turn = black;
    }

    /***
     * This method prints the number of every player's disc.
     */
    public void printStatus() {
        System.out.println("White: " + Disc.numOfWhite + "  Black: " + Disc.numOfBlack);
    }

    /***
     * This method detect the game is over or not.The game is over when both players cannot have a move or the board is full.
     * @return true if game is over and false otherwise
     */
    public boolean gameOver() {
        if (white.hasMove() || black.hasMove())
            return false;
        else if (Disc.numOfBlack + Disc.numOfWhite < 64)
            return false;
        return true;
    }

    /***
     * This method finishes the game and prints the result.
     */
    public void endGame() {
        if (Disc.numOfWhite > Disc.numOfBlack)
            System.out.println("Game over. The winner is white.");
        else if (Disc.numOfBlack > Disc.numOfWhite)
            System.out.println("Game over. The winner is black.");
        else
            System.out.println("Game over. It is a tie game.");
    }
}
