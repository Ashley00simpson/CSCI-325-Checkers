import java.util.Scanner;

/**
 * Created by PJ on 4/19/2017.
 */
public class Main {

    public Main() {}

    public int user = 1; public int u1Pieces = 12; public int u2Pieces = 12;

    public static void main(String[] args) {
        Main m = new Main();
        m.gameLoop();
    }

    public void gameLoop() {
        CheckersBoard board = new CheckersBoard();
        Scanner scanner = new Scanner(System.in);
        int xPiece; int yPiece; int xMove; int yMove;

        while (gameContinue(u1Pieces, u2Pieces)) {
            // Display the Set Board to Begin the Game
            board.printBoard();

            // Get Input from the User for their Move
            System.out.println("Please Enter The X-Coordinate of the Piece You Would Like to Move: ");
            xPiece = scanner.nextInt();
            System.out.println("Please Enter The Y-Coordinate of the Piece You Would Like to Move: ");
            yPiece = scanner.nextInt();
            System.out.println("Please Enter The X-Coordinate of Where You Would Like to Move the Piece: ");
            xMove = scanner.nextInt();
            System.out.println("Please Enter The Y-Coordinate of Where You Would Like to Move the Piece: ");
            yMove = scanner.nextInt();

            // Check to See if the Move is Valid, and continue asking until valid input is given
            while (!isValid(user, xPiece, yPiece, xMove, yMove, board)) {
                System.out.println("Please Enter The X-Coordinate of the Piece You Would Like to Move: ");
                xPiece = scanner.nextInt();
                System.out.println("Please Enter The Y-Coordinate of the Piece You Would Like to Move: ");
                yPiece = scanner.nextInt();
                System.out.println("Please Enter The X-Coordinate of Where You Would Like to Move the Piece: ");
                xMove = scanner.nextInt();
                System.out.println("Please Enter The Y-Coordinate of Where You Would Like to Move the Piece: ");
                yMove = scanner.nextInt();
            }

            // Move the piece to the desired location
            board.movePiece(xPiece, yPiece, xMove, yMove);

            // Change the Current User Variable to the Next User
            if (user == 1) {
                user = 2;
            }
            else {
                user = 1;
            }
        }
    }

    public boolean isValid(int user, int xPiece, int yPiece, int xMove, int yMove, CheckersBoard board) {
        if (xPiece < 0 || xPiece > 7 || yPiece < 0 || yPiece > 7 || xMove < 0 || xMove > 7 || yMove < 0 || yMove > 7) {
            return false;
        }

        if (Math.abs(xMove - xPiece) > 2 || Math.abs(yMove - yPiece) > 2 || Math.abs(xMove - xPiece) < 1 || Math.abs(yMove - yPiece) < 1) {
            return false;
        }

        if (user == 1) {
            if (board.mBoard[xPiece][yPiece].getPiece() == 'x') {
                if (xMove - xPiece == -1 && Math.abs(yMove - yPiece) == 1) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        return true;
                    }
                    else { return false; }
                }
                else if (xMove - xPiece == -2 && Math.abs(yMove - yPiece) == 2) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        if (yMove - yPiece == -2) {
                            if (board.mBoard[xMove + 1][yMove + 1].getPiece() == 'o') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (yMove - yPiece == 2) {
                            if (board.mBoard[xMove + 1][yMove - 1].getPiece() == 'o') {
                                return true;
                            }
                            else { return false; }
                        }
                    }
                    else { return false; }
                }
                else { return false; }
            }
            else { return false; }
        }
        else if (user == 2){
            if (board.mBoard[xPiece][yPiece].getPiece() == 'o') {
                if (xMove - xPiece == 1 && Math.abs(yMove - yPiece) == 1) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        return true;
                    }
                    else {return false; }
                }
                else if (xMove - xPiece == 2 && Math.abs(yMove - yPiece) == 2) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        if (yMove - yPiece == -2) {
                            if (board.mBoard[xMove - 1][yMove + 1].getPiece() == 'x') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (yMove - yPiece == 2) {
                            if (board.mBoard[xMove - 1][yMove - 1].getPiece() == 'x') {
                                return true;
                            }
                            else { return false; }
                        }
                    }
                    else { return false; }
                }
            }
            else { return false; }
        }
        return false;
    }

    public boolean gameContinue(int u1Pieces, int u2Pieces) {
        if (u1Pieces == 0 || u2Pieces == 0) {
            return false;
        }
        else { return true; }
    }


}
