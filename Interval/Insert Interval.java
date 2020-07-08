class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        for(int[] itv : intervals){
            if(itv[1] < newInterval[0]) res.add(itv); //not overlap, newInterval is after itv
            else if(newInterval[1] < itv[0]){ //not overlap, newInterval is before itv
                res.add(newInterval);
                newInterval = itv;
            
            else if(itv[1] > newInterval[0] || newInterval[1] > itv[0]){ //in the between 
                newInterval = new int[]{Math.min(itv[0], newInterval[0]), Math.max(itv[1], newInterval[1])};
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}
