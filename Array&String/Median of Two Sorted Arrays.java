class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if(len % 2 == 0) return (helper(nums1, nums2, 0, 0, len / 2) + helper(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;
        else return helper(nums1, nums2, 0, 0, len / 2 + 1);
    }
    private int helper(int[] nums1, int[] nums2, int start1, int start2, int k){
        if(start1 >= nums1.length) return nums2[start2 + k - 1];
        if(start2 >= nums2.length) return nums1[start1 + k - 1];
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);
        
        int val1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int val2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        // compare val1 and val2 discard the smaller part since none of them could be the kth smallest
        if(val1 < val2) return helper(nums1, nums2, start1 + k / 2 - 1 + 1, start2, k - k / 2); // +1 since this will be a new start
        else return helper(nums1, nums2, start1, start2 + k / 2 - 1 + 1, k - k /2);
    }
}
