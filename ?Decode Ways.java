class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        return dfs(s, 0);
    }
    private int dfs(String s, int idx){
        if(idx == s.length()) return 1; //base case 
        int res = 0; //every layer's sum should be 0 + the return value from next layer. So res should be 0
        for(int l = 1; l <= 2; l++){ //similar to Recover IP address
            if(idx + l > s.length()) break;
            String str = s.substring(idx, idx + l);
            int val = Integer.valueOf(str);
            if(1 <= val && val <= 26) res += dfs(s, idx + l);
            if(val == 0) return 0; 
        }
        return res;
    }
}
time: O(n^2)

//using pruning. otherwise it would be Time Limit Exceeded error
 public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int m1 = 1, m2 = 0; 
        if(s.charAt(0) > '0' && s.charAt(0) <= '9') m2 = 1;
        for(int i = 1; i < s.length(); i++){
            int sum = 0; //works like the res in dfs
            char c = s.charAt(i);
            if(c > '0' && c <='9') sum += m2;//m2: the result so far from [0, i] 
            char prev = s.charAt(i - 1);
            int val = (prev -'0') * 10 + (c - '0');
            if(val >= 10 && val <=26) sum+= m1; //m1: the result so far from [0, i - 1]
            m1 = m2;
            m2 = sum;
        }
        return m2;
 }
 //time: O(n);
