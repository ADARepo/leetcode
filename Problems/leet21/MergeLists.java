package leet21;

public class MergeLists 
{
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;

        ListNode sorted = new ListNode();
        ListNode retSort = sorted;

        ListNode head1 = list1, head2 = list2;
        int prev1 = -101, prev2 = -101;

        while ((head1 != null) && (head2 != null))
        {
            if (head1.val < head2.val)
            {
                sorted.val = head1.val;
                head1 = head1.next;

                if (head1 != null && sorted.val <= head1.val)
                {
                    sorted.next = new ListNode();
                    sorted = sorted.next;
                }
            }
            else
            {
                sorted.val = head2.val;
                head2 = head2.next;

                if (head2 != null && sorted.val <= head2.val)
                {
                    sorted.next = new ListNode();
                    sorted = sorted.next;
                }
            }
        }
        
        while (head1 != null)
        {
            sorted.next = new ListNode();
            sorted = sorted.next;
            sorted.val = head1.val;
            head1 = head1.next;
        }

        while (head2 != null)
        {
            sorted.next = new ListNode();
            sorted = sorted.next;
            sorted.val = head2.val;
            head2 = head2.next;
        }

        return retSort;
    }

    public static void main (String [] args)
    {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode start1 = l1;
        ListNode start2 = l2;

        start1.val = 1;
        start1.next = new ListNode();
        start1 = start1.next;
        start1.val = 2;
        start1.next = new ListNode();
        start1 = start1.next;
        start1.val = 4;
        start1.next = new ListNode();
        start1 = start1.next;

        start2.val = 1;
        start2.next = new ListNode();
        start2 = start2.next;
        start2.val = 3;
        start2.next = new ListNode();
        start2 = start2.next;
        start2.val = 4;
        start2.next = new ListNode();
        start2 = start2.next;

        System.out.println(mergeTwoLists(l1, l2));
    }
}
