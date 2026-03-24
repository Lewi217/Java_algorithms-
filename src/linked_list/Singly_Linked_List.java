package linked_list;

/*
 Singly Linked List implementation in Java
 A singly linked list is a data structure that consists of nodes where each node contains data and a reference to the next node in the list. The last node's next reference points to null, indicating the end of the list. This structure allows for efficient insertion and deletion of nodes, especially at the beginning of the list, but it does not allow for backward traversal.
 - Structure: nodes with data and next pointer, plus a head reference.
 - Common operations: insert (head/tail), delete (given value), search, traversal.
 - Time complexity: access/search O(n), insertion/deletion O(1) at head, O(n) at tail.
 - Tradeoffs: uses less memory than doubly linked lists but only allows for forward traversal.
 */
public class Singly_Linked_List {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Linked List class
    static class SinglyLinkedList {
        Node head;

        // Insert at beginning
        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
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
        }

        // Delete a node by value
        public void delete(int key) {
            if (head == null) return;

            // If head is to be deleted
            if (head.data == key) {
                head = head.next;
                return;
            }

            Node temp = head;

            while (temp.next != null && temp.next.data != key) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        // Display list
        public void display() {
            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " → ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    // Main method
    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.println("After inserting at end:");
        list.display();

        list.insertAtBeginning(5);

        System.out.println("After inserting at beginning:");
        list.display();

        list.delete(20);

        System.out.println("After deleting 20:");
        list.display();
    }
}
