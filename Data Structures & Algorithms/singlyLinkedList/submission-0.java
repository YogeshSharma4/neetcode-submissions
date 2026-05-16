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
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0; // standard practice: size is the count of elements
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1; // Added check for negative index
        
        Node temp = head;
        // BUG FIX: changed while (i == index) to a for loop (i < index)
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
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
        size++; // update size
    }

    public void insertTail(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++; // update size
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) return false;

        if (index == 0) {
            // Removing the head
            head = head.next;
            if (head == null) {
                tail = null; // List became empty
            }
        } else {
            // Removing from middle or tail
            Node temp = head;
            // Iterate to the node BEFORE the one we want to remove
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            
            temp.next = temp.next.next;
            
            // If we removed the tail, we must update the tail pointer
            if (index == size - 1) {
                tail = temp;
            }
        }
        
        size--; // BUG FIX: Decrement size when removing
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
