class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return new int[0][0];
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] interval1, int[] interval2){
                return interval1[0]-interval2[0]; //comparator return value: -1, interval1 will be place first. 1 interval 2 will be place first
            }
        });
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for(int[] itv : intervals){
            if(itv[0] <= prev[1]){ //overlap
                prev = new int[]{prev[0], Math.max(prev[1], itv[1])};
            }
            else{
                res.add(prev);
                prev = itv; //prev will stop at the last interval 
            }
        }
        res.add(prev); //need post processing 
        return res.toArray(new int[res.size()][]);
    }
}
