/**
 * title:
 *  21. Merge Two Sorted Lists
 *
 *  Content:
 *      Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 *  Example:
 *      Input: 1->2->4, 1->3->4
 *      Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(null == l1)
            return l2;
        if(null == l2)
            return l1;

        ListNode head = null, p = null;
        //set head
        if(l1.val <= l2.val)
        {
            head = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            l2 = l2.next;
        }

        //set pointer
        p = head;
        while(l1 != null &&  l2 != null)
        {
            while(l1 != null &&  l2 != null && l1.val <= l2.val)
            {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            while ( l1 != null && l2 != null && l1.val > l2.val)
            {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }

        if(l1 == null && l2 != null)
        {
            do
            {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
            while (l2 != null);
        }

        if (l2 == null && l1 != null)
        {
            do
            {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }
            while (l1 != null);
        }
        return head;
    }
}