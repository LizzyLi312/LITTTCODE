class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0) return new ArrayList<>();

        HashMap<String, List<Integer>> map = new HashMap<>(); // duplicate strings 

        for (int i = 0; i < strings.length; i++) {
            List<Integer> idxs = map.getOrDefault(strings[i], new ArrayList<>());
            idxs.add(i);
            map.put(strings[i], idxs);
        }
        
        boolean[] visited = new boolean[strings.length];

        List<List<String>> res = new ArrayList<>();
        
        for (int i = 0; i < strings.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            List<String> group = new ArrayList<>();
            group.add(strings[i]);
            for (int j = 0; j <= 25; j++) {
                char[] t = strings[i].toCharArray();
                for (int k = 0; k < t.length; k++) {
                    t[k] = ((char)(t[k] + j)) > 'z' ? (char)(t[k] + j - 26) : (char)(t[k] + j);
                }
                if (map.containsKey(new String(t))) {
                    List<Integer> idxs = map.get(new String(t));
                    for (int idx : idxs) {
                        if (idx == i) continue;
                        visited[idx] = true;
                        group.add(new String(t));
                    }
                }
            }
            res.add(group);
        }
        return res;
    }
}
