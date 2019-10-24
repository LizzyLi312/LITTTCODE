class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        if(nums == null || nums.length == 0 || k<= 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){
                if(map.get(n1) == map.get(n2)) return 0;
                return map.get(n1) > map.get(n2) ? 1 : -1;
            }
        });
        for(int key : map.keySet()){
            if(heap.size() < k) heap.offer(key);
            else{
                if(map.get(key) > map.get(heap.peek())){
                    heap.offer(key);
                    heap.poll();
                }
            }
        }
        while(!heap.isEmpty()){
            res.add(0, heap.poll());
        }
        return res;
    }
}
