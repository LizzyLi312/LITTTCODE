class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        int row = board.length, col = board[0].length;
        
        boolean[][] visited = new boolean[row][col];  //need to check visited 
        char[] wordChar = word.toCharArray();
        
        boolean res;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, wordChar, i, j, visited, 0)) //only one works, then return true
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, char[] word, int i, int j, boolean[][] visited, int idx){
        int row = board.length, col = board[0].length, len = word.length;
        if(idx == len) return true;
        if(i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word[idx] || visited[i][j]) return false;
        visited[i][j] = true;
        boolean res = dfs(board, word, i + 1, j, visited, idx + 1) || dfs(board, word, i - 1, j, visited, idx + 1) || dfs(board, word, i, j + 1, visited, idx + 1) || dfs(board, word, i, j - 1, visited, idx + 1);
        //the result will be true if there is one branch returns true
        visited[i][j] = false;
        return res;
            
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];  //defalut value of boolean is false
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dfs(board, word, i, j, visited, 0))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, boolean[][] visited, int idx){
        int row = board.length, col = board[0].length;
        if(idx == word.length()) return true;
        if(i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || word.charAt(idx) != board[i][j]) return false;
        visited[i][j] = true;
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        boolean res = false;
        for(int[] dir : directions){
            res = res || dfs(board, word, i + dir[0], j + dir[1], visited, idx + 1);
        }
        visited[i][j] = false;
        return res;
    }
}
