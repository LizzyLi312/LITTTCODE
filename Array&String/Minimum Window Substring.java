//clarify: is there duplicate in t?
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mapT = new HashMap<Character, Integer>(); //dictionary of t
        HashMap<Character, Integer> cur = new HashMap<Character, Integer>();   //the count of the same character as t in s 
        for(int i = 0; i < t.length(); i++){ 
            char c = t.charAt(i);
            if(!mapT.containsKey(c)){ //put characters into t's map
                mapT.put(c, 1);
                cur.put(c, 0); //create key for s' map
            }
            else{ //if there are multiples only update t's map
                int num = mapT.get(c); 
                mapT.put(c, num + 1);
            }
        }
        int min = s.length() + 1, low = -1, high = -1; //result
        int head = 0, tail = 0; //silding window
        int count = 0; 
        while(tail < s.length()){
            char c = s.charAt(tail);
            if(mapT.containsKey(c)){ //if the character in s is character in t
                int tt = mapT.get(c);
                int curr = cur.get(c);
                if(curr < tt) count++; //if the amout of c in T is smaller or equal to s then it doesnt count. since it already offseted all the c in t
                cur.put(c, curr + 1); //but we also need to update the amout of c in map s
                if(count == t.length()){ //that means we complete finding all the characters of t in s
                    while(head < tail && (!mapT.containsKey(s.charAt(head)) || cur.get(s.charAt(head)) > mapT.get(s.charAt(head)))){
                    //move head when the head character if not in t or the same character as the one in t is too much 
                        if(mapT.containsKey(s.charAt(head))){
                            curr = cur.get(s.charAt(head));
                            cur.put(s.charAt(head), curr - 1);
                        }
                        head++;
                    }
                    if(min > tail - head){  //update the result
                        min = tail - head;
                        low = head;
                        high = tail;
                    }
                }
            }
            tail++;
        }
        return low == -1 ? "" : s.substring(low, high + 1); //if low = -1 mean we never updated it.
    }
}
