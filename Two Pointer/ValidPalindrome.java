class Solution {
    /*
                    # 125
     * Solution:
     * First check if we havea length of 1, bc that is considered a palindrome
     * Then create our left + right pointers. These two will traverse our array
     * We start the left at the beginning and right at the end and increase/decrease each iteration
     * while these two are not equal, check if the values at their index are equal. If not, we know it is not a palindrome
     */
    public boolean isPalindrome(String s) {
        if(s.length() == 1) return true; //If it's one letter only return it once
        String str = s.replaceAll("[^A-Za-z0-9]","");
        str = str.toLowerCase();
        int l = 0, r = str.length()-1; //Our two pointers
        while(l <= r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++; //Increase/Decrease our pointers each iteration
            r--;
        }
        return true; //Mean we never returned false so it must be a palindrome

    }
}