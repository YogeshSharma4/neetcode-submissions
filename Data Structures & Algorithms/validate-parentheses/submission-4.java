class Solution {
    public boolean isValid(String s) {

        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) == '{' || s.charAt(i)=='(' || s.charAt(i)=='['){
                deque.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '}') {
                    if(!deque.isEmpty()) {
                      if (deque.pop() == '{') continue;
                      else 
                        return false;
                    } else {
                        return false;
                    }
                } else if (s.charAt(i) == ')') {
                     if(!deque.isEmpty()) {
                      if (deque.pop() == '(') continue;
                      else 
                        return false;
                    } else {
                        return false;
                    }
                } else if(s.charAt(i) == ']') {
                    if(!deque.isEmpty()) {
                      if (deque.pop() == '[') continue;
                      else 
                        return false;
                    } else {
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();
        
    }
}
