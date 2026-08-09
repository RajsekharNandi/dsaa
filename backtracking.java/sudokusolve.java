public class sudokusolve {
    public boolean helper (char[][] board, int row, int col){
          if (row == board.length){
            return true;
        }
        int nrow = board.length;
        int ncol = board[0].length;
        if(col != board.length-1){
            nrow = row;
            ncol = col + 1;
        }else{
            nrow = row + 1;
            ncol = 0;
        }
        if(boad[row][col] != '.') {
          if(helper(boad, nrow, ncol)){
          return true;
          }
    } else {
        for(int i=1; i<=9;    i++) {
          if(isSafe(board , row, col, i)) {
            board[row][col] = (char)(i+'0');
            if(helper(board ,nrow,ncol)) {
              return true;
              }  else {
            board[row][col] = '.';
          }    
        }
      }
    }
          return false;
    }
    
    public void solverSudoku(char[][] board)){
        helper(board, 0, 0);
    }
}
