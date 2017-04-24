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

        System.out.println("Congratulations to the Winner and to Both Players on a Successful Game of Checkers!");
    }

    public void gameLoop() {
        CheckersBoard board = new CheckersBoard();
        Scanner scanner = new Scanner(System.in);
        int xPiece; int yPiece; int xMove; int yMove;

        // Set the Board
        board.resetBoard();

        while (gameContinue(u1Pieces, u2Pieces)) {

            // Display the Set Board to Begin the Game
            board.printBoard();

            // Get Input from the User for their Move
            System.out.println("Please Enter The X-Coordinate of the Piece You Would Like to Move: ");
            xPiece = scanner.nextInt() - 1;
            System.out.println("Please Enter The Y-Coordinate of the Piece You Would Like to Move: ");
            yPiece = scanner.nextInt() - 1;
            System.out.println("Please Enter The X-Coordinate of Where You Would Like to Move the Piece: ");
            xMove = scanner.nextInt() - 1;
            System.out.println("Please Enter The Y-Coordinate of Where You Would Like to Move the Piece: ");
            yMove = scanner.nextInt() - 1;

            // Check to See if the Move is Valid, and continue asking until valid input is given
            while (!isValid(user, xPiece, yPiece, xMove, yMove, board)) {
                System.out.println("Invalid. Please Enter New Locations.");
                System.out.println("Please Enter The X-Coordinate of the Piece You Would Like to Move: ");
                xPiece = scanner.nextInt() - 1;
                System.out.println("Please Enter The Y-Coordinate of the Piece You Would Like to Move: ");
                yPiece = scanner.nextInt() - 1;
                System.out.println("Please Enter The X-Coordinate of Where You Would Like to Move the Piece: ");
                xMove = scanner.nextInt() - 1;
                System.out.println("Please Enter The Y-Coordinate of Where You Would Like to Move the Piece: ");
                yMove = scanner.nextInt() - 1;
            }

            // Move the piece to the desired location
            board.movePiece(xPiece, yPiece, xMove, yMove);

            if (user == 1) {
                if (xMove == 0) {
                    board.mBoard[xMove][yMove] = new King();
                    board.mBoard[xMove][yMove].setPiece('X');
                }
            }
            else if (user == 2) {
                if (xMove == 7) {
                    board.mBoard[xMove][yMove] = new King();
                    board.mBoard[xMove][yMove].setPiece('O');
                }
            }

            // Decrement the place holding variables for the amount of pieces each player has if a jump was made
            if (Math.abs(xMove - xPiece) == 2 && Math.abs(yMove - yPiece) == 2) {
                if (user == 1) {
                    u2Pieces -= 1;
                }
                else if (user == 2) {
                    u1Pieces -= 1;
                }
            }

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

        if (Math.abs(xMove - xPiece) > 2 || Math.abs(yMove - yPiece) > 2 ||
                Math.abs(xMove - xPiece) < 1 || Math.abs(yMove - yPiece) < 1) {
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
                            if (board.mBoard[xMove + 1][yMove + 1].getPiece() == 'o' ||
                                    board.mBoard[xMove + 1][yMove + 1].getPiece() == 'O') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (yMove - yPiece == 2) {
                            if (board.mBoard[xMove + 1][yMove - 1].getPiece() == 'o' ||
                                    board.mBoard[xMove + 1][yMove - 1].getPiece() == 'O') {
                                return true;
                            }
                            else { return false; }
                        }
                    }
                    else { return false; }
                }
                else { return false; }
            }
            if (board.mBoard[xPiece][yPiece].getPiece() == 'X') {
                if (Math.abs(xMove - xPiece) == 1 && Math.abs(yMove - yPiece) == 1) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        return true;
                    }
                    else { return false; }
                }
                else if (Math.abs(xMove - xPiece) == 2 && Math.abs(yMove - yPiece) == 2) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        if (xMove - xPiece == -2 && yMove - yPiece == -2) {
                            if (board.mBoard[xMove + 1][yMove + 1].getPiece() == 'o' ||
                                    board.mBoard[xMove + 1][yMove + 1].getPiece() == 'O') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (xMove - xPiece == -2 && yMove - yPiece == 2) {
                            if (board.mBoard[xMove + 1][yMove - 1].getPiece() == 'o' ||
                                    board.mBoard[xMove + 1][yMove - 1].getPiece() == 'O') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (xMove - xPiece == 2 && yMove - yPiece == 2) {
                            if (board.mBoard[xMove - 1][yMove - 1].getPiece() == 'o' ||
                                    board.mBoard[xMove - 1][yMove - 1].getPiece() == 'O') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (xMove - xPiece == 2 && yMove - yPiece == -2) {
                            if (board.mBoard[xMove - 1][yMove + 1].getPiece() == 'o' ||
                                    board.mBoard[xMove - 1][yMove + 1].getPiece() == 'O') {
                                return true;
                            }
                            else { return false; }
                        }
                        else { return false; }
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
                            if (board.mBoard[xMove - 1][yMove + 1].getPiece() == 'x' ||
                                    board.mBoard[xMove - 1][yMove + 1].getPiece() == 'X') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (yMove - yPiece == 2) {
                            if (board.mBoard[xMove - 1][yMove - 1].getPiece() == 'x' ||
                                    board.mBoard[xMove - 1][yMove - 1].getPiece() == 'X') {
                                return true;
                            }
                            else { return false; }
                        }
                    }
                    else { return false; }
                }
            }
            else if (board.mBoard[xPiece][yPiece].getPiece() == 'O') {
                if (Math.abs(xMove - xPiece) == 1 && Math.abs(yMove - yPiece) == 1) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        return true;
                    }
                    else { return false; }
                }
                else if (Math.abs(xMove - xPiece) == 2 && Math.abs(yMove - yPiece) == 2) {
                    if (board.mBoard[xMove][yMove].getPiece() == '.') {
                        if (xMove - xPiece == -2 && yMove - yPiece == -2) {
                            if (board.mBoard[xMove + 1][yMove + 1].getPiece() == 'x' ||
                                    board.mBoard[xMove + 1][yMove + 1].getPiece() == 'X') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (xMove - xPiece == -2 && yMove - yPiece == 2) {
                            if (board.mBoard[xMove + 1][yMove - 1].getPiece() == 'x' ||
                                    board.mBoard[xMove + 1][yMove - 1].getPiece() == 'X') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (xMove - xPiece == 2 && yMove - yPiece == 2) {
                            if (board.mBoard[xMove - 1][yMove - 1].getPiece() == 'x' ||
                                    board.mBoard[xMove - 1][yMove - 1].getPiece() == 'X') {
                                return true;
                            }
                            else { return false; }
                        }
                        else if (xMove - xPiece == 2 && yMove - yPiece == -2) {
                            if (board.mBoard[xMove - 1][yMove + 1].getPiece() == 'x' ||
                                    board.mBoard[xMove - 1][yMove + 1].getPiece() == 'X') {
                                return true;
                            }
                            else { return false; }
                        }
                        else { return false; }
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