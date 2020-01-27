class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) return -1;  //corner case
        HashSet<String> wordSet = new HashSet<>();  //de duplicate using hashset
        for(String word : wordList) wordSet.add(word);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int minDis = 1;  //record the distance 
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String cur = queue.poll();
                char cc[] = cur.toCharArray();
                for(int i = 0; i < cc.length; i++){
                    char temp = cc[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        cc[i] = c; 
                        String str = String.valueOf(cc);
                        if(c != temp && wordSet.contains(str)){
                            if(str.equals(endWord)) return minDis + 1;  //when meet the end word for the first time, return the distance immediately
                            queue.offer(str);
                            wordSet.remove(str);
                        }                           
                    }
                    cc[i] = temp;  //set the word back to normal 
                }
            }
            minDis++;
        }
        return 0;
    }
}

//using bfs
