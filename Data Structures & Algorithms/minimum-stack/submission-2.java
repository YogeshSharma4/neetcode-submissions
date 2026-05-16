class MinStack {

       ArrayDeque<Long> stack = new ArrayDeque<>();
    long min;

    public MinStack() {

    }

    public void push(int val) {
        // if(!minstack.isEmpty()) {
        // int min = Math.min(val, minstack.peek());
        // minstack.push(min);
        // } else {
        // minstack.push(val);
        // }
        // stack.push(val);
        if (stack.isEmpty()) {
            min = val;
        }
        stack.push((long) val - min);
        if (val < min) {
            min = val;
        }
    }

    public void pop() {
        // minstack.pop();
        // stack.pop();
        if (stack.peek() > 0)
            stack.pop();
        else {
            min = min - stack.pop();
        }
    }

    public int top() {
        // return stack.peek();
        if (stack.peek() > 0) {
            return (int) (stack.peek() + min);
        } else
            return (int) min;
    }

    public int getMin() {
        // return minstack.peek();
        return (int) min;
    }
}
