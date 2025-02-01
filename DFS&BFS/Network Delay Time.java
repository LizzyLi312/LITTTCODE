//bfs 
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null || times[0] == null) return 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] time : times){ //using HashMap to be the graph. the key is the starting node
            if(!map.containsKey(time[0])) map.put(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); //make sure it is the shortest node come first 
        pq.add(new int[] {0, K}); //0: distance, K:node index
        boolean[] visited = new boolean[N + 1];
        int res = 0;
        while(!pq.isEmpty()){ 
            int[] cur = pq.remove(); 
            int curNode = cur[1];
            int curDis = cur[0];
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDis;
            N--; //this node got the singal
            if (N == 0) return res;
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[] {curDis + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1; //if N > 0 means there are some nodes didnt get the singal 
    }
}
