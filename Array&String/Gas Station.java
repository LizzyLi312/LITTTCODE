class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        for(int i = 0; i < gas.length; i++){
            if(canCompleteCircuit(gas, cost, i)) return i;
        }
        return -1;
    }
    private boolean canCompleteCircuit(int[] gas, int[] cost, int start){
        int g = 0;
        int curPos = start;
        for(int i = 0; i < gas.length; i++){
            if(g < 0) return false;
            g += gas[curPos % gas.length];
            g -= cost[curPos % gas.length];
            curPos++;
        }
        if(g < 0) return false;
        else return true;
    }
}
//time: O(n^2)

//deal with it as a circle. if when they meet in the middle with count >= 0 then they can make it 
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0) return -1;
        int len = gas.length, count = 0, start = len, end = 0; //[start, end): initial empty
        while(end < start){ //start from len and end with 0 to make sure it can make it back to where it starts
            if(count >= 0){ 
                count += gas[end] - cost[end];
                end++;
            }
            else{ 
                start--;
                count += gas[start] - cost[start];
            }
        }
        if(count < 0) return -1;
        else return start == len ? 0 : start; //if start doesnt move at all means the count always larger than 0
    }
}
//one pass. O(n)
