//similar with calculator
class Solution {
    public String decodeString(String s) {
        String res = "";
        if(s == null || s.length() == 0) return s;
        Stack<String> resStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int idx = 0;
        while(idx < s.length()){
            if(s.charAt(idx) >= '0' && s.charAt(idx) <='9'){
                int count = 0;
                while(s.charAt(idx) >= '0' && s.charAt(idx) <='9'){
                    count = count * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                countStack.push(count);
            }
            else if(s.charAt(idx) == '['){
                resStack.push(res);
                res = "";
                idx++;
            }
            else if(s.charAt(idx) == ']'){
                StringBuilder temp = new StringBuilder(resStack.pop()); //incase there is some letters before it
                int times = countStack.pop();
                while(times-- > 0){
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else{
                res += s.charAt(idx++);
            }
        }
        return res;
    }
}
