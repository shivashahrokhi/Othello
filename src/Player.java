import java.util.ArrayList;
import java.util.Scanner;

/***
 * This class holds the information of player and methods which implement every action of player in the game.
 * @author Shiva
 * @since 12/04/2020
 */
public class Player {

    //Colour of player's discs
    char colour;

    /***
     * Player constructor makes a new player by given colour.
     * @param colour It is the colour of player's discs.
     */
    public Player (char colour) {
        this.colour = colour;
    }

    /***
     * This method make a new disc and add it on the given coordination of the board.
     * @param row It is the the number of the row that the player wants to add the new disc.
     * @param column It is the the number of the column that the player wants to add the new disc.
     */
    public void addDisc(int row, int column) {
        Disc newDisc = new Disc(colour);
        Game.board.addDisc(row, column, newDisc);
    }

    /***
     * This method lets the player insert the location of the new disc in specific format(number of the row and letter of the column)
     * and change it to Corresponding numbers in array of board.
     * @return an array of two integers which are the Corresponding numbers in the array of board
     */
    public int[] insertLocation(){
        int[] location = new int[2];
        Scanner scanner = new Scanner(System.in);
        location[0] = scanner.nextInt() - 1;
        switch (scanner.next()) {
            case ("A"):
                location[1] = 0;
                break;
            case("B"):
                location[1] = 1;
                break;
            case ("C"):
                location[1] = 2;
                break;
            case ("D"):
                location[1] = 3;
                break;
            case ("E"):
                location[1] = 4;
                break;
            case ("F"):
                location[1] = 5;
                break;
            case ("G"):
                location[1] = 6;
                break;
            case ("H"):
                location[1] = 7;
                break;
        }
        return location;
    }

    /***
     * This method find all direction around a given location which have the opponent's discs
     * @param row It is the row of location in the board
     * @param column It is the column of location in the board
     * @return an array list of all directions which are the 2D array of integers
     */
    private ArrayList<int[]> findDirections(int row, int column) {
        ArrayList<int[]> directions = new ArrayList<int[]>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(i == 0 && j == 0)
                    continue;
                else
                if(row + i > -1 && row + i < 8 && column + j > -1 && column + j < 8) {
                    if (Game.board.board[row + i][column + j] != null) {
                        if (Game.board.board[row + i][column + j].getColour() != colour) {
                            directions.add(new int[2]);
                            directions.get(directions.size() - 1)[0] = i;
                            directions.get(directions.size() - 1)[1] = j;
                        }
                    }
                }
            }
        }
        return directions;
    }

    /***
     * This method checks if there is a line of opponent's discs in given direction or not.
     * @param row It is the row of the starting point.
     * @param column It is the column of the starting point.
     * @param direction It is an 2D array consists of two integers between -1 and 1 which make a direction to check.
     * @return true if there is a line of opponent's discs and false otherwise.
     */
    private boolean checkDirection(int row, int column, int[] direction) {
        int currentRow= row + direction[0];
        int currentColumn = column + direction[1];
        if (currentRow == 8 || currentRow < 0 || currentColumn == 8 || currentColumn < 0)
        {
            return false;
        }
        else while (Game.board.board[currentRow][currentColumn] != null) {
            if (Game.board.board[currentRow][currentColumn].getColour() == colour)
                return true;
            else {
                currentRow += direction[0];
                currentColumn += direction[1];
            }
            if (currentRow < 0 || currentColumn < 0 || currentRow == 8 || currentColumn == 8)
                break;
        }
        return false;
    }

    /***
     * This method will determine if the player has selected a valid move.
     *  A valid move is when the player has selected an empty square, adjacent to a line of opposite disks which is end with one of the same discs.
     * @param row It is the row of board which the player want put a disc.
     * @param column It is the column of board which the player wants to put a disc.
     * @return true if the requested move is valid and fals if it is not valid
     */
    public boolean validMove(int row, int column) {
        if (Game.board.board[row][column] != null)
            return false;
        else
            for (int[] direction:this.findDirections(row,column)
                 ) {
                if (this.checkDirection(row, column,direction))
                    return true;
            }
        return false;
    }

    /***
     * This method checks if the player can play a valid move or not.
     * @return true if the player has a valid move to play and false otherwise
     */
    public boolean hasMove() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Game.board.board[i][j] == null && this.validMove(i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /***
     * This method play a valid move by adding a disc on given location and flip the discs.
     * @param row It is the the number of the row that the player wants to add the disc.
     * @param column It is the the number of the column that the player wants to add the disc.
     */
    public void move(int row, int column) {
        this.addDisc(row, column);
        for (int[] direction:this.findDirections(row, column)
             ) {
            if (this.checkDirection(row, column, direction)) {
                int currentRow= row + direction[0];
                int currentColumn = column + direction[1];
                while (Game.board.board[currentRow][currentColumn].getColour() != colour){
                    Game.board.board[currentRow][currentColumn].flip();
                    currentRow += direction[0];
                    currentColumn += direction[1];
                }
            }
        }
    }

    /***
     * This method make a string for the disc according to its colour.
     * @return a string which is the colour of the disc
     */
    public String toString() {
        if (colour == 'w')
            return "white";
        else
            return "black";
    }
}
