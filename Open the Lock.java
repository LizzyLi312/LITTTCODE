//find the shortest path from "0000" to target -> BFS
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
        for(String str : deadends){
            if(str.equals("0000")) return -1;  //check String == other string use String.equals()
            set.add(str);
        }
        HashSet<String> visited = new HashSet<>();  //need the visited set since cannot switch back and forth
        Queue<char[]> que = new LinkedList<>();
        que.add(new char[] {'0', '0', '0','0'}); 
        visited.add("0000");
        int minLen = 0;
        while(!que.isEmpty()){
            int size = que.size();  
            while(size-- > 0){
                char[] cur = que.poll();
                if(cur.equals(target)) return count;
                List<char[]> nexts = convert(cur, set, visited);
                for(char[] next : nexts){
                    String nextString = String.valueOf(next);
                    if(nextString.equals(target)) return minLen + 1;
                    que.offer(next);
                    visited.add(nextString);
                }
            }
            minLen++;
        }
        return -1;
    }
    private List<char[]> convert(char[] cs, HashSet<String> set, HashSet<String> visited){ //find the next lock
        List<char[]> res = new ArrayList<>();
        for(int i = 0; i < cs.length; i++){
            char tmp = cs[i];  //need to be cached
            // +1 combo
            if(tmp == '9') cs[i] = '0';
            else cs[i] = (char) (tmp + 1);
            String str = String.valueOf(cs);
            if(!set.contains(str) && !visited.contains(str)) res.add(cs.clone()); //need deep copy
            //do not need to set back here since already cache the temp character the original character in the string 
            // -1 combo
            if(tmp == '0') cs[i] = '9';
            else cs[i] = (char) (tmp - 1);
            str = String.valueOf(cs);
            if(!set.contains(str) && !visited.contains(str)) res.add(cs.clone());
            cs[i] = tmp;  //setback
        }
        return res;
    }
}
