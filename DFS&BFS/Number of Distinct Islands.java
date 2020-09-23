import java.util.HashSet;

//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
// Count the number of distinct islands.
// An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
//        Example 1:
//        11000
//        11000
//        00011
//        00011
//        Given the above grid map, return 1.
//        Example 2:
//        11011
//        10000
//        00001
//        11011
//        Given the above grid map, return 3.
public class Distinct {
    public static int numDistinctIslands(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        HashSet<String> set = new HashSet<>();  //using a set to deduplicate the shape 
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] != 0){
                    StringBuilder sb = new StringBuilder();  //using stringbuilder to record the shape of the islands
                    dfs(i, j, grid, sb, 's');
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private static void dfs(int i, int j, int[][] grid, StringBuilder sb, char dir){
        int row = grid.length;
        int col = grid[0].length;
        if(i >= row || i < 0 || j < 0 || j >= col || grid[i][j] == 0) return;
        grid[i][j] = 0; //using as visited matrix 
        sb.append(dir);
        dfs(i + 1, j, grid, sb, 'r');
        dfs(i -1, j, grid, sb, 'l');
        dfs(i, j + 1, grid, sb, 'u');
        dfs(i, j - 1, grid, sb, 'd');
        //after traverse every dirctions then return 
        sb.append('b');  //when it takes turns also need a flag 
    }

    public static void main(String[] args) {
        int[][] inn;
        inn = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0,0,0,1,1}, {0,0,0,1,1}};
        System.out.println(numDistinctIslands(inn));
    }
}
