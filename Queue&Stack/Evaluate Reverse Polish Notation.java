class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> num = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(isOper(s)) num.push(cal(num.pop(), num.pop(), s));
            else if(isNum(s)){
                num.push(Integer.parseInt(s));
            }
        }
        return num.pop();
    }
    private boolean isNum(String s){
        if(s == null || s.length() == 0) return false;
        char c = s.charAt(0);
        if(!Character.isDigit(c)){ //check the first digit
            if(c != '-') return c == '+';
            if(s.length() == 1) return false;
        }
        for(int i = 1; i < s.length(); i++){ //check the rest digit 
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
    private boolean isOper(String s){
        if(s == null || s.length() != 1) return false;
        char c = s.charAt(0);
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }
    private int cal(int n1, int n2, String oper){
        char c = oper.charAt(0);
        switch(c){
            case '+': return n2 + n1;
            case '-': return n2 - n1;
            case '/': return n2 / n1;
            case '*': return n2 * n1;
        }
        return 0; //remember to return 0;
    }
}
