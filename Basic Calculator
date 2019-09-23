class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){  //isDigit(char ch):Determines if the specified character is a digit.
                int num = c - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i+1))){  //if num has more than 1 digit
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += num * sign;
            }
            else if(c == '+')
                sign = 1;
            else if(c == '-')
                sign = -1;
            else if(c == '('){  //push the previous result and start a new one 
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(c == ')'){ //retrive the preious result and add it, the 1st one come out is the sign cause you pushed it after the num
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}
