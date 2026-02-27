package linked_list;

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
