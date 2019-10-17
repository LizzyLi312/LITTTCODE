class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c =='(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.empty() || stack.pop() != c) return false;
        }
        if(stack.empty()) return true;  //cannot return true since the stack might be not empty.corner case like '(('
        else return false;
    }
}
