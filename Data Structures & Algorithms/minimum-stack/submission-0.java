class MinStack {

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        int min= Math.min(val, stack.isEmpty() ? val : stack.peek());
        stack.push(min);
        minStack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return stack.peek();
    }
}
