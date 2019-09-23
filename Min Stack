class MinStack {
    private Stack<Integer> s_data;
    private Stack<Integer> s_min;
    /** initialize your data structure here. */
    public MinStack() {
        s_data = new Stack<>();  // do not have to write Stack<Integer>
        s_min = new Stack<>();
    }
    
    public void push(int x) {
        s_data.push(x);
        if(s_min.empty()) s_min.push(x);
        else s_min.push(Math.min(s_min.peek(), x));  //even the x is bigger also need to put a value
         //wrong: if(s_min.empty() || x < s_min.peek()) s_min.push(x);  cause if x is bigger then no value will be pushed into the stack which is wrong
    }
    
    public void pop() {
        if(s_data.empty()) return;
        s_min.pop();
        s_data.pop();
    }
    
    public int top() {
        return s_data.peek();
    }
    
    public int getMin() {
        if(s_min.empty()) return Integer.MAX_VALUE;
        else return s_min.peek();
    }
}
