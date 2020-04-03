class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n < 0) return res;
        char[][] matrix = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = '.';
            }
        } //time: O(n*n)
        dfs(n, res, matrix, 0);
        return res;
    }
    private void dfs(int n, List<List<String>> res, char[][] matrix, int index){
        if(index == n){
            res.add(build(matrix));
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(matrix, i, index)){
                matrix[i][index] = 'Q';
                dfs(n, res, matrix, index + 1);
                matrix[i][index] = '.';  //backtracing
            }
        }
    }
    private boolean isValid(char[][] matrix, int row, int index){
        for(int i = 0; i < matrix.length; i++){  //by row
            for(int j = 0; j < index; j++){  //by col
                if(matrix[i][j] == 'Q' && (row + j == index + i || row == i || index + row == i + j)) 
                  //3 cases:  left up diagonal || at the same row || right up diagonal
                  return false;
            }
        }
        return true;
    }
    private List<String> build(char[][] matrix){
        List<String> res = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            String s = new String(matrix[i]);
            res.add(s);
        }
        return res;
    }
}

//dfs

class Solution {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 0) return res;
        int[] idx = new int[n];
        for (int i = 0; i < n; i++) {
            idx[i] = '.';
        }
        dfs(n, res, idx, 0);
        return res;
    }

    private static void dfs(int n, List<List<String>> res, int[] idx, int index) {
        if (index == n) {
            res.add(build(idx));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(idx, i, index)) {
                idx[index] = i;
                dfs(n, res, idx, index + 1);
            }
        }
    }

    private static boolean isValid(int[] idx, int position, int index) {
        if (index == 0) return true;
        for (int i = 0; i < index; i++) {
            if (idx[i] == position) return false;
        }
        if (idx[index - 1] - 1 == position || idx[index - 1] + 1 == position) return false;
        for(int i = 0; i < index; i++){
            if(Math.abs(position - idx[i]) == Math.abs(index - i)) return false;
        }
        return true;
    }

    private static List<String> build(int[] idx) {
        List<String> res = new LinkedList<>();
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < idx.length; i++) {
            strB.append('.');
        }
        for (int i = 0; i < idx.length; i++) {
            strB.setCharAt(idx[i], 'Q');
            res.add(strB.toString());
            strB.setCharAt(idx[i], '.');
        }
        return res;
    }

}
