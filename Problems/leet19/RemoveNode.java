package leet19;

public class RemoveNode 
{
    // [1, 2 ,3], n=3
    // [1,2,3,4,5], n = 2
    // [1, 2], n = 2
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        // size of ListNode = 1, so n = 1;
        if (head.next == null)
        {
            head = null;
            return head;
        }

        ListNode frontPointer = head;
        int counter = 0;

        while (counter < n && frontPointer.next != null)
        {
            frontPointer = frontPointer.next;
            counter++;
        }

        // this means we reached the end of the list and counter didn't reach n. remove head node.
        if (frontPointer.next == null && counter < n)
        {
            head = head.next;
            return head;
        }

        ListNode backPointer = head;

        while (frontPointer.next != null)
        {
            frontPointer = frontPointer.next;
            backPointer = backPointer.next;
        }

        backPointer.next = backPointer.next.next;
        
        return head;
    }

    public static void main(String [] args)
    {
        ListNode start = new ListNode();

        ListNode head = start;
        ListNode temp;

        start.val = 1;
        temp = new ListNode(2);
        start.next = temp;
        start = start.next;
        start.val = 2;

        RemoveNode rn = new RemoveNode();
        ListNode ret = rn.removeNthFromEnd(head, 2);
    }
}
