package linked_list;

/*
 Reverse a singly linked list by re-pointing each node's next reference so the list flows the opposite way.
Iterative approach (O(n) time, O(1) extra space):
Use three pointers: prev (initially null), curr (initial head), and next.
In a loop: save next = curr.next, set curr.next = prev, then advance prev = curr, curr = next.
When curr becomes null, prev is the new head.
Recursive approach (O(n) time, O(n) call stack):
Base: empty list or single node → return head.
Recurse on head.next to get newHead.
Then set head.next.next = head and head.next = null.
Return newHead.
 */

public class Reverse_Linked_List {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Insert at end
    public void insert(int data) {
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

    // Display linked list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Reverse the linked list
    public void reverse() {

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {

            next = current.next;    // store next node
            current.next = prev;    // reverse pointer

            prev = current;         // move prev forward
            current = next;         // move current forward
        }

        head = prev; // new head
    }

    // Main method
    public static void main(String[] args) {

        Reverse_Linked_List list = new Reverse_Linked_List();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Original Linked List:");
        list.display();

        list.reverse();

        System.out.println("Reversed Linked List:");
        list.display();
    }
}
