//divide and conquer
//see the operator as the tree root. and number as the value of the root. 
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0) return res;
        boolean singleNum = true; //flag the input is a single number  
        for(int i = 0; i < input.length(); i++){ //decide which operator is the root by splitting 2 parts 
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                singleNum = false;
                List<Integer> left = diffWaysToCompute(input.substring(0, i)); //every part return how many different way it can add parenthese. so could be multiple ways 
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                List<Integer> one = helper(left, right, c);
                res.addAll(one);
            }
        }
        if(singleNum) res.add(Integer.valueOf(input));
        return res;
    }
    private List<Integer> helper(List<Integer> left, List<Integer> right, char opt){
        List<Integer> res = new ArrayList<Integer>();
        for(int l : left){ //generalize how many combination left and right can have 
            for(int r : right){
                int temp = 0;
                if(opt == '+') temp = l + r;
                if(opt == '-') temp = l - r;
                if(opt == '*') temp = l * r;
                res.add(temp);
            }
        }
        return res;
    }
}
