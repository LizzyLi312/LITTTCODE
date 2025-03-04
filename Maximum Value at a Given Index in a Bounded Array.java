// binary search to find the maximum num, left side array should be decreasing by1 right side should be decreasing by -1 as well 
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;

        int l = 0, r = maxSum;
        while (l < r) { 
            int mid = l + (r - l + 1) / 2;
            if (check(n, index, mid) <= maxSum) l = mid;
            else r = mid - 1;
        }

        return l + 1;
    }

    private long check(int n, int idx, int mid) { // mid = 5, idx = 2 [3,4,5,4,3,2], n = 6
        // left sum
        int b = Math.max(0, mid - idx);
        long res = (long)(mid + b) * (mid - b + 1) / 2;
        // right sum
        b = Math.max(0, mid - ((n - 1) - idx));
        res += (long)(mid + b) * (mid - b + 1) / 2;
        return res - mid;
    }
}
