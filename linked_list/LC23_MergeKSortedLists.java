package linked_list;

// LC23_MergeKSortedLists.java
// Source: https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//        Merge all the linked-lists into one sorted linked-list and return it.
//
//
//
//        Example 1:
//        Input: lists = [[1,4,5],[1,3,4],[2,6]]
//        Output: [1,1,2,3,4,4,5,6]
//        Explanation: The linked-lists are:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        merging them into one sorted list:
//        1->1->2->3->4->4->5->6
//
//        Example 2:
//        Input: lists = []
//        Output: []
//
//        Example 3:
//        Input: lists = [[]]
//        Output: []
//
//
//        Constraints:
//
//        k == lists.length
//        0 <= k <= 104
//        0 <= lists[i].length <= 500
//        -104 <= lists[i][j] <= 104
//        lists[i] is sorted in ascending order.
//        The sum of lists[i].length will not exceed 104.
public class LC23_MergeKSortedLists {
    public static void main(String[] args) {
        ListNode example11 = ListNode.fromArray(new int[]{1,4,5});
        ListNode example12 = ListNode.fromArray(new int[]{1,3,4});
        ListNode example13 = ListNode.fromArray(new int[]{2,6});


        ListNode result1 = mergeKLists(new ListNode[]{example11, example12, example13});
        System.out.println("result1 = " + result1);

        ListNode example21 = ListNode.fromArray(new int[]{2,4,5});
        ListNode example22 = ListNode.fromArray(new int[]{1,7,9,10});
        ListNode example23 = ListNode.fromArray(new int[]{12,14,15});
        ListNode result2 = mergeKLists(new ListNode[]{example21, example22, example23});
        System.out.println("result2 = " + result2);

        ListNode example31 = ListNode.fromArray(new int[0]);
        ListNode example32 = ListNode.fromArray(new int[0]);
        ListNode example33 = ListNode.fromArray(new int[0]);
        ListNode result3 = mergeKLists(new ListNode[]{example31, example32, example33});
        System.out.println("result3 = " + result3);


    }

    public static ListNode  mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return divideAndConquer(lists, 0, lists.length);
    }

    public static ListNode  divideAndConquer(ListNode[] lists, int start, int end){
        if (lists == null || start == end) return null;
        int size = end-start;
        if (size == 1) return  lists[start];
        if (size == 2) return mergeTwoSortedLists(lists[start], lists[start+1]);
        int middle = size/2;
        ListNode list1 = divideAndConquer(lists, start, start + middle);
        ListNode list2 = divideAndConquer(lists, start + middle, end);
        return mergeTwoSortedLists(list1, list2);
    }

    public static ListNode  mergeTwoSortedLists(ListNode list1, ListNode list2){
        ListNode head = new ListNode(-1);
        ListNode current = head;

        while (list1!=null && list2!=null) {
            if(list1.val<list2.val){
                current.next = list1;
                current = current.next;
                current.next=null;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                current.next=null;
                list2 = list2.next;
            }
        }
        if (list1!=null) current.next = list1;
        if (list2!=null) current.next = list2;

        return head.next;
    }

}


