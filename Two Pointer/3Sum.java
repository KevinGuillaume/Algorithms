class Solution {

    /*
                    # 15
     * Solution:
     * To solve this we can first analyze that we will need some sort of sorting. Since this is a two pointer problem
     * sorting helps us move in a predicatable way where we know how a total value will be manipulated if we move left or right.
     * So, first we want to sort the nums array, and then iterate through it. When iterating, we first want to ensure no duplicate
     * values will be in our res array. To do this we can use the condition if(i==0 || (i > 0 && nums[i] != nums[i-1])). This tells us that
     * if we are at the beginning where no values come before, or if we are not at an already seen starting value (nums[i] != num[i-1]) then we can move on.
     * If this condition is passed, we can begin to move into our work. We can set our left and right pointers, and also create a target. By using a target
     * it makes the calculations smaller. The target is essentially the compliment of the sum 0. So now we just need to find what two numbers add up to the target.
     * So we iterate through nums again, but this time with our pointers. We check if we find something <, >, or ==. If it is less than or greater than
     * target, we move accordingly. But if it is equal, we first want to add the results we just found, then we want 
     * to do a similar check to the one in the beginning and move until we don't have a duplicate left value, and right value.
     */


    public List<List<Integer>> threeSum(int[] nums) {
        
        
        List<List<Integer>> res = new ArrayList<>(); //Create result array
        Arrays.sort(nums); //Sort nums so that we know the behavior of the initial array
        
        
        for(int i = 0; i<nums.length-2; i++){ //Iteratre through nums
            if(i==0 || (i > 0 && nums[i] != nums[i-1])){ //This is used to ensure no duplicates are found in our res set
                int l = i + 1; //left pointer
                int r = nums.length -1; //right pointer
                int target = 0 - nums[i]; //This is used to create a target by using the compliment (two sum)
                while(l < r){
                    if(nums[l] + nums[r] == target) { //if we find a solution
                        res.add(Arrays.asList(nums[i],nums[l],nums[r])); //add the solution
                        while(l < r && nums[l] == nums[l+1]) l++; //then move left pointer to the next non-duplicate value
                        while(l < r && nums[r] == nums[r-1]) r--; //move the right pointer to the next non-duplicate value;
                        l++; //increase our left pointer 
                        r--; //decrease our right pointer
                    }
                    else if(nums[l] + nums[r] > target){ //if answer is too big, decrease our total by decrease right pointer
                        r--;
                    }
                    else{ //if the answer is too small, decrease our total by increase left pointer
                        l++;
                    }
                }
            }
        }
                
            
        return res;
    }
}
