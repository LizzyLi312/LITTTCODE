//Find the longest increasing subsequence based on height.
//Since the width is increasing, we only need to consider height.
//[3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) return 0;
        ////sort the array. Ascend on width and descend on height if width are same.
        Arrays.sort(envelopes, new Comparator<int[]>(){ 
            @Override
            public int compare(int[] a1, int[] a2){
                if(a1[0] == a2[0]) return a2[1] - a1[1];
                return a1[0] - a2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] env : envelopes){
            int idx = Arrays.binarySearch(dp, 0, len, env[1]);
            //binarySearch(Object[] a, int fromIndex, int toIndex, Object key)
            //return value is the index of the search key, if it is contained in the array within the specified range; 
            //otherwise, (-(insertion point) - 1).
            if(idx < 0) idx = -(idx + 1);
            dp[idx] = env[1];
            if(idx == len) len++; //len = last index. last index means the biggest element. so if there i
            //if[3,3] comes after [3,4] then the 3 will be replaced. since we dont need to shift 
        }
        return len;
    }
}
