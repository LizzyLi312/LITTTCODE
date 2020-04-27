class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        Stack<Integer> num = new Stack<>();
        Stack<Character> oper = new Stack<>();
        int idx = 0; 
        while(idx < s.length()){
            char c = s.charAt(idx);
            if(c == ' '){
                idx++;
                continue;
            }
            if(Character.isDigit(c)){
                int temp = 0;
                while(idx < s.length() && Character.isDigit(s.charAt(idx))){
                    temp = temp * 0 + s.charAt(idx) - '0';
                    idx++;
                }
                num.push(temp);
            }
            else if(isOper(c)){
                while(!oper.empty() && isPriority(oper.peek(), c)){
                    num.push(cal(num.pop(), num.pop(), oper.pop()));
                }
                if(c == '-'){
                    if(num.empty()) num.push(0);  //coener case: -1+1
                    else{ //coener case: 2 - (-1+1)
                        int index = idx - 1;
                        while(index >= 0 && s.charAt(index) == ' '){
                            index--;
                        }
                        if(s.charAt(index) == '(') num.push(0);
                    }
                }
                oper.push(c); //we only used the operators before c. so we need to push c into the stack 
                idx++;
            }
            else if(c == '('){
                oper.push(c);
                idx++;
            }
            else if(c == ')'){
                while(!oper.empty() && oper.peek() != '('){
                    num.push(cal(num.pop(), num.pop(), oper.pop()));
                }
                oper.pop(); //pop ( and do not push )
                idx++;
            }
        }
        while(!oper.empty()){
            num.push(cal(num.pop(), num.pop(), oper.pop()));
        }
        return num.pop();
    }
    private boolean isOper(Character c){
        if(c == '+' || c == '-' || c == '*' || c == '/') return true;
        else return false;
    }
    private boolean isPriority(Character c1, Character c2){
        if(c1 == '(' || c1 == ')') return false; //only calculate the nums in the parethese
        return !((c1 == '+' || c1 == '-') && (c2 == '*' || c2 == '/')); //only work when there a + or - after * /. and then works on the + or - before + or -
    }
    private int cal(int i1, int i2, Character c){
        switch(c){
            case '+': return i2 + i1;
            case '-': return i2 - i1;
            case '*': return i2 * i1;
            case '/': return i2 / i1;
        }
        return 0;
    }
}
