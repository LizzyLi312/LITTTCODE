//min jump times. bfs
class Solution {
    private int res = 0;
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        if(nums.length == 1) return 0;
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>(); //visited to avoid visit one position multiple times 
        que.offer(0);
        visited.add(0);
        int level = 0;
        int maxPos = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int curPos = que.poll();
                if(curPos >= nums.length - 1) return level;
                for(int i = 1; i <= nums[curPos]; i++){
                    if(visited.add(curPos + i)){ //new position: update max and offer it into que 
                        que.offer(curPos + i);
                        maxPos = Math.max(maxPos, curPos + i);
                    }
                }
            }
            level++;
        }
        if(maxPos < nums.length - 1) return -1; //check whether 
        return level;
    }
}
//might have time limit excess problem 
/*
i == curEnd means you visited all the items on the current level. Incrementing jumps++ is like incrementing the level you are on. And curEnd = max is like getting the queue size (level size) for the next level you are traversing.
*/
class Solution {
    private int res = 0;
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        if(nums.length == 1) return 0;
        int jumps = 0, curEnd = 0, max = 0;
        for(int i = 0; i < nums.length - 1; i++){
            max = Math.max(max, i + nums[i]);  //update the max position when we traverse i before curEnd
            if (max >= nums.length - 1) {
                jumps++;
                break;
            }
            if(i == curEnd){ 
                jumps++;
                curEnd = max;
            }
        }
        return jumps;
    }
}
