/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
 *      #206
 *  To reverse a linked list, we want to be able to manage pointers accordingly. For a linked list, we only have two pointers
 *  availible to us which are the node we are currently at, and the next node. But if we want to be able to swap this,
 *  there is another which we want to track which are the previous value so we can access this later. So to reverse it
 *  At each iteration we would want to hold onto the next node and store it. Then we would want to set our current node's 
 *  node's next value equal to the previous value. That way we can swap the pointers and have it pointing at a new previous. After this,
 *  we can set our previous equal to our current node because our current node is going to be the previous once we get to the next value.
 *  Finally we can move our current node forward by setting it equal to the next node that we saved. And at the end of iteration,
 *  we return the previous value because it now points the other way
 * 
 * ex:
 * 
 * Before swapping:
 * 
 * PREV
 *  Null -> 1 -> 2-> 3 -> 4
 * 
 * After swapping
 *                        PREV
 * null <- 1 <- 2 <- 3 <- 4
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null; //Our initial value for previous before we traverse
        ListNode curr = head; //Our moving pointer
        
        while(curr != null){ //While we have a value
            ListNode next = curr.next; //Store our next value before we change it
            curr.next = prev; //Set our next value equal to our previous
            prev = curr; //Make our previous our current value for the next iteration
            curr = next; //move our current value to the next val in the list
        }
        return prev; 
    }
}