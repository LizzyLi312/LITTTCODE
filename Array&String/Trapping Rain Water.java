//idea: find the max height on the left and on the right
//2 pass to find the max on 2 sides and store them in 2 arrays
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        int[] minMax = new int[len];
        int leftCurMax = leftMax[0];
        int rightCurMax = rightMax[len - 1];
        int water = 0;
        for(int i = 1; i < len; i++){ //see the array from left to right
            if(height[i] > leftCurMax){
                leftCurMax = height[i];
            }
            leftMax[i] = leftCurMax;
        }
        for(int j = len - 2; j >= 0; j--){
            if(height[j] > rightCurMax) rightCurMax = height[j];
            rightMax[j] = rightCurMax;
        }
        for(int i = 0; i < len; i++){
            int h = Math.min(leftMax[i], rightMax[i]);
            water += (h - height[i]);
        }
        return water;
    }
}
//time: O(n)  space:O(2n)
//can also use brutal force O(n^2)

//using 2 pointers
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = height[0], rightMax = height[len - 1];
        int water = 0;
        while(left < right){
            if(height[left] >= leftMax) leftMax = height[left];
            if(height[right] >= rightMax) rightMax = height[right];
            water += (leftMax - height[left]) + (rightMax - height[right]);  
            if(leftMax < rightMax) left++;
            else right--;
        }
        return water;
    }
}
