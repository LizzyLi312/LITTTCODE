class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return false;
        if(stones[1] - stones[0] != 1) return false;
        HashMap<Integer, Boolean>[] memo = new HashMap[stones.length];  //a HashMap array to store each stones step 
        for(int i = 0; i < stones.length; i++){
            memo[i] = new HashMap<Integer, Boolean>();
        }
        return dfs(stones, 1, 1, memo);
    }
    private boolean dfs(int[] stones, int idx, int step, HashMap<Integer, Boolean>[] memo){
        if(idx == stones.length - 1) return true;
        HashMap<Integer, Boolean> mem = memo[idx];
        if(mem.containsKey(step)) return mem.get(step);
        for(int i = idx + 1; i < stones.length; i++){
            int dis = stones[i] - stones[idx];
            if(dis < step - 1) continue;
            if(dis > step + 1) break;
            if(dis == step - 1 || dis == step || dis == step + 1){
                if(dfs(stones, i, dis, memo)){
                    mem.put(dis, true);
                    return mem.get(dis);
                }
            }
        }
        mem.put(step, false);
        return mem.get(step);
    }
}
