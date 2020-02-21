import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundingXO {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return;
        int row = board.length, col = board[0].length;
        Queue<int[]> que = new LinkedList<>();
        //find all Os on the board. and then put them into the que, mark it as Y to distinguish it with the O got surrounded
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                que.offer(new int[]{i, 0});
                board[i][0] = 'Y';
            }
            if (board[i][col - 1] == 'O') {
                que.offer(new int[]{i, col - 1});
                board[i][col - 1] ='Y';
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                que.offer(new int[]{0, j});
                board[0][j] = 'Y';
            }
            if (board[row - 1][j] == 'O') {
                que.offer(new int[]{row - 1, j});
                board[row - 1][j] = 'Y';
            }
        }
        //bfs. from every O from the que
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];
            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                que.offer(new int[]{i - 1, j});
                board[i - 1][j] = 'Y';
            }
            if (i + 1 < row && board[i + 1][j] == 'O') {
                que.offer(new int[]{i + 1, j});
                board[i + 1][j] = 'Y';
            }
            if (j + 1 < col && board[i][j + 1] == 'O') {
                que.offer(new int[]{i, j + 1});
                board[i][j + 1] = 'Y';
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                que.offer(new int[]{i, j - 1});
                board[i][j - 1] = 'Y';
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[][] {{'X','O','X'},{'O','X','O'},{'X','O','X'}};
        solve(board);
        for(char[] row : board) System.out.println(Arrays.toString(row));  //print a 2D array 
    }
}
