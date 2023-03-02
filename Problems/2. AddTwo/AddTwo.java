import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; int left = 0; int right = 0;
        ListNode ln = new ListNode();
        ListNode head = ln;
        
        while (true)
        {
            left = (l1 != null) ? l1.val : 0;
            right = (l2 != null) ? l2.val : 0;

            ln.val = (left + right + carry) % 10;                

            carry = ((left + right + carry) > 9) ? 1 : 0;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;

            if (l1 == null && l2 == null && carry == 0) break;
            ln.next = new ListNode();
            ln = ln.next;
            
        }
        return head;
    }

    public static void main (String [] args)
    {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();

        int [] a1 = new int[]{9,9,9,9};
        int [] a2 = new int[]{9,9,9,9,9,9,9};
        
        ListNode h1 = l1;
        ListNode h2 = l2;

        l1.val = a1[0];
        for (int i = 1; i < a1.length; i++)
        {
            l1.next = new ListNode();
            l1 = l1.next;
            l1.val = a1[i];
        }
        l2.val = a2[0];
        for (int i = 1; i < a2.length; i++)
        {
            l2.next = new ListNode();
            l2 = l2.next;
            l2.val = a2[i];
        }

        AddTwo abc = new AddTwo();

        System.out.println(abc.addTwoNumbers(h1, h2));
    }
}