class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];

        Stack<Integer> pos = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!pos.isEmpty() && temperatures[pos.peek()] <= temperatures[i]) {
                pos.pop();
            }
            if (pos.isEmpty()) res[i] = 0;
            else {
                int prev = pos.peek();
                res[i] = prev - i;
            }
            pos.push(i);
        }
        return res;
    }
}
