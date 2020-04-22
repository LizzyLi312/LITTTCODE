//using stack 
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> num = new Stack<>();
        Stack<Character> oper = new Stack<>();
        int idx = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == ' '){
                idx++;
                continue;
            }
            if(Character.isDigit(s.charAt(idx))){
                int count = 0;
                while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                    count = count * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                num.push(count);
            }
            else if(s.charAt(idx) == '+' || s.charAt(idx) == '-' || s.charAt(idx) == '/' || s.charAt(idx) == '*'){
                while(!oper.isEmpty() && hasPriority(s.charAt(idx), oper.peek())){
                    num.push(cal(oper.pop(), num.pop(), num.pop()));
                }
                oper.push(s.charAt(idx++));
            }
        }
        while(!oper.isEmpty()){
            num.push(cal(oper.pop(), num.pop(), num.pop()));
        }
        return num.pop();
    }
    private boolean hasPriority(char c1, char c2){
        return !((c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-'));
    }
    private int cal(char oper, int num1, int num2){
        if(oper == '+') return num2 + num1;
        else if(oper == '-') return num2 - num1;
        else if(oper == '*') return num2 * num1;
        else if(oper == '/') return num2 / num1;
        else return 0;
    }
}

//DFS
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int lastVal = 0;
        int idx = 0;
        char sign = '+';
        int sum = 0;
        while (idx < s.length()) {
            if(s.charAt(idx) == ' '){
                idx++;
                continue;
            }
            int num = 0;
            if (s.charAt(idx) <= '9' && s.charAt(idx) >= '0') {
                while (idx < s.length() && s.charAt(idx) <= '9' && s.charAt(idx) >= '0') {
                    num = num * 10 + s.charAt(idx) - '0';
                    idx++;
                }
            }
            if (sign == '+') {
                sum = lastVal + sum;
                lastVal = num;
            } else if (sign == '-') {
                sum = lastVal + sum;
                lastVal = -num;
            } else if (sign == '*') {
                lastVal = lastVal * num;
            } else if (sign == '/') {
                lastVal = lastVal / num;
            }
            if (idx < s.length()) {
                sign = s.charAt(idx);
                idx++;
            }
        }
        sum += lastVal;
        return sum;
    }
}
