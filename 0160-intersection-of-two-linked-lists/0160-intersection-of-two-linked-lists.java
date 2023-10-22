/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        while (a != b){
            if (a.next == null){
                a = headB;
                headB = null;
            }
            else
                a = a.next;
            if (b.next == null){
                b = headA;
                headA = null;
            }
            else
                b = b.next;    
        }
        return a;
    }
}