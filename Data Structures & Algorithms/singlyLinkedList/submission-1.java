class LinkedList {

       private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        if (index < 0) return -1;
        
        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp == null) return -1; // Reached end before index
            temp = temp.next;
        }
        
        // If we found the node, temp will not be null
        if (temp == null) return -1;
        return temp.val;
    }

    public void insertHead(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public void insertTail(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public boolean remove(int index) {
        if (index < 0 || head == null) return false;

        if (index == 0) {
            // Removing the head
            head = head.next;
            if (head == null) {
                tail = null; // List became empty
            }
            return true;
        }

        // Removing from middle or tail
        Node temp = head;
        // Iterate to the node BEFORE the one we want to remove
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
            if (temp == null) return false; // Index is far out of bounds
        }
        
        // temp is the node before the target. 
        // If temp is null or temp.next (target) is null, it's out of bounds
        if (temp == null || temp.next == null) {
            return false;
        }
        
        temp.next = temp.next.next;
        
        // If we removed the tail, we must update the tail pointer
        if (temp.next == null) {
            tail = temp;
        }
        
        return true;
    }

    public ArrayList<Integer> getValues() {
        Node temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        return arr;
    }
}
