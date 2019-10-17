class MyQueue {
    private Stack<Integer> stack_in;
    private Stack<Integer> stack_out;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack_in.push(x);
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        if(stack_out.empty()) return -1;  //need to manually check it here cause they both could be empty
        return stack_out.pop();
        //there are 2 cases: 1. stack_out is empty, then move all the elements 2. is not empty, pop it directly 
    }
    /** Get the front element. */
    public int peek() {
        move();
        return stack_out.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack_in.isEmpty() && stack_out.isEmpty() ? true : false;
    }
    private void move(){
        if(stack_out.empty()){ //when stack_out is empty then move all the elements into it
            while(!stack_in.isEmpty()){
                stack_out.push(stack_in.pop());
            }
        }    
    }
}
