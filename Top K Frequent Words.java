class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0 || k <= 0) return res;
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            // if(!map.containsKey(word)) map.put(word, 1);
            // else map.put(word, map.get(word) + 1);
            map.put(word, map.getOrDefault(word, 0) + 1);  //both work, Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
        }
        Queue<String> heap = new PriorityQueue<>(k, new Comparator<String>(){ //override comparator
            @Override
            public int compare(String w1, String w2){
                if(map.get(w1).equals(map.get(w2))) return w2.compareTo(w1);  //here
                else if(map.get(w1) > map.get(w2)) return 1;
                else return -1;
            } 
        });
        for(String key : map.keySet()){  //Returns a Set view of the keys contained in this map
            if(heap.size() < k) heap.offer(key);
            else{
                if(map.get(key) >= map.get(heap.peek())){
                    heap.offer(key);  //?
                    heap.poll();
                }
            }
        }
        while(!heap.isEmpty()){
            res.add(0, heap.poll());  //add strings to the result list
        }
        return res;
    }
}
