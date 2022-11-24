/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
 *          #141
 *  To solve this we need to use a fast and a slow pointer. A slow pointer increments regularly by one during each iteration.
 *  A fast in this case increases 2x as fast as our slow. This is done because by using a pointer that moves twice as fast,
 *  we know that if at some reason we end up having equal values, that means that a cycle was found. But if the values are next equal, then this means that
 *  we don't have a cycle that exists.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head; //Fast pointer 
        ListNode slow = head; //Slow pointer
        
        while(fast != null && fast.next != null){
            fast = fast.next.next; //Increase 2x as much as slow
            slow = slow.next; //Increase regularly
            
            if(fast == slow) { //If the values ever match we have a cycle
                return true;
            }
        }
        
        return false; //Values never matched
    }
}