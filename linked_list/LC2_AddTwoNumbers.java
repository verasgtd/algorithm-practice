package linked_list;

// LC1_AddTwoNumbers.java
// Source: https://leetcode.com/problems/add-two-numbers/

//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//        Example 1:
//        Input: l1 = [2,4,3], l2 = [5,6,4]
//          Output: [7,0,8]
//          Explanation: 342 + 465 = 807.
//        Example 2:
//          Input: l1 = [0], l2 = [0]
//          Output: [0]
//         Example 3:
//          Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//          Output: [8,9,9,9,0,0,0,1]
//
//        Constraints:
//        The number of nodes in each linked list is in the range [1, 100].
//        0 <= Node.val <= 9
//        It is guaranteed that the list represents a number that does not have leading zeros.
public class LC2_AddTwoNumbers {
    public static void main(String[] args) {
        int[] head1 =  new int[]{2,4,3};
        int[] head2 =  new int[]{5,6,4};

        ListNode one1 = ListNode.fromArray(head1);
        ListNode two1 = ListNode.fromArray(head2);

        ListNode result1 = addTwoNumbers( one1,  two1);
        System.out.println("result1 = " + result1);

        head1 =  new int[]{0};
        head2 =  new int[]{0};
        ListNode one2 = ListNode.fromArray(head1);
        ListNode two2 = ListNode.fromArray(head2);

        ListNode result2 = addTwoNumbers( one2,  two2);
        System.out.println("result2 = " + result2);

        head1 =  new int[]{9,9,9,9,9,9,9};
        head2 =  new int[]{9,9,9,9};
        ListNode one3 = ListNode.fromArray(head1);
        ListNode two3 = ListNode.fromArray(head2);

        ListNode result3 = addTwoNumbers( one3,  two3);
        System.out.println("result3 = " + result3);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        int carry = 0;

        while (l1 != null || l2!=null){
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;
            int val = (num1+num2+carry)%10;
            carry  = (num1+num2+carry)/10;
            pointer.next = new ListNode(val);
            pointer = pointer.next;

            if(l1!=null)  l1 = l1.next;
            if(l2!=null)  l2 = l2.next;
        }
        if(carry!=0){
            pointer.next = new ListNode(carry);
        }
        return head.next;
    }

}


