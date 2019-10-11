import java.util.*;

public class kthSmallest {
    public static int kthSmallest(int[][] matrix, int k){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return -1;
        int row = matrix.length, col = matrix[0].length;
        Queue<int[]> heap = new PriorityQueue<>(k, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                return matrix[i1[0]][i1[1]] - matrix[i2[0]][i2[1]];
            }
        });
//        boolean[][] visited = new boolean[row][col];
        HashSet<Integer> visited = new HashSet<>();
        heap.offer(new int[]{0, 0});
        int res = 0;
        while(k-- > 0){
            int[] cur = heap.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            res = matrix[curRow][curCol];
            if(isValid(curRow + 1, curCol, row, col, visited)){
                heap.offer(new int[]{curRow + 1, curCol});
//                visited[curRow + 1][curCol] = true;
                visited.add((curRow + 1) * 10 + curCol);
            }
            if(isValid(curRow, curCol + 1, row, col, visited)){
                heap.offer(new int[]{curRow, curCol + 1});
//                visited[curRow][curCol + 1] = true;
                visited.add(curRow * 10 + curCol + 1);
            }
        }
        return res;
    }
    private static boolean isValid(int i, int j, int row, int col, HashSet visited){
        return (i >= 0 && i < row && j >= 0 && j < col && !visited.contains(i * 10 + j));
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix, 8));
    }
}

//Using max heap to get better time and bfs to traverse 
//time: O(n) space: O(m*n) (visited matrix)
//instead use matrix, we could use hashset to reduce space
