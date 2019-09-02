/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid))
                right = mid;
            else left = mid;
        }
        return isBadVersion(left) ? left : right;  //the tricky part! you should check the left first! cause it could be the first bad version other than the right one.
    }
}
//i used Binary Search for this question. and ofc you could use the brutal force approach to solve it. Yet it said use the API as less as you can. So i thoguht how i could optimize the time complixity. And i came up with Binary Search which make this question only has O(logn) time compelixity and O(1) for space(since there're only 3 variables be used).
//FIND THE BRODER
