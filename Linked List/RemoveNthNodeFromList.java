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
class Solution {
    /*
     *      #19 
     *  To solve this, we can use the idea that we are going to need to be at the end of the list. So the way we can get to the end
     *  is simply by traversing our way through the linked list. But the only issue with this is that it leaves us with no
     *  way back. So to tackle this issue, we can use knowledge from previous problems solved like 'Reversing a linked list'.
     *  By reversing the linked list, we are able to get back to the beginning. So now that we have a way back, we can use a counter
     *  to keep track of our current index and see if we are at the Nth node from the end to remove. The last thing we need to do is make 
     *  sure we return the list back to its original direction. The way we can do that is by reversing the list one more time as we
     *  go back to the beginning:
     *  
     *  1 -> 2 -> 3      Original
     *  1 <- 2 <- 3     After 1 pass
     *  1 -> 2 -> 3     when we finish
     * 
     * 
     *  So we reverse the list one more time will finding the Nth node, and we change the pointers correctly at the Nth node so that 
     *  we can 'delete' the node.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //1st list reversal 
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        
        head = prev; //set our head at the start since prev is at the beginning of our new direction
        int count = 0; //Count to find Nth node
        prev = null; //start our reversal over by making prev null
        

        //2nd reversal while looking for Nth node
        while(head != null){
            count++; //Increase the count since we are using a 0-index
            ListNode next = head.next; //Reversal process
            head.next = prev; //Reversal process 
            if(count == n){ //If we find our Nth node
                //This is the only step we do different. We don't make our previous the current node,
                //We make the previous the previous we already have so we skip the current node for the next pointer
                
                prev = head.next; 
                
            }
            else{
                prev = head; //Reversal process
            }
            head = next; //increment
            
        }
        
        
        
        return prev; //This is the new start after reversing
        
        
        
    }
}