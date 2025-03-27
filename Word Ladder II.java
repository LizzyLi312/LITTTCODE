// bfs + dfs 
class Solution {
    List<List<String>> res;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        Queue<String> que = new LinkedList<>();
        HashSet<String> dict = new HashSet<>(wordList);
        que.offer(beginWord);

        boolean flag = false;
        HashMap<String, List<String>> map = new HashMap<>();

        while (!que.isEmpty()) { // bfs to find the shortest route
            int size = que.size();
            HashSet<String> set = new HashSet<>();
            while (size-- > 0) {
                String t = que.poll();
                if (t.equals(endWord)) {
                    flag = true;
                    continue;
                }
                List<String> nexts = convert(t, dict);
                for (String next : nexts) {
                    if (set.add(next)) {
                        map.putIfAbsent(next, new ArrayList<>());
                        que.offer(next);
                    }
                    map.get(next).add(t);
                }
            }
            dict.removeAll(set);
            if (flag) {
                List<String> path = new LinkedList<>();
                path.add(endWord);
                dfs(map, path, endWord, beginWord);
                break;
            }
        }
        return res;
    }

    private void dfs(HashMap<String, List<String>> map, List<String> path, String begin, String end) { // dfs to retrive the path
        if (begin.equals(end)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (String next : map.get(begin)) {
            path.add(0, next);
            dfs(map, path, next, end);
            path.remove(0);
        }
    }

    private List<String> convert(String t, HashSet<String> set) {
        List<String> res = new ArrayList<>();
        char[] tt = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            char x = tt[i];
            for (char c = 'a'; c <= 'z'; c++) {
                tt[i] = c;
                if (set.contains(String.valueOf(tt))) {
                    res.add(String.valueOf(tt));
                }
            }
            tt[i] = x;
        }
        return res;
    }
}
