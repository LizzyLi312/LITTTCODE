/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
//solution2



class Solution {
    class EndPoint implements Comparable<EndPoint>{
        int val;
        boolean isStart;
        public EndPoint(int val, boolean isStart){
            this.val = val;
            this.isStart = isStart;
        }
        @Override
        public int compareTo(EndPoint that){
            if(this.val != that.val) return this.val - that.val;
            else return this.isStart ? 1 : -1;
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        if(schedule == null) return new ArrayList<>();
        List<EndPoint> eps = new ArrayList<>();
        for(List<Interval> list : schedule){
            for(Interval itv : list){
                eps.add(new EndPoint(itv.start, true));
                eps.add(new EndPoint(itv.end, false));
            }
        }
        Collections.sort(eps);
        List<Interval> res = new ArrayList<>();
        int cnt = 0;
        int start = Integer.MIN_VALUE, end = 0;
        for(EndPoint ep : eps){
            if(ep.isStart){
                if(cnt++ == 0){ //means new interval begin 
                    end = ep.val;
                    if(start > Integer.MIN_VALUE && start < end) res.add(new Interval(start, end)); 
                }
            }
            else{
                if(--cnt == 0) start = ep.val; //when the count back to 0 means all interval ends. so should be the start of thr rest 
            }
        }
        return res;
    }
}
