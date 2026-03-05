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
public class Revesre_Linked_List {
}
