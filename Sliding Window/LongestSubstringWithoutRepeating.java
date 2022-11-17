class Solution {
    /*

            #3
        Iterate through the list and have a left pointer which which we call 'left'
        and also have a right pointer which is our 'i' variable in the loop
        we continuousl expand the window whenever we get something new, but if 
        the current letter is seen already, then that means we need to shorten our window and start again.

    
    */
    
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>(); //Set to check for duplicates
        int longest = 1; //Ans for longest substring
        int left = 0; //Left pointer
        set.add(s.charAt(left)); //add first value
        
        for(int right=1;right<s.length();right++){
            if(set.contains(s.charAt(right))){ //Check if we have this value in our set
                right--; //This keeps right pointer in place
                set.remove(s.charAt(left)); //removes the left most value
                left++; //Decreases the size of our window
            }
            else{ //if we don't have it, add to the set and check with longest
                set.add(s.charAt(right)); //Continue moving right
            }
            longest = Math.max(longest, set.size()); //Check for max
            
        }
        
        return longest;
        
    }
}