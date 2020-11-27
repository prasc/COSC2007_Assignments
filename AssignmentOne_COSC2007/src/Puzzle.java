import java.util.Arrays;

public class Puzzle {
    private int pegs = countPegs();


    int row = 0;
    int col = 0;
    int row2 = 0;
    int col2 = 0;
    int row3 = 0;
    int col3 = 0;

    private static char board[][] =
            {
                {' ', ' ', 'X', 'X', 'X', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X', ' ', ' '},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', 'X', 'X', 'X', ' ', ' '},
                {' ', ' ', 'X', 'X', 'X', ' ', ' '}
           };

    public int countPegs() {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'X') count++;
            }
        }
        return count;
    }

    private boolean findSolution() {
        if (board[3][3] == 'X' && pegs == 1) {
            print();
            return true;
        } else {
            for (int i = 0; i < board.length; i++) {                  // loop through rows
                for (int j = 0; j < board.length; j++) {              // loop through columns
                    for (int k = 0; k < 4; k++) {              // try every possible move at this spot (up, left, down, right)
                        print();
                        System.out.println();
                        row = j;
                        col = i;

                        if (k == 0) {                           // try moving UP
                            row2 = row+1;
                            col2 = col;
                            row3 = row+2;
                            col3 = col;

                        } else if (k == 1) {                    // try moving left
                            row2 = row;
                            col2 = col-1;
                            row3 = row;
                            col3 = col-2;

                        } else if (k == 2) {                    // try moving right
                            row2 = row;
                            col2 = col+1;
                            row3 = row;
                            col3 = col+2;

                        } else if (k == 3) {                    // try moving down
                            row2 = row - 1;
                            col2 = col;
                            row3 = row - 2;
                            col3 = col;
                        }


                        if (isValid(row, col, row2, col2, row3, col3)) {

                            board[row][col] = 'O';
                            board[row2][col2] = 'O';
                            board[row3][col3] = 'X';

                            pegs--;

                            if (findSolution()) {
                                return true;
                            }

                            board[row][col] = 'X';
                            board[row2][col2] = 'X';
                            board[row3][col3] = 'O';

                            pegs++;
                        }
                    }
                }
            }
            return false;
        }
    }


    private boolean isValid(int row, int col, int row2, int col2, int row3, int col3) {

        if (row3 >= 7 || col3 >= 7 || row3 < 0 || col3 < 0)
            return false;

        return 	(board[row][col] == 'X') &&
                (board[row2][col2] == 'X') &&
                (board[row3][col3] == 'O') ;
    }

    public void main() {
        findSolution();
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
