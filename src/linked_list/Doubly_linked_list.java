package linked_list;

/*
   A doubly linked list is a linear data structure where each node holds a value and two pointers: one to the next node and one to the previous node. This allows efficient traversal and removal in both directions.
- Structure: nodes with prev and next pointers, plus head and tail references.
- Common operations: insert (head/tail/middle), delete (given node), search, forward/backward traversal.
- Time complexity: access/search O(n), insertion/deletion O(1) if you already have the node reference.
- Tradeoffs: uses extra memory for the prev pointer but gives bidirectional navigation (useful for undo/redo, browser history, LRU caches).

 */
public class Doubly_linked_list {

    // Node class
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Doubly Linked List class
    static class DoublyLinkedList {
        Node head;

        // Insert at beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);

            if (head != null) {
                head.prev = newNode;
                newNode.next = head;
            }

            head = newNode;
        }

        // Insert at end
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
        }

        // Delete a node by value
        public void delete(int key) {
            if (head == null) return;

            Node temp = head;

            // If head is to be deleted
            if (temp.data == key) {
                head = temp.next;
                if (head != null) {
                    head.prev = null;
                }
                return;
            }

            // Search for the node
            while (temp != null && temp.data != key) {
                temp = temp.next;
            }

            if (temp == null) return; // Not found

            // Adjust pointers
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }

            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }

        // Display forward
        public void displayForward() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " ⇄ ");
                temp = temp.next;
            }

            System.out.println("null");
        }

        // Display backward
        public void displayBackward() {
            if (head == null) return;

            Node temp = head;

            // Move to last node
            while (temp.next != null) {
                temp = temp.next;
            }

            // Traverse backward
            while (temp != null) {
                System.out.print(temp.data + " ⇄ ");
                temp = temp.prev;
            }

            System.out.println("null");
        }
    }

    // Main method
    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("Forward traversal:");
        list.displayForward();

        System.out.println("Backward traversal:");
        list.displayBackward();

        list.insertAtBeginning(5);

        System.out.println("After inserting 5 at beginning:");
        list.displayForward();

        list.delete(20);

        System.out.println("After deleting 20:");
        list.displayForward();
    }
}
