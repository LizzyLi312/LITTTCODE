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

// solution2
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        Stack<Integer> num = new Stack<>();
        Stack<String> str = new Stack<>(); // store the previous string

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) { 
                int idx = i + 1;
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) idx++;
                String t = s.substring(i, idx);
                num.push(Integer.valueOf(t));
                i = idx - 1;
            } else if (Character.isLetter(c)) {
                int idx = i + 1;
                while (idx < s.length() && Character.isLetter(s.charAt(idx))) idx++;
                sb.append(s.substring(i, idx));
                i = idx - 1;
            } else if (c == '[') { // when there is a [ means there is a new nest so we need to store the previous string
                str.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') { // if there is a ] means we finished this nest so we need to duplicate the string that is inside of the [] which is store in sb and also the number before it
                StringBuilder temp = new StringBuilder(str.pop()); // we do not need to check since there is string is always valid 
                int times = num.pop();
                while (times-- > 0) temp.append(sb);
                sb = new StringBuilder(temp);
            }
        }
        return sb.toString();
    }
}
