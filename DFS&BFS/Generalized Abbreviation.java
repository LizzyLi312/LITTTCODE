//need to clarify: whether there is number in the original string
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        // if(word == null || word.length() == 0) return res;
        dfs(word, res, 0, 0, new StringBuilder());
        return res;
    }
    private void dfs(String word, List<String> res, int idx, int count, StringBuilder sol){
        if(idx == word.length()){
            if(count > 0){
                int lenP = sol.length();
                sol.append(count);
                res.add(sol.toString());
                sol.setLength(lenP);
            }
            else res.add(sol.toString());
            return;
        }
        //add integer 
        dfs(word, res, idx + 1, count + 1, sol);
        int lenP = sol.length();
        //add character
        if(count > 0){
            sol.append(count); //after put the number into the result string then start a new count
            count = 0;
        }
        sol.append(word.charAt(idx));
        dfs(word, res, idx + 1, count, sol);
        sol.setLength(lenP);
    }
}
//time: O(2^n) : since every position has 2 options: turn it into number or leave it as character
