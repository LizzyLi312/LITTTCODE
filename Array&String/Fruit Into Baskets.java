// longest substring that contains K distinct elements
class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits == null || fruits.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0, r = 0;
        int res = 0, type = 0;
        while (r < fruits.length) { 
            int cnt = map.getOrDefault(fruits[r], 0);
            if (cnt == 0) type++;
            map.put(fruits[r++], cnt + 1);
            while (type > 2) {
                int t = map.get(fruits[l]) - 1;
                map.put(fruits[l++], t);
                if (t == 0) type--;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}
