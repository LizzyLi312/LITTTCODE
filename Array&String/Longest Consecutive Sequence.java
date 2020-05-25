class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        for(int n : nums){ //O(n)
            if(set.contains(n)){ //O(1)
                int count = 1;
                set.remove(n);
                int l = n - 1;
                while(set.contains(l)){ //O(1)
                    count++;
                    set.remove(l);
                    l--;
                }
                int r = n + 1;
                while(set.contains(r)){
                    count++;
                    set.remove(r);
                    r++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
//time: O(n)

//sorting and then find the lognest. 2 variable: curLength, maxLength. need to do post processing 
//time: O(nlogn)
