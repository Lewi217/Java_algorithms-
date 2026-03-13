package linked_list;

/*
 Circular Doubly Linked List implementation in Java
 A circular doubly linked list is a data structure that consists of nodes where each node has a reference to both the next and previous nodes, and the last node points back to the first node, forming a circle. This allows for efficient insertion and deletion of nodes from both ends of the list, as well as easy traversal in both directions.
 - Structure: nodes with prev and next pointers, plus a head reference. The last node's next points to head, and head's prev points to the last node.
 - Common operations: insert (head/tail/middle), delete (given node), search, forward/backward traversal.
 - Time complexity: access/search O(n), insertion/deletion O(1) if you already have the node reference.
 - Tradeoffs: uses extra memory for the prev pointer and circular references, but allows for efficient bidirectional navigation and easy handling of edge cases (like deleting the head or tail).
 */
public class Circular_Doubly_Linked_List {
    // Node class
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    // Insert at beginning
    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node last = head.prev;

        newNode.next = head;
        newNode.prev = last;

        last.next = newNode;
        head.prev = newNode;

        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
            return;
        }

        Node last = head.prev;

        last.next = newNode;
        newNode.prev = last;

        newNode.next = head;
        head.prev = newNode;
    }

    // Delete a node
    public void delete(int key) {

        if (head == null) return;

        Node current = head;

        do {
            if (current.data == key) {

                // Only one node
                if (current.next == head) {
                    head = null;
                    return;
                }

                Node prevNode = current.prev;
                Node nextNode = current.next;

                prevNode.next = nextNode;
                nextNode.prev = prevNode;

                if (current == head) {
                    head = nextNode;
                }

                return;
            }

            current = current.next;

        } while (current != head);
    }

    // Display the list
    public void display() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;

        do {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    // Main method
    public static void main(String[] args) {

        Circular_Doubly_Linked_List list = new Circular_Doubly_Linked_List();

        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);

        System.out.println("Circular Doubly Linked List:");
        list.display();

        list.delete(20);

        System.out.println("After deleting 20:");
        list.display();
    }
}
