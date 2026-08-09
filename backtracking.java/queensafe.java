import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class queensafe {
    private static boolean isSafe(int row, int col, char[][] board) {
        // check row to the left
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }
        // check upper-left diagonal
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        // check lower-left diagonal
        for (int r = row + 1, c = col - 1; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> snapshot = new ArrayList<>();
        for (char[] row : board) {
            snapshot.add(new String(row));
        }
        allBoards.add(snapshot);
    }

    private static void helper(char[][] board, List<List<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        helper(board, allBoards, 0);
        return allBoards;
    }

    public static void main(String[] args) {
        List<List<String>> solutions = solveNQueens(4);
        for (List<String> sol : solutions) {
            for (String line : sol) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}
