//Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() <= 2) return s;
        HashMap<Character, Integer> map = new HashMap<>(); //use HashMap to record the frquency 
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){ //use priorityQ to keep the order
            @Override 
            public int compare(Character c1, Character c2){
                if(map.get(c1) == map.get(c2)) return c1 - c2;
                else return map.get(c2) - map.get(c1); //if return a positive number then c1 will be put after c2
            }
        });
        for(Character c : map.keySet()){
            pq.offer(c);
        }
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Character c = pq.poll();
            int count = map.get(c);
            while(count-- >0){
                res.append(c);
            }
        }
        return res.toString();
    }
}
