/**
 * Created by PJ on 4/19/2017.
 */
public class Checker {
    // This is the piece variable that will hold each Checker's "value"
    public char mPiece;

    public Checker() {}

    public char getPiece() {
        // Return the "value" that is stored for a checker
        return mPiece;
    }

    public void setPiece(char piece) {
        // Set a piece as a passed parameter
        mPiece = piece;
    }
}
