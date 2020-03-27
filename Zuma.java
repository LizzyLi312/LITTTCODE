//dfs idea: 1 ball: remove / not remove
//          2 or more balls next to each other: remove / not remove 
class Solution {
    private int min = Integer.MAX_VALUE;
    public int findMinStep(String board, String hand) {
        HashMap<Character, Integer> pool = new HashMap<>();
        for(char c : hand.toCharArray()){
            if(!pool.containsKey(c)) pool.put(c, 0);
            pool.put(c, pool.get(c) + 1);
        }
        dfs(board, pool, 0);
        if(min == Integer.MAX_VALUE) return -1;
        else return min;
    }
    private void dfs(String board, HashMap<Character, Integer> pool, int cnt){
        if(board.length() == 0){ //sucess base case: if all the balls in the board can be removed.
            min = Math.min(cnt, min);
            return;
        }
        for(int i = 0; i < board.length(); i++){
            char c = board.charAt(i);
            Integer count = pool.get(c);
            if(count == null) continue;
            //there are 2 same balls, add one ball
            if(i < board.length() - 1 && c == board.charAt(i + 1)){
                int newCount = pool.remove(c) - 1;
                if(newCount > 0) pool.put(c, newCount);
                String newBoard = build(board, i - 1, i + 2);
                dfs(newBoard, pool, cnt + 1);
                pool.put(c, count); //backtracing
            }
            //if there is only 1 ball, add 2 balls to remove it 
            else if(count >= 2){
                pool.remove(c);
                if(count > 2) pool.put(c, count - 2);
                String newBoard = build(board, i - 1, i + 1);
                dfs(newBoard, pool, cnt + 2);
                pool.put(c, count);
            }
        }
    }
    private String build(String board, int left, int right){
        int len = board.length();
        while(left >= 0 && right < len){
            char c = board.charAt(left); //to see after remove balls([i, i + 1]) the rest can remove by themselves or not
            int count = 0;
            int l = left;
            //left records the first different element from c
            while(l >= 0 && board.charAt(l) == c){ //find the left boundary.
                l--;
                count++;
            }
            
            //right records the first different element from c
            int r = right;
            while(r < len && board.charAt(r) == c){  //fine the right boundary 
                r++;
                count++;
            }
            //if there are more same balls
            if(count >= 3){
                left = l; 
                right = r;
            }
            else break;
        }
        //remove the same elements build new board
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= left; i++){
            sb.append(board.charAt(i));
        }
        for(int i = right; i < len; i++){
            sb.append(board.charAt(i));
        }
        return sb.toString(); 
    }
}
//time: O(2^n) n balls 2 option: remove or not 
