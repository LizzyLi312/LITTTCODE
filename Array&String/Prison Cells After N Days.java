//if N == 10000 then there will be cycle. the 1st and last element could never change. so we have 64 status
//so time: O(1)
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells == null || cells.length == 0) return new int[0];
        boolean hasCycle = false;
        int cycle = 0;//count how long is the cycle 
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){
                set.add(key);
                cycle++;
            }
            else{ //once there is cycle break it
                hasCycle = true;
                break;
            }
            cells = next;
        }
        if(hasCycle){
            N %= cycle;
            for(int i = 0; i < N; i++){
                cells = nextDay(cells);
            }
        }
        return cells;
    }
    private int[] nextDay(int[] cells){
        int[] temp= new int[cells.length];
        for(int i= 1; i< cells.length - 1; i++){
            temp[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return temp;
    }
}
