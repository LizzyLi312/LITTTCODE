// solution1: looking for idx i's the first smaller element on left and right side. Elements's value in stack is decreasing
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) { // prev: -1, -1, 1, 2, 1, 4
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (st.isEmpty()) prev[i] = -1; // means the left boundary is -1
            else {
                prev[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) { // next: 1, 6, 4 ,4 ,6 ,6
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) { // need to pop out the element that equal to the current one since we need to include this part. e.g [1, 1] 
                st.pop();
            }
            if (st.isEmpty()) next[i] = n;
            else next[i] = st.peek();
            st.push(i);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int a = (next[i] - prev[i] - 1) * heights[i]; // (prev, next) cannot include the smaller elements since it cannot expand the area using height[i]'s height
            res = Math.max(res, a);
        }

        return res;
    }
}
//time: O(3n)


//solution2: one pass stack keep a increasing order 
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> st = new Stack<>();

        int res = 0, n = heights.length;
        for (int i = 0; i <= n; i++) {
            int x = i == n ? 0 : heights[i]; // need to do post processing 
            while (!st.isEmpty() && heights[st.peek()] >= x) { 
                int idx = st.pop();
                int height = heights[idx];
                int w;
                if (st.isEmpty()) w = i - (-1) - 1;
                else w = i - st.peek() - 1;
                int a = height * w;
                res = Math.max(a, res);
            }
            st.push(i);
        }
        return res;
    }
}
//O(n)
