class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < operations.length; i++) {
            if(Objects.equals(operations[i], "+")) {
                int last = deque.pop();
                int secondLast = deque.peek();
                int num = last + secondLast;
                deque.push(last);
                deque.push(num);
            } else if(operations[i].equals("D")) {
                int num = deque.peek()*2;
                deque.push(num);
            } else if(operations[i].equals("C")) {
                deque.pop();
            } else {
                deque.push(Integer.parseInt(operations[i]));
            }
        }
        return deque.stream().mapToInt(Integer::intValue).sum();
        
    }
}