//choose the number or not 
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger <= 0 || maxChoosableInteger > 20 || desiredTotal < 0) return false;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2; 
        if(sum < desiredTotal) return false;  //if the sum of all numbers is less than sum then it is not gonna happen
        int map = (1 << maxChoosableInteger) - 1;
        return dfs(map, maxChoosableInteger, desiredTotal, 0);  //player1 call
    }
    private boolean dfs(int map, int max, int target, int sum){
        //no base case; since you cannot check the sum here. the sum here is the sum after player2 picked a number 
        for(int i = 1; i <= max; i++){
            int mask = 1 << (i - 1);  //to check the number is avialible
            if((mask & map) != 0){ 
                if(sum + i >= target) return true;
                int newMap = map - mask;
                if(!dfs(newMap, max, target, sum + i)) return true;  //player 2
            }
        }
        return false;
    }
}
