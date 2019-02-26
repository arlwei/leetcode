import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(Objects.isNull(l1)) {
            return l2;
        }
        if(Objects.isNull(l2)) {
            return l1;
        }

        boolean carry = false;
        ListNode head = l1;
        ListNode current = l1;

        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            l1.val += l2.val;
            if(carry) {
                l1.val++;
                carry = false;
            }
            if (l1.val > 9) {
                carry = true;
                l1.val -= 10;
            }
            current = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(Objects.isNull(l1) && Objects.isNull(l2) && carry) {
            ListNode tmp = new ListNode(1);
            current.next = tmp;
            tmp.next = null;
        }

        checkLeftVal(current, l1, l2, carry);
        checkLeftVal(current, l2, l1, carry);

        return head;
    }

    public void checkLeftVal(ListNode current, ListNode emptyNode, ListNode leftNode, boolean carry) {
        if(Objects.isNull(emptyNode))
        {
            while (Objects.nonNull(leftNode)) {
                if(carry) {
                    leftNode.val++;
                    carry = false;
                }
                if (leftNode.val > 9) {
                    leftNode.val -= 10;
                    carry = true;
                }
                current.next = leftNode;
                current = current.next;
                leftNode = leftNode.next;
            }
            if (carry)
            {
                ListNode tmp = new ListNode(1);
                current.next = tmp;
                tmp.next = null;
            }
        }
    }
}