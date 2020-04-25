/***
 * This class implements the 8x8 board of the game with a 2D array of discs.
 *  @author Shiva
 *  @since 12/04/2020
 */
public class Board {

    //A 2D array of board
    Disc[][] board;

    /***
     * Board constructor makes the board and set the first state of the discs.
     */
    public Board(){

        board = new Disc[8][8];
        board[3][3] = new Disc('w');
        board[3][4] = new Disc('b');
        board[4][3] = new Disc('b');
        board[4][4] = new Disc('w');
    }

    /***
     * This method changes a null disc in the array to a meaningful disc which is made in the game for one player.
     * @param row It is the row of disc in array.
     * @param column It is the column of disc in array.
     * @param disc It is the new disc which is should be set.
     */
    public void addDisc(int row, int column, Disc disc) {
        board[row][column] = disc;
    }

    /***
     * This method prints the board in the console.
     */
    public void printBoard() {
        System.out.printf(" %c %c %c %c %c %c %c %c\n", '\u24B6', '\u24B7','\u24B8','\u24B9','\u24BA','\u24BB','\u24BC','\u24BD','\u24BF');
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d",i + 1);
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null)
                    System.out.printf("%c%c|", '\u2022','\u2022');
                else if(board[i][j].getColour() == 'b')
                    System.out.printf("%c|",'\u2B24');
                else
                    System.out.printf("%c|",'\u25CB');
            }
            System.out.println();
        }
    }



}
