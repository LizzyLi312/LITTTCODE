 class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return 0;
        int max = 0;
        List<EndPoint> list = new ArrayList<>();
        for(int[] itv : intervals){
            list.add(new EndPoint(itv[0], false));
            list.add(new EndPoint(itv[1], true));
        }
        Collections.sort(list);
        int count = 0;
        for(EndPoint ep : list){
            if(!ep.isEnd) count++;
            else count--;
            max = Math.max(count, max);
        }
        return max;
    }
    class EndPoint implements Comparable<EndPoint>{
        boolean isEnd;
        int val;
        public EndPoint(int val, boolean isEnd){
            this.val = val;
            this.isEnd = isEnd;
        }
        @Override
        public int compareTo(EndPoint ep){
            if(this.val < ep.val) return -1; //this will be put in the front 
            else if(this.val > ep.val) return 1;
            else{ //this.val == ep.val
                if(this.isEnd) return -1;
                else return 1;
            }
        }
    }
}
