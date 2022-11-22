class Solution {

    /*
     *      #153
     *  For this problem we want to apply a binary search because we know it wants a runtime of
     *  o(logn). So to do this, we can start by creating our pointers. Some key traits to notice about a rotated
     *  array is that if we ever are at a point for the value at our left pointer is less than the value at our right pointer
     *  we can say that our minimum will be at the left pointer value since the values are sorted ascending.
     *  Another idea we know is that since it is rotated, the array is basically split into two portions
     *  a left and a right side. So we can find the current section we are in by checking our mid value compared to our left value.
     *  We know that if our mid value is greater than our left pointer, we are in the left section. This means that the minimum
     *  value is not in this section, but the right one instead. So we move our pointer accordingly to the right section.
     *  But if our mid value is less than our left value, we want to check our left side instead. So we move our right pointer.
     *  This way we can check if the first condition of nums[left] <= nums[right] is true on the correct section.
     *  
     */


    public int findMin(int[] nums) {
        //Left and right pointers
        int left = 0;
        int right = nums.length -1;
        
        
        while (left <= right){
            //If our current section or array is ascending we know left most value is the min.
            if(nums[left] <= nums[right]) return nums[left]; //This means our answer is found
            
            //set our min
            int mid = (left + right) / 2;
            //Check if we are in the left portion
           if(nums[mid] >= nums[left]){ //If we are in the left, min is found in the right section so...
               left = mid + 1; //Move our left pointer up
           }
            else{ //If our mid is less than our left, we want to check the left section instead so...
                right = mid; //Move right pointer down
            }
            
        }
        
        return -1;
        
        
    }
}