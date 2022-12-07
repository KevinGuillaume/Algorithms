/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*
 *      #104
 *  For this, we know trees involve a lot of traversing, so we are going to use a depth first search.
 *  The idea behind this solution is recognizing that we want to be able to count how many times we have gone downwards.
 *  So to do this we can use a DFS and each time we traverse, we add 1 to our recursive call. This way, each time we 
 *  increase. But if we soley increases during each of the recursive call, we would sometimes end up with a number much greater than the actual
 *  max depth. So to account for this we know we only want to count the branch with the largest depth. So how do we compare two numbers
 *  and see which is bigger? We can use Math.Max() to compare each branch and see which is deeper. Then we add 1 to the bigger branch.
 *  By doing this it lets us increase the total number rather than adding every branches number.
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root); //Call our dfs
    }
    public int dfs(TreeNode root){
        if(root == null) return 0; //Base case -> if we reach the end we return nothing
        
        return Math.max(dfs(root.left),dfs(root.right)) + 1; //Here we return the max of the left or right branch and add to it
    }
}