//bottom up. since every node of the bottom works 
//if we start from the top. might be miss some case: [[-1],[2,3],[1,-1,-3]]
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int row = triangle.size(), len = triangle.get(row - 1).size();
        int res[] = new int[len];
        //base case
        for(int i = 0; i < len; i++){
            res[i] = triangle.get(row - 1).get(i);
        }
        //transfer function 
        for(int i = row - 2; i >= 0; i--){
            int n = triangle.get(i).size();
            for(int j = 0; j < n; j++){
                res[j] = triangle.get(i).get(j) + Math.min(res[j], res[j + 1]);
            }
        }
        return res[0];
    }
}
