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
 *          #143
 *  To do this problem, we can think of splitting the list into two pieces. The first half, and the second half. After doing this
 *  we should be able to use a 'two-pointer' type approach and values accordingly. First half -> secondhalf -> firsthalf -> secondhalf ....
 *  So we can start by finding the middle first in order to know where to split. We use this by using a fast and slow pointer since the slow
 *  will end up in the middle. We then want to be able to traverse our lists correctly, so we reverse the pointers in the
 *  second half of the list so that we can move from end -> beginning while the front moves from beginning to end. Then after reversing
 *  we can compare both sections and add nodes accordingly to the proper next values.
 */
class Solution {
    public void reorderList(ListNode head) {
    
        //Using fast and slow pointers to get to the middle of the list.
       ListNode slow = head;
        ListNode fast = head.next;
        //This lets the slow pointer reach the middle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Start creating our second half of the list
        ListNode second = slow.next; //Move our pointer up one and have it's next value be null so we know when to stop
        slow.next = null;
        
        //Begin reversing the second half of the list using reverse Linkedlist practice
        ListNode prev = null;
        while(second !=null){
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
    
        //Set our second half starting point to the end value which is the last value
        second = prev; // this is going to be the head of the second half of the reversed list
        ListNode first = head; //This is our first pointer for the front part of the list
         
        //We use this condition because there is a possibility that our second half is smaller because the size of the list can be odd.
        while(second != null){
            //Save our next values for both halves
            ListNode tmp = first.next; 
            ListNode tmp2 = second.next;
            
            //Set our pointers nexts value based on our two pointers
            first.next = second;
            second.next = tmp;
            
            //Mvoe our pointers up to our saved value and increase the pointer
            first = tmp;
            second = tmp2;   
        }
    }
}