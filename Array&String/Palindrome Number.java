//idea: reverse the whole number and compare it
//integer only has one entrance to traversal it 
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int res = 0;
        int y = x; //need to cache the input 
        while(y != 0){
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x == res;
    }
}
