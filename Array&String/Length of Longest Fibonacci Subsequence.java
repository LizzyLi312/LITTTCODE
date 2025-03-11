// using the definition of fib sequence, so if we can confirm the first 2 elements then the whole arr is set
// we just need to see if the rest of the arr has the elements
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }

        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                            int idx = i + 1;
            int cnt = 2;
            int prev = arr[i];
            int cur = arr[j];
            int sum = prev + cur;

            while (set.contains(prev + cur)) {
                cnt++;
                prev = cur;
                cur = sum;
                sum = prev + cur;
                res = Math.max(res, cnt);
            }
            }
        }
        return res;
    }
}
