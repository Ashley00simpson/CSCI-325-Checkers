/**
 * Created by zacke on 4/24/2017.
 */

public class CheckersBoard {
    public CheckersBoard() {}

    // This is the two dimensional array that will be the board
    public Checker[][] mBoard = new Checker[8][8];

    public void resetBoard() {
        // Preset the board with fresh checkers
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                mBoard[i][j] = new Checker();
            }
        }

        // Set the board up in the correct format
        mBoard[0][0].setPiece('o');
        mBoard[0][1].setPiece('.');
        mBoard[0][2].setPiece('o');
        mBoard[0][3].setPiece('.');
        mBoard[0][4].setPiece('o');
        mBoard[0][5].setPiece('.');
        mBoard[0][6].setPiece('o');
        mBoard[0][7].setPiece('.');
        mBoard[1][0].setPiece('.');
        mBoard[1][1].setPiece('o');
        mBoard[1][2].setPiece('.');
        mBoard[1][3].setPiece('o');
        mBoard[1][4].setPiece('.');
        mBoard[1][5].setPiece('o');
        mBoard[1][6].setPiece('.');
        mBoard[1][7].setPiece('o');
        mBoard[2][0].setPiece('o');
        mBoard[2][1].setPiece('.');
        mBoard[2][2].setPiece('o');
        mBoard[2][3].setPiece('.');
        mBoard[2][4].setPiece('o');
        mBoard[2][5].setPiece('.');
        mBoard[2][6].setPiece('o');
        mBoard[2][7].setPiece('.');
        mBoard[3][0].setPiece('.');
        mBoard[3][1].setPiece('.');
        mBoard[3][2].setPiece('.');
        mBoard[3][3].setPiece('.');
        mBoard[3][4].setPiece('.');
        mBoard[3][5].setPiece('.');
        mBoard[3][6].setPiece('.');
        mBoard[3][7].setPiece('.');
        mBoard[4][0].setPiece('.');
        mBoard[4][1].setPiece('.');
        mBoard[4][2].setPiece('.');
        mBoard[4][3].setPiece('.');
        mBoard[4][4].setPiece('.');
        mBoard[4][5].setPiece('.');
        mBoard[4][6].setPiece('.');
        mBoard[4][7].setPiece('.');
        mBoard[5][0].setPiece('.');
        mBoard[5][1].setPiece('x');
        mBoard[5][2].setPiece('.');
        mBoard[5][3].setPiece('x');
        mBoard[5][4].setPiece('.');
        mBoard[5][5].setPiece('x');
        mBoard[5][6].setPiece('.');
        mBoard[5][7].setPiece('x');
        mBoard[6][0].setPiece('x');
        mBoard[6][1].setPiece('.');
        mBoard[6][2].setPiece('x');
        mBoard[6][3].setPiece('.');
        mBoard[6][4].setPiece('x');
        mBoard[6][5].setPiece('.');
        mBoard[6][6].setPiece('x');
        mBoard[6][7].setPiece('.');
        mBoard[7][0].setPiece('.');
        mBoard[7][1].setPiece('x');
        mBoard[7][2].setPiece('.');
        mBoard[7][3].setPiece('x');
        mBoard[7][4].setPiece('.');
        mBoard[7][5].setPiece('x');
        mBoard[7][6].setPiece('.');
        mBoard[7][7].setPiece('x');
    }

    public void printBoard() {
        // Print the board out in the correct format with the correct ruler metric
        System.out.println("    1  2  3  4  5  6  7  8");
        for (int i = 0; i < 8; ++i) {
            System.out.print(" " + (i + 1) + " ");
            for (int j = 0; j < 8; ++j) {
                System.out.print(" " + mBoard[i][j].getPiece() + " ");
            }
            System.out.println();
        }
    }

    public void movePiece(int xPiece, int yPiece, int xMove, int yMove) {
        // Move the current piece to the new position, and then remove it from the old position
        mBoard[xMove][yMove].setPiece(mBoard[xPiece][yPiece].getPiece());
        mBoard[xPiece][yPiece].setPiece('.');

        // If a jump has been made, remove the opponent's piece also
        if (yMove - yPiece == 2 && xMove - xPiece == -2) {
            mBoard[xMove + 1][yMove - 1].setPiece('.');
        }
        else if (yMove - yPiece == -2 && xMove - xPiece == -2) {
            mBoard[xMove + 1][yMove + 1].setPiece('.');
        }
        else if (yMove - yPiece == 2 && xMove - xPiece == 2) {
            mBoard[xMove - 1][yMove - 1].setPiece('.');
        }
        else if (yMove - yPiece == -2 && xMove - xPiece == 2) {
            mBoard[xMove - 1][yMove + 1].setPiece('.');
        }
    }
}
