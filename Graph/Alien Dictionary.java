//topological sort
class Solution {
    private int curLab = 0;
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        if(words.length == 1) return words[0];
        List<V> vs = new ArrayList<>(); //each character in the string 
        //build graph
        V[] graph = new V[26];
        String prev = words[0];
        for(int i = 1; i < words.length; i++){
            String cur = words[i];
            int idx1 = 0, idx2 = 0;
            boolean valid = false;
            while(idx1 < prev.length() && idx2 < cur.length()){
                char c1 = prev.charAt(idx1++), c2 = cur.charAt(idx2++);
                if(graph[c1 - 'a'] == null){
                    graph[c1 - 'a'] = new V(c1);
                    vs.add(graph[c1 - 'a']);
                }
                if(graph[c2 - 'a'] == null){
                    graph[c2 - 'a'] = new V(c2);
                    vs.add(graph[c2 - 'a']);
                }
                if(c1 != c2){ //since prev is before cur so c1 is c2's neighbor 
                    graph[c1 - 'a'].neighbours.add(graph[c2 - 'a']);
                    valid = true;  //avoid the invalid case: string1: "abc", string2: "ab" 
                    break;
                }
            }
            while(idx1 < prev.length()){ //if there is still some characters in the string 
                if(!valid) return "";
                char c = prev.charAt(idx1++);
                if(graph[c - 'a'] == null){
                    graph[c - 'a'] = new V(c);
                    vs.add(graph[c - 'a']);
                }
            }
            while(idx2 < cur.length()){
                char c = cur.charAt(idx2++);
                if(graph[c - 'a'] == null){
                    graph[c - 'a'] = new V(c);
                    vs.add(graph[c - 'a']);
                }
            } 
            prev = cur;
        }
        char[] res = new char[vs.size()];
        curLab = res.length - 1;
        for(V v : vs){
            if(!dfs(res, v, new HashSet<V>())) return ""; //if there is circle then return ""
        }
        return new String(res);
    }
    private boolean dfs(char[] res, V cur, HashSet<V> cycle){ //using dfs(topological sort) to build path
        //HashSet: deduplicate
        //2 status: visiting, visited
        if(cycle.contains(cur)) return false;
        if(cur.visited) return true;
        cur.visited = true;
        cycle.add(cur);
        for(V nei : cur.neighbours){
            if(!dfs(res, nei, cycle)) return false; //find cycle 
        }
        cycle.remove(cur); //remove cur for new path 
        res[curLab--] = cur.ch;
        return true;
    }
    private class V{
        public char ch;
        public boolean visited;
        public List<V> neighbours;
        public V(char ch){
            this.ch = ch;
            this.visited = false;
            this.neighbours = new ArrayList<>();
        }
    }
}
