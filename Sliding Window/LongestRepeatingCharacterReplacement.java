class Solution {
    
    /*
        #424    
        
        We want to iterat through the array with two pointers left and right. We want to have a sliding
        window that goes through the array and increases size. We should increase size whenever our particular coniditon is met.
        The condition that needs to be met in this case is that: the max frequency of one character in our window
        subtracted from the size of our window should be less than or equal to our K value. Because this will let us know
        we are able to make the right amount of replacements if needed. So to do this, we can have a frequency map
        that has 26 spots because we know it is only uppercase letters. Then we can begin the traversal. Each time a
        character is met, we increase its frequency. Then we check if our condition is met. If it is, then lets try checking for a new 
        max length (res). If it is not met, then lets remove our left starting point, and decrease our window size by moving left one.

    
    
    */
    //O(26 * n)
    public int characterReplacement(String s, int k) {
        int res = 0; //Longest substring without repeating characters
        int[] frequency = new int[26]; //Map that keeps count of occurrences of chars
        
        int left = 0; //left pointer
        for(int right =0;right<s.length(); right++){ //right pointer
            frequency[s.charAt(right) - 'A']++; //increase count of current character
            //right - left is the size of our window, and the + 1 is to account for 0 index
            if(right - left + 1 - maxFrequencyInOurArray(frequency) <= k){ //check our condition
                res = Math.max(res,right - left + 1); // is this current size our biggest
            }
            else{ //condition not met so lets decrease window size
                frequency[s.charAt(left) - 'A']--; //remove left starting point
                left++;//move left pointer forward
            }
        }
        return res;
    }
    
    //O(26)
    //Method to find the highest number in the array
    public int maxFrequencyInOurArray(int[] arr){
        int max = 0;
        for(int num: arr){
            max = Math.max(num,max);
        }
        return max;
    } 
}