class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        int row = board.length, col = board[0].length;
        for(int i = 0; i < row; i++){ //each row
                if(!isParticallyValid(board, i, i, 0, 8)) return false;
        }
        for(int j = 0; j < col; j++){ //each col
            if(!isParticallyValid(board, 0, 8, j, j)) return false;
        }
        for(int i = 0; i < 3; i++){ //check the 3*3 square
            for(int j = 0; j < 3; j++){
                if(!isParticallyValid(board, i *3, i*3 + 2, j*3, j *3 + 2)) return false;
            }
        }
        return true;
    }
    private boolean isParticallyValid(char[][] board, int x1, int x2, int y1, int y2){ //the area to be checked
        Set<Character> set = new HashSet<>(); //using a HashSet to deduplicate 
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                char temp = board[i][j];
                if(temp != '.' && !set.add(temp)) return false;
            }
        }
        return true;
    }
}

//time: O(m*n)
