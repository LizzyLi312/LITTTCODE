class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        solveBoard(board);
    }
    private boolean solveBoard(char[][] board){
        int row = board.length, col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){ //choose a number to fill in the cell
                            board[i][j] = c;
                            if(solveBoard(board)) return true; //check whether if the number is valid for the whole board
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c){ //check 3 directions
        for(int i = 0; i < 9; i++){
            char colChar = board[i][col]; //they re at the same colunm
            char rowChar = board[row][i];  //theyre at the same row 
            char blockChar = board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3]; 
            //i / 3 : 000111222 i % 3: 012012012 the visiting order: first row, secon row, third row
            if(rowChar != '.' && rowChar == c) return false;
            if(colChar != '.' && colChar == c) return false;
            if(blockChar != '.' && blockChar == c) return false;
        }
        return true;
    }
}
