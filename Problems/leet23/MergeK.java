package leet23;

public class MergeK 
{
    

    public static ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 1) return lists[0];
        ListNode ret = new ListNode();
        if (lists.length == 0) return null;

        ret = lists[0];

        int j = 0;

        while (j < lists.length && lists[j] == null) j++;
        if (j >= lists.length) return null;
        ret = lists[j];

        for (int i=0; (i < lists.length); i++)
        {
            // sort current list into ret.
            while (i!= j && lists[i] != null)
            {
                ListNode currRet = ret;
                ListNode currList;

                // move forward in the ret until the next value in ret is greater than or equal to the value in lists
                // also need to look at the current value in ret and see if we need to change head in ret (lower value in lists[i] than head of )
                while (currRet != null && currRet.next != null && currRet.val < lists[i].val && currRet.next.val < lists[i].val)
                {
                    currRet = currRet.next;
                }

                // check if currRet val is greater than lists[i].val. if it is, make new currRet
                if (currRet != null && currRet.val >= lists[i].val)
                {
                    currList = lists[i];
                    lists[i] = lists[i].next;
                    currList.next = currRet;
                    currRet = currList;
                    if (currRet != ret) ret = currList;
                }

                else if (currRet != null && currRet.next != null && currRet.next.val >= lists[i].val)
                {
                    currList = lists[i];
                    lists[i] = lists[i].next;
                    currList.next = currRet.next;
                    currRet.next = currList;
                }

                else if (currRet != null && currRet.next == null)
                {
                    currList = lists[i];
                    currRet.next = currList;
                    break;
                }

                // next is not null in currRet, so that means the value next is greater than lists[i].
                // insert value in currRet at lists[i].
                // else if (currRet != null)
                // {
                //     currList = lists[i];
                //     lists[i] = lists[i].next;
                //     currList.next = currRet.next;
                //     currRet.next = currList;
                // }
            }
        }
        
        return ret;
    }

    public static void main (String [] args)
    {
        ListNode [] ls = new ListNode[2];
        
        ls[0] = null;
        ls[1] = new ListNode(1);

        // ls[0] = new ListNode(1);
        // ls[1] = new ListNode(0);

        // ls[0] = new ListNode(1, new ListNode(13, new ListNode(45)));
        // ls[1] = new ListNode(11, new ListNode(14, new ListNode(15)));

        ls[0] = new ListNode(1, new ListNode(2, new ListNode(3)));
        ls[1] = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))));

        // ls[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        // ls[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        // ls[2] = new ListNode(2, new ListNode(6));

        ListNode head = mergeKLists(ls);

    }
}
