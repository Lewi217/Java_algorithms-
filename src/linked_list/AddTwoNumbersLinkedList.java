package linked_list;


/*
     You are given two linked list
     1. Each node contains a single digit (0-9).
     2.The digits are stored in reverse order.

     1. 678
     2. 234

     when reversed it is: 876
     when reversed it is: 432
        876 + 432 = 1308
        when reversed it is: 8031

     Two pointers : for lists
     A variable : carrying
     l1 = 6 → 7 → 8
        l2 = 2 → 3 → 4
        carry = 0
        Step 1.
        6 + 2  = 8
        7+3 = 10
        Write: 0
        Carry : 1
        Result : 8 -> 0
        Step 3.
        8 + 4 + 1 = 13
        result : 8 -> 0 -> 13

        Loop while
        list1 not empty OR
        list2 not empty OR
        carry not zero

        List1: 2-> 4 -> 3 (342)
        List2: 5 -> 6 -> 4 (465)
        result : 7 -> 0 -> 8 (807)

        [data | next]





 */
public class AddTwoNumbersLinkedList {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Method to add two linked lists
    public static Node addTwoNumbers(Node l1, Node l2) {

        Node dummy = new Node(0); // dummy head
        Node current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;

            current.next = new Node(sum % 10);

            // 10 % 10 = 0
            // 0
            current = current.next;
        }

        return dummy.next;
    }

    // Helper method to print list
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // First number: 2 → 4 → 3  (342)
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        // Second number: 5 → 6 → 4  (465)
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        Node result = addTwoNumbers(l1, l2);

        System.out.println("Result:");
        printList(result);
    }
}
// BigInteger