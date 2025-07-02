class Solution {
    int[] sum; 
    public Solution(int[] w) {
        sum = new int[w.length + 1];
        for (int i = 1; i < w.length + 1; i++) {
            sum[i] = sum[i - 1] + w[i - 1]; // sum from [0, i]
            // sum = [0, 4, 6]
        }
    }
    
    public int pickIndex() {
        Random random = new Random();
        int idx = random.nextInt(sum[sum.length - 1]) + 1; 
        int l = 1, r = sum.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (sum[mid] == idx) return mid - 1; // need to return mid - 1 since sum arr is 1-idxed 
            if (sum[mid] > idx) r = mid; // if idx is smaller than sum[mid] means it might be out of range 
            else l = mid + 1;
        }
        return l - 1; // need to return mid - 1 since sum arr is 1-idxed 
    }

    
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
