class Solution {
    //chech from start
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len+ 1];
        int max = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) =='(') dp[i] = 0;
            else if(s.charAt(i) == ')'){ 
                if(i == 0) continue; //corner case
                int j = i - (dp[i - 1] + 1); //to find matching ( before the previous pairs of parenthese
                if(j >= 0 && s.charAt(j) =='('){
                    dp[i] = dp[i - 1] + 2;
                    if(j - 1 >= 0) dp[i] += dp[j - 1]; 
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    //check from end 
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len+ 1];
        int max = 0;
        for(int i = len - 1; i >= 0; i--){
            if(s.charAt(i) ==')') dp[i] = 0;
            else if(s.charAt(i) == '('){
                int j = i + dp[i + 1] + 1;
                if(j < len && s.charAt(j) ==')'){
                    dp[i] = dp[i + 1] + 2;
                    if(j + 1 < len) dp[i] += dp[j + 1];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

//stack solution
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int left = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') stack.push(i);
            else{
                if(stack.isEmpty()) left = i;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max = Math.max(max, i - left);
                    else max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
//time: O(n)
