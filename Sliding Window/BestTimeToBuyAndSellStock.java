class Solution {
    /*
                    #121
     * Sliding window problem because you are going to be adjusting the size of your search each time
     * if a condition is not met. The condition that makes sense based on the problem is understaning that
     * the most profit comes from finding the smallest value, and subtracting it from the biggest value. With this idea
     * in mind, the first step is two have two variables, a max and a min for this. Then iterate through the array
     * and at each iteration, check if we have a value smaller than our min, if not, that means we have potential for
     * a profit, so we check that and compare it also. Then we can set our profit equal to the larger value.
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0; //Max profit
        int min = prices[0]; //Set our min to our first value
         
        for(int i=1;i< prices.length; i++){ //iterate through array
            if(prices[i] <= min) { //Check if the current value is smaller than our min
                min = prices[i]; //If it is smaller, then we have a new starting point for our window
            }
            else{ //if it is not smaller, then we have potential for profit.
                maxProfit = Math.max(prices[i]-min,maxProfit); //Compare current profit with our max profit
            } 
        }
        
        return maxProfit;
    
    
    }
    
    
}