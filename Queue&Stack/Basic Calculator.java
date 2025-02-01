class Solution {
    Stack<Character> ops;
    Stack<Integer> nums;
    public int calculate(String s) {
        if (s == null || s.length() == 0) return -1;

        ops = new Stack<>();
        nums = new Stack<>();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('/', 2);
        map.put('*', 2);

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') sb.append(c);
        }

        s = sb.toString();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
                nums.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') eval();
                ops.pop();
            } else {
                if (i == 0 || s.charAt(i - 1) == '(') nums.push(0);
                while (!ops.isEmpty() && ops.peek() != '(' && map.get(ops.peek()) >= map.get(c)) eval();
                ops.push(c);
            }
        }
        while (!ops.isEmpty()) eval();
        return nums.peek();
    }

    private void eval() {
        int second = nums.pop();
        int first = nums.pop();

        char op = ops.pop();
        if (op == '+') nums.push(first + second);
        else if (op == '-') nums.push(first - second);
        else if (op == '*') nums.push(first * second);
        else if (op == '/') nums.push(first / second);
        return;
    }
}
