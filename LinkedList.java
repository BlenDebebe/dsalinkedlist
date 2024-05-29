class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Method to add a node at a specific position
    public void insertAt(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Index out of bounds.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Method to delete a node at a specific position
    public void deleteAt(int index) {
        if (head == null) {
            System.out.println("The list is empty. Cannot delete.");
            return;
        }

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current.next != null; i++) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Index out of bounds.");
        } else {
            current.next = current.next.next;
        }
    }

    // Method to delete a node after a given node
    public void deleteAfter(int value) {
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Value not found or no node to delete after the given value.");
        } else {
            current.next = current.next.next;
        }
    }

    // Method to search for a value
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to display the list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Implementing a stack using the linked list
    public static class Stack {
        private Node top;

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public int pop() {
            if (top == null) {
                throw new IllegalStateException("Stack is empty.");
            }
            int data = top.data;
            top = top.next;
            return data;
        }

        public int peek() {
            if (top == null) {
                throw new IllegalStateException("Stack is empty.");
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void display() {
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insert elements at specific positions
        list.insertAt(0, 10);
        list.insertAt(1, 20);
        list.insertAt(1, 15);
        list.insertAt(3, 25);
        System.out.println("List after insertions:");
        list.display();

        // Delete elements at specific positions
        list.deleteAt(2);
        System.out.println("List after deleting at index 2:");
        list.display();

        // Delete node after a given value
        list.deleteAfter(10);
        System.out.println("List after deleting node after value 10:");
        list.display();

        // Search for a value
        System.out.println("Search for 20: " + list.search(20));
        System.out.println("Search for 30: " + list.search(30));

        // Stack operations
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushing 10, 20, 30:");
        stack.display();

        System.out.println("Stack peek: " + stack.peek());

        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack after pop:");
        stack.display();

        System.out.println("Stack is empty: " + stack.isEmpty());
    }
}
