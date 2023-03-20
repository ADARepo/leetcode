package leet23;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MergeK 
{
    

    public static ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        int j = 0;

        while (j < lists.length && lists[j] == null) j++;
        if (j >= lists.length) return null;

        List <Integer> l1 = new ArrayList<>();

        // adding all lists in lists to an ArrayList.
        // we only need the values to sort, not the node. so grab all values then sort before forming into a singly linked listnode.
        for (ListNode currList : lists)
        {
            
            while (currList != null)
            {
                l1.add(currList.val);
                currList = currList.next;
            }
        }

        Collections.sort(l1);

        ListNode ret = new ListNode();
        ListNode currRet = ret;
        int sz = l1.size();

        for (int i = 0; i < sz; i++)
        {
            currRet.val = l1.get(i);
            currRet.next = new ListNode();
            if (i != (sz - 1)) currRet = currRet.next;
        }
        
        currRet.next = null;

        return ret;
    }

    public static void main (String [] args)
    {
        ListNode [] ls = new ListNode[2];
        
        // ls[0] = null;
        // ls[1] = new ListNode(1);

        ls[0] = new ListNode();
        ls[1] = new ListNode();

        // ls[0] = new ListNode(1, new ListNode(13, new ListNode(45)));
        // ls[1] = new ListNode(11, new ListNode(14, new ListNode(15)));

        // ls[0] = new ListNode(1, new ListNode(2, new ListNode(3)));
        // ls[1] = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))));

        // ls[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        // ls[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        // ls[2] = new ListNode(2, new ListNode(6));

        ListNode head = mergeKLists(ls);

    }
}
