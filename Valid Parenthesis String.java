class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return false;

        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left.push(i);
            else if (c == ')') {
                if (!left.isEmpty()) left.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            } else if (c == '*') star.push(i);
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            int a = left.pop(), b = star.pop();
            if (a > b) return false;
        }
        return left.isEmpty();
    }
}

