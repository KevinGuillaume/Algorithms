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
 *      #226
 *  The idea behind this is to traverse the tree, and each time we get to a level, we want to swap the left and right nodes.
 *  The way can traverse the tree is by using recursion, specifcally depth first search. So each time we go deeper we perform a swap.
 * 
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        
        return root;
    }
    public void dfs(TreeNode root){
        if(root == null) return; //If we reach the bottom of the tree
        
        TreeNode left = root.left; //Save the left to swap
        root.left = root.right; //Swap left to right side
        root.right = left; //Make the right side left
        
        dfs(root.left); //Traverse down the left side (dfs)
        dfs(root.right); //Traverse down the right side (dfs)
        
    }
}