class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int len = ratings.length;
        int[] temp = new int[len];
        for(int i = 0; i < len; i++){ //make sure everyone at least has one candy 
            temp[i] = 1;
        }
        for(int i = 0; i < len - 1; i++){ //if the neighbor has more score then neighbor can have one more candy than current person 
            if(ratings[i + 1] > ratings[i]) temp[i + 1] = temp[i] + 1;
        }
        for(int i = len - 1; i > 0; i--){  //double check since each person has 2 neighbors. 2 directions
            if(ratings[i - 1] > ratings[i]){
                if(temp[i - 1] < temp[i] + 1) temp[i - 1] = temp[i] + 1;
            }
        }
        int res = 0;
        for(int i : temp){
            res += i;
        }
        return res;
    }
}
