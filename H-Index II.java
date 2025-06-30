class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int n = citations.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] == n - mid) return n - mid; // at least H papaer got cited by at least H times
            if (citations[mid] < n - mid) l = mid + 1; // more than citations[mid] papers got cited by citatinos[mid] time
            else r = mid;
        }
        return n - r; // return the limit of paper 
    }
}
