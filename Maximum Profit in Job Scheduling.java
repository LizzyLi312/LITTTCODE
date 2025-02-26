// using treemap 
// why sorting?  incrementally consider all the possible end times.
 
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[] dp = new int[startTime.length + 1]; // max profit from [0, i)
        int[][] jobs = new int[startTime.length][3];

        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));

        TreeMap<Integer, Integer> tm = new TreeMap<>(); //endTime, profit

        dp[0] = 0;
        tm.put(0, dp[0]);

        for (int i = 0; i < startTime.length; i++) {
            int cur = tm.floorEntry(jobs[i][0]).getValue() + jobs[i][2];
            if (cur > tm.lastEntry().getValue()) {
                tm.put(jobs[i][1], cur);
            }
        }
        return tm.lastEntry().getValue();
    }
    /*
    	lastEntry()
        Returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.
    */
}

// binary search 
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[] dp = new int[startTime.length + 1];
        int[][] jobs = new int[startTime.length][3];

        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));

        dp[0] = 0;

        for (int i = 0; i < startTime.length; i++) {
            int idx = bs(jobs, jobs[i][0], i); // look for job that ends before this i-th start time
            int cur = dp[idx] + jobs[i][2];
            
            dp[i + 1] = Math.max(dp[i], cur);
        }
        return dp[startTime.length];
    }

    private int bs(int[][] jobs, int startTime, int idx) {
        int l = 0, r = idx;
        while (l < r) {
            int mid = l + (r - l ) / 2;
            if (startTime >= jobs[mid][1]) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
