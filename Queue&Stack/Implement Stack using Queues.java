class MyStack {
    private Queue<Integer> que;
    /** Initialize your data structure here. */
    public MyStack() {
        que = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        que.offer(x);
        while(que.peek() != x){
            que.offer(que.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return que.isEmpty() ? null : que.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return que.isEmpty() ? null : que.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.isEmpty() ? true : false;
    }
}
