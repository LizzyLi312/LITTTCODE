class MyQueue {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;
    /** Initialize your data structure here. */
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stackOut.empty()) move();
        return stackOut.empty() ? null : stackOut.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stackOut.empty()) move();
        return stackOut.empty() ? null : stackOut.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }
    
    private void move(){
        if(stackIn.empty()) return;
        else while(!stackIn.empty()){
            stackOut.push(stackIn.pop());
        }
    }
}
