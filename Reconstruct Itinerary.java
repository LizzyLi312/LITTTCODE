// Eulerian cycle: dfs backtrace 
class Solution {
    HashMap<String, PriorityQueue<String>> map; // using HashMap to build graph; using PQ due to the requirement 
    List<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        map = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        
        dfs("JFK");
        Collections.reverse(res); // we need to reverse the order bc we visit the stop reversely 
        return res;
    }

    private void dfs(String stop) {
        while (map.getOrDefault(stop, new PriorityQueue<>()).size() > 0) {
            String t = map.get(stop).poll();
            dfs(t);
        }
        res.add(stop);
    }
}
