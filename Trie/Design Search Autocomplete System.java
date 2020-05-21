/*
Goals: return the top3 words when users are typing
when the user types # then store word and return []
if there is no words match the input character then return []

data structure: Trie, prefix search 
*/
class AutocompleteSystem {
    private TrieNode root;
    private TrieNode curNode;
    private StringBuilder path;
    private HashMap<String, Integer> countBook;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        if(sentences == null || times == null || sentences.length != times.length) throw new IllegalArgumentException();
        root = new TrieNode('\0');  //a null character: \0
        curNode = root;
        path = new StringBuilder();
        countBook = new HashMap<>(); 
        int len = sentences.length;
        for(int i = 0; i < len; i++){
            countBook.put(sentences[i], times[i]);
            insert(sentences[i], times[i]);
        }
    }
    class TrieNode{
        public char ch;
        public TrieNode[] nexts;
        public HashMap<String, Integer> countMap; //each node has its own HashMap
        public boolean isLeaf;
        public TrieNode(char ch){
            this.ch = ch;
            nexts = new TrieNode[27]; //27 since 26 characters + #
            this.isLeaf = false;
            countMap = new HashMap<>(3); //since we only needs top 3
        }
    }
    class Pair{
        public String str;
        public int count;
        public Pair(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    
    public List<String> input(char c) {
        if(c == '#'){
            curNode = root; //means end so go back to the root for next input word
            String insertMe = path.toString();
            Integer count = countBook.get(insertMe);
            if(count == null) countBook.put(insertMe, 1);
            else countBook.put(insertMe, count + 1);
            insert(insertMe, countBook.get(insertMe)); //update every character in the word
            path = new StringBuilder();
            return new ArrayList<>();
        }
        path.append(c);
        if(curNode == null) return new ArrayList<>();
        int idx = (c >= 'a' && c <= 'z') ? (c - 'a') : 26;
        curNode = curNode.nexts[idx]; //means there's no previous word like this 
        if(curNode == null) return new ArrayList<>();
        else return getTop3String(curNode.countMap);
    }
    private void insert(String sentence, int times){ //update word frequency of each character 
        TrieNode cur = root;
        for(char ch : sentence.toCharArray()){
            int idx = (ch >= 'a' && ch <= 'z') ? (ch - 'a') : 26;
            if(cur.nexts[idx] == null) cur.nexts[idx] = new TrieNode(ch); //if this is a new word then create a new TrieNode
            TrieNode next = cur.nexts[idx];
            next.countMap.put(sentence, times);
            List<Pair> top3 = getTop3Pair(next.countMap);
            next.countMap.clear(); //update the countMap each time
            for(Pair p : top3){ 
                next.countMap.put(p.str, p.count);
            }
            cur = next;
        }
        cur.isLeaf = true; //the last character
    }
    private List<String> getTop3String(HashMap<String, Integer> countMap){
        return getTop3Pair(countMap).stream().map(p -> p.str).collect(Collectors.toList());
        //stream() A sequence of elements supporting sequential and parallel aggregate operations
        //Stream map() function with operation of mapping the string in the Pair p in place of p
        //collect(): Accumulate strings into the List 
        //The toList() method of Collectors Class is a static (class) method. It returns a Collector Interface that gathers the input data onto a new list. 
    }
    private List<Pair> getTop3Pair(HashMap<String, Integer> countMap){ 
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b){
                return a.count == b.count ? a.str.compareTo(b.str) : b.count - a.count;
            }
        });
        for(String e : countMap.keySet()){
            maxHeap.offer(new Pair(e, countMap.get(e)));
        }
        List<Pair> res = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(maxHeap.isEmpty()) break;
            res.add(maxHeap.poll());
        }
        return res;
    }
}
