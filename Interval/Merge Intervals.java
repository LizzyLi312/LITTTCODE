class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (newInterval[1] < interval[0]) { // the new interval and current interval in the list is not overrlap and the newInterval is smaller 
                res.add(newInterval);
                newInterval = interval;
            }
            if (newInterval[0] <= interval[1]) { // if the boundary is the same then merge 
                int st = Math.min(newInterval[0], interval[0]);
                int ed = Math.max(newInterval[1], interval[1]);
                newInterval = new int[]{st, ed};
            } else { // the current interval is smaller 
                res.add(interval);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
