class Solution {
    /*
                    #11
        To solve this, two pointers are going to be used as well as a max variable. One pointer in the
        front and one at the end. While the two pointers are less than each other (left < right),
        at each iteration you check if we have the max amount of water by looking at the difference
        between left and right, and multiplying it by the min height of both sides. Then to try and 
        maximize our water, we can look at which of the two heights is larger, and move the smaller
        one left/right. If they are equal, then we can just increase left and decrease right.
    */

public int maxArea(int[] height) {
    int left = 0, right = height.length -1, max = 0; //initialize our pointers and max variables
    
    while(left < right){ 
        int area = (right - left) * Math.min(height[left],height[right]); //Calculate the current area we have
        max = Math.max(area,max); //Check if it has a larger area than the current max
        if(height[left] < height[right]){ //if the left side is smaller
            left++; //Move left 
        }
        else if(height[left] > height[right]){ //if the left side is bigger
            right--; //Move right
        }
        else{ //If they are equal, lets check a new range
            left++; //Move left one
            right--; //Move right one
        }
    }
    return max;
}
}