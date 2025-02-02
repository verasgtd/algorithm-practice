package linked_list;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
    public static ListNode fromArray(int[] x, int pos) {
        if (x==null || x.length==0) return null;
        ListNode head = new ListNode(x[0]);
        ListNode previous = head;
        ListNode posNode = (pos == 0) ? head : null;
        if(x.length>1)
            for(int i = 1; i< x.length; i++){
                ListNode node = new ListNode(x[i]);
                if(i==pos) posNode = node;
                previous.next = node;
                previous=node;
            }
        previous.next = posNode;
        return head;
    }

}
