class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for (int num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) >= 2) res++;
            } else {
                if (map.containsKey(num + k)) res++; // this will avoid the duplicates 
            }
        }
        return res;
    }
}
