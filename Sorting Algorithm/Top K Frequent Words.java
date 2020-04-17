class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if(words == null || k <= 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(map.get(s1) == map.get(s2)) return s2.compareTo(s1);
                return map.get(s1) - map.get(s2);
            }
        });
        for(String key : map.keySet()){
            pq.offer(key);
            if(pq.size() > k) pq.poll(); //if there is k then take the smallest out 
        }
        while(k-- > 0){
            res.add(0, pq.poll());
        }
        return res;
    }
}
