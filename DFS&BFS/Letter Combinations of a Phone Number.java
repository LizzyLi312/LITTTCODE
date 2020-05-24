//bfs
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        res.add("");  //need to put something in the list first to get into the for loop
        for(int i = 0; i < digits.length(); i++){ //go thru every digit
            List<Character> list = get(digits.charAt(i));
            int size = res.size();
            for(int j = 0; j < size; j++){ //go thru every previous result 
                String cur = res.get(0); //que.poll()
                res.remove(0);
                for(char c : list){
                    res.add(cur + c);  //and add a new character to it
                }
            }
        }
        return res;
    }
    private List<Character> get(char c){
        List<Character> res = new ArrayList<>();
        switch(c){
            case'2': res.add('a'); res.add('b'); res.add('c'); break;
            case'3': res.add('d'); res.add('e'); res.add('f'); break;
            case'4': res.add('g'); res.add('h'); res.add('i'); break;
            case'5': res.add('j'); res.add('k'); res.add('l'); break;
            case'6': res.add('m'); res.add('n'); res.add('o'); break;
            case'7': res.add('p'); res.add('q'); res.add('r'); res.add('s'); break;
            case'8': res.add('t'); res.add('u'); res.add('v'); break;
            case'9': res.add('w'); res.add('x'); res.add('y'); res.add('z'); break;
        }
        return res;
    }
}
