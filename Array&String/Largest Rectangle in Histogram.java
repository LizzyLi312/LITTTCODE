//using stack to use the left boundry and the right boundry 
//if stack is not empty then stack.peek() is the gratest element in the stack. if the incoming element is larger than the peek element. we keep pushing it into the stack
//when the new element 
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = i < heights.length ? heights[i] : 0; 
            //make the heights[i] == 0 so we do not have to post process. since all the elements are going to be poped out of the stack
            if(stack.isEmpty() || h >= heights[stack.peek()]){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && h < heights[stack.peek()]){
                    int popIdx = stack.pop();
                    int area = 0;
                    if(stack.isEmpty()) area = heights[popIdx] * i; //if stack is empty means there is nothing small than the current one. so we can calculate the area with heights[i] with it 
                    else area = heights[popIdx] * (i - stack.peek() - 1);
                    //stack.peek() = the first smaller element than heights[popIdx]
                    max = Math.max(max, area);
                }
                stack.push(i);
            }
        }
        return max;
        //in the end there will be an element in the stack
    }
}
//time: O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                if(heights[j] >= heights[i]) right[i] = j;
                else break;
            }
        }
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                if(heights[j] >= heights[i]) left[i] = j;
                else break;
            }
        }
        int res = 0;
        for(int i = 0; i < len; i++){
            int temp = heights[i] * (right[i] - left[i] + 1);
            res = Math.max(temp, res);
        }
        return res;
    }
}
//O(n^2)  space:O(2n)
