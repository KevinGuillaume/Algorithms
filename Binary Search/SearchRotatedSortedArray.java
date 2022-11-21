class Solution {
    /*
     *          #33
     *  To start, we know we will need to use a binary search because of the runtime of O(logn).
     *  We create our respective pointers, and begin our loop. When looking through a rotated array,
     *  something that will help us is finding where we are in the rotated array. This means that we 
     *  should find if we are in the left portion of the rotated array, or the right portion. So by
     *  using the conditions in the code, it lets us find where we are, and use the correct binary search
     *  to search the correct portion (left or right).
     */
    public int search(int[] nums, int target) {
        
       
        int left = 0, right =nums.length -1;
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]) return mid; //if value is found
            
            
            //First check the left portion of the array to see
            if(nums[left] <= nums[mid]){

                //This if makes sure we are inside the left portion and not the right

                //if target is greater than our mid value, then it must be on the right side
                // If its smaller than our left most value, then it must be on the right side
                if(target > nums[mid] || target < nums[left]){ 
                    left = mid + 1; //This means we need to look at the right side of the array
                }
                else { //Since none of the conditions are met, then we are on the left
                    right = mid - 1;
                }
            }
            //This checks the right side of the array to see 
            else{
                //If target is less than our mid value, the we look on the left side
                //If target is greater than lest most value, then it should still be on the left
                if(target < nums[mid] || target > nums[right]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
           
            
                
        }
        
        
        return -1;
    }
}