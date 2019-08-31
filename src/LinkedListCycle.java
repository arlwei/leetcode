/**
 * titile:
 *   141. Linked List Cycle
 *
 *  content:
 *    Given a linked list, determine if it has a cycle in it.
 */
 
 /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
		ListNode q = head;
		while (p != null && q !=null && q.next != null) {
			if (p.next == q.next.next) {
				return true;
			} else {
				p = p.next;
				q = q.next.next;
			}
		}
		return false;
    }
}
 