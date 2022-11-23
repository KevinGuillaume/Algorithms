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
 *      #21
 *  To solve this, we want to think about the process of merging two lists that are both ascending. Without thinking of
 *  code, the way we would do this is just compare both lists starting from the beginning, and which list
 *  has the smallest value, you would put first. This is exactly what we do with the code. We first start by creating a dummy list to access
 *  our resulting list in the end. So we use the condition of both lists not being empty while we compare. That way we ensure we compare the same
 *  amount of numbers. So we check if list1.val <= list2.val. If it is, lets add it to our resulting list. If it's not, then lets
 *  add list2.val to our resulting list. Then we move the pointer of the list we just took from up one. Then we continue this process.
 *  After this loop, we want to check if any of the arrays have values left, because if an array has values left, that means it was larger than the
 *  other so we are able to just stick it onto the end of our result.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        
        while(list1 != null && list2 != null){ //While both lists have values
            if(list1.val <= list2.val){ //is our list1 value smaller than our list2 value?
                res.next = list1;   //IF it is lets add this answer to our current list
                list1 = list1.next; //move our list1 pointer forward
            }
            else{ //is our list2 value smaller than our list1 value?
                res.next = list2; //IF it is lets add this answer to our current list
                list2 = list2.next; //move our list2 pointer forward 
            }
            res = res.next; //Move up an index in our list so we add our values in order
        }
        
        if(list1 != null){ //Do we have any value in list1 we need to add?
            res.next = list1;
        }
        if(list2 !=null){ //Do we have any value in list2 we need to add?
            res.next = list2;
        }
        
        //We return dummy.next because this points to the start of our list res. 
        // It points to res because we have been using res.next when starting so our starting value is essentially dummy.next
        return dummy.next;
        
        
        
    }
}