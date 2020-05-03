//find the center and expand it to left and right 
//with global virable
/*
This can cause of Out of Memory issue. Data can be modified by any function. Any statement written in the program can change the value of the global variable. This may give unpredictable results in multi-tasking environments.
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int[] max = new int[1];
        int[] res = new int[2];
        for(int i = 0; i < s.length() - 1; i++){ 
            findMax(s, i, i, max, res); //odd length
            findMax(s, i, i + 1, max, res); //even length, need to look at the range
        }
        return s.substring(res[0], res[1]);
    }
    private void findMax(String s, int left, int right, int[] max, int[] res){
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--; 
                right++;
            }
            else break;
        }
        int dist = right - left - 1;
        if(dist > max[0]){
            max[0] = dist;
            res[0] = left + 1;
            res[1] = right;
        }
    }
}
//time: O(n^2)

//without global vriable
class Solution {
    public String longestPalindrome(String s) {
        int max = 0, idx = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = extend(s, i, i), len2 = extend(s, i, i + 1); 
            if(max < Math.max(len1, len2)){
                idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1); //i is the center. len1/2 is the length
                max = Math.max(len1, len2);
            }
        }
        return s.substring(idx, idx + max);
    }
    private int extend(String s, int left, int right){
        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right)) break;
            left--;
            right++;
        }
        return right - left - 2 + 1; //subtract 2 unmatched character 
    }
}
