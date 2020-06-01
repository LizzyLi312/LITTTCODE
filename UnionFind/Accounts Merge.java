class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if(accounts == null) return res;
        int len = accounts.size();
        UnionFind uf = new UnionFind(accounts.size());
        HashMap<String, Integer> emailToUser = new HashMap<>();
        for(int i = 0; i < len; i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){ 
                String email = account.get(j);
                Integer user = emailToUser.get(email);
                if(user == null) emailToUser.put(email, i);
                else uf.union(i, user); //union all the users if they have same email address
            }
        }
        HashMap<Integer, HashSet<String>> userToEmail = new HashMap<>();
        for(int i = 0; i < len; i++){
            int root = uf.getRoot(i); //the index of people 
            if(!userToEmail.containsKey(root)){
                userToEmail.put(root, new HashSet<>());
            }
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                userToEmail.get(root).add(email);
            }
        }
        for(Integer e : userToEmail.keySet()){
            List<String> list = new LinkedList<>();
            list.addAll(userToEmail.get(e)); //add emails
            Collections.sort(list); 
            list.add(0, accounts.get(e).get(0)); //add user's name
            res.add(list);
        }
        return res;
        
    }
    private class UnionFind{
        private int[] parent;
        private int[] size;
        public UnionFind(int capacity){
            this.parent = new int[capacity];
            this.size = new int[capacity];
            for(int i = 0; i < capacity; i++){
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }
        private void union(int user1, int user2){
            int root1 = getRoot(user1);
            int root2 = getRoot(user2);
                if(size[root1] < size[root2]){
                    parent[root1] = root2;
                    size[root2] += size[root1];
                }
                else{
                    parent[root2] = root1;
                    size[root1] += size[root2];
                }
        }
        private boolean find(int user1, int user2){
            return getRoot(user1) == getRoot(user2);
        }
        private int getRoot(int user){
            int cur = user;
            while(parent[cur] != cur){
                parent[cur] = parent[parent[cur]];
                cur = parent[cur];
            }
            parent[user] = cur;
            return cur;
        }
    }
}
