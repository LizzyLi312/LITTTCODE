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
//solution2 O(nlogn)
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // 1, 1, 2*, 3*, 4, 5, 6*, 10*
        //1, 2, 2, 3*, 4*, 5*, 6, 7*, 9, 12*
        List<int[]> diff = new ArrayList<>();
        for (List<Interval> s : schedule) {
            for (Interval i : s) {
                diff.add(new int[]{i.start, 1});
                diff.add(new int[]{i.end, -1});
            }
        }
        Collections.sort(diff, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1])); // need to calculate start first since the other employee will be occupied 

        int sum = 0, start = -1;
        List<Interval> res = new ArrayList<>();
        for (int[] d : diff) {
            sum += d[1];
            if (sum == 0) start = d[0];
            if (start != -1 && sum == 1) {
                res.add(new Interval(start, d[0]));
                start = -1;
            }
        }
        return res;
    }
}
