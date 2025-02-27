package linked_list;

// LC1_TwoSum.java
// Source: https://leetcode.com/problems/two-sum/

//Given head, the head of a linked list, determine if the linked list has a cycle in it.
//        There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
//        following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
//        is connected to. Note that pos is not passed as a parameter.
//        Return true if there is a cycle in the linked list. Otherwise, return false.

//        Example 1:
//        Input: head = [3,2,0,-4], pos = 1
//        Output: true
//        Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

//        Example 2:
//        Input: head = [1,2], pos = 0
//        Output: true
//        Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

//        Example 3:
//        Input: head = [1], pos = -1
//        Output: false
//        Explanation: There is no cycle in the linked list.

//        Constraints:
//        The number of the nodes in the list is in the range [0, 104].
//        -105 <= Node.val <= 105
//        pos is -1 or a valid index in the linked-list.
public class LC141_LinkedListCycle {
    public static void main(String[] args) {
        int[] head1 =  {3,2,0,-4};
        int pos1 = 1;
        ListNode node1 = ListNode.fromArray(head1, pos1);
        boolean result1 = hasCycle(node1);
        System.out.println("result1 = " + result1);

        int[] head2 =  {1,2};
        int pos2 = 1;
        ListNode node2 = ListNode.fromArray(head2, pos2);
        boolean result2 = hasCycle(node2);
        System.out.println("result2 = " + result2);

        int[] head3 =  {1};
        int pos3 = -1;
        ListNode node3 = ListNode.fromArray(head3, pos3);
        boolean result3 = hasCycle(node3);
        System.out.println("result3 = " + result3);

    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }

}


