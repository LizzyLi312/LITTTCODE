class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        int count = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        while(count < numRows){
            List<Integer> e = new ArrayList<>();
            int size = count + 1;
            for(int i = 0; i < size; i++){
                if(i == 0) e.add(res.get(count - 1).get(0));
                else if(i == size - 1) e.add(res.get(count - 1).get(count - 1));
                else e.add(res.get(count - 1).get(i - 1) + res.get(count - 1).get(i));
            }
            res.add(e);
            count++;
        }
        return res;
    }
}
