/***
 * This class is the implementation of a disc used to filled the board.It is also can count the number of made discs by its static fields.
 *  @author Shiva
 *  @since 12/04/2020
 */
public class Disc {

    //The colour of the disc: w for white and b for black discs
    private char colour;
    //The number of white discs
    public static int numOfWhite = 0;
    //The number of black discs
    public static int numOfBlack = 0;

    /***
     * Disc constructor makes a new disc and increases the number of discs according to its colour.
     * @param colour It is the colour of disc we want to make.
     */
    public Disc(char colour) {
        this.colour = colour;
        if(colour == 'w') {
            numOfWhite ++;
        }
        else {
            numOfBlack ++;
        }
    }

    /***
     * Get the Colour of the disc
     * @return the Colour of the disc
     */
    public char getColour() {
        return colour;
    }

    /***
     * This method flips the disc by switching its colour and also changes the number of each group of discs.
     */
    public void flip() {
        if(colour == 'w') {
            colour = 'b';
            numOfWhite --;
            numOfBlack ++;
        }
        else {
            colour = 'w';
            numOfBlack --;
            numOfWhite ++;
        }
    }
}
