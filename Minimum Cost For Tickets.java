// track all travel days 
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] cost = new int[n + 1];
        cost[0] = 0;
        HashSet<Integer> travelDays = new HashSet<>(); // we can also use a boolean arr to store this
        for (int day : days) {
            travelDays.add(day);
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (!travelDays.contains(i)) {
                cost[i] = cost[i - 1];
                continue;
            }
            cost[i] = cost[i - 1] + costs[0];
            cost[i] = Math.min(cost[i], cost[Math.max(0, i - 7)] + costs[1]);
            cost[i] = Math.min(cost[i], cost[Math.max(0, i - 30)] + costs[2]);
        }
        return cost[n];
    }
}
