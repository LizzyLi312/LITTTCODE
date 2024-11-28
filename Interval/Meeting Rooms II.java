class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> diff = new ArrayList<>();

        for (int[] interval : intervals) {
            int a = interval[0], b = interval[1];
            diff.add(new int[]{a, 1});
            diff.add(new int[]{b, -1});
        }

        Collections.sort(diff, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1])); // if end and start have the same value take end first

        int res = 0;
        int sum = 0;
        for (int[] x : diff) {
            sum += x[1];
            res = Math.max(res, sum);
        }

        return res;
    }
}
