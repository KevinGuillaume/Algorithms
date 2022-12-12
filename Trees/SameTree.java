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
 *               #100
 *  The solution here is to traverse two trees at the same time. This way it 
 *  will let us compare each node that should be corresponding on each tree if they
 *  are the same. But if there is not an equality, then we know it is not the same tree.
 *  So we can use a Depth First Search at the same time. Then during each recursive call, 
 *  we can check if each node is equal or not.
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }

    public boolean dfs(TreeNode p, TreeNode q){
        //What are all the possibilities for base cases?
        //Both values are null which means they are equal
        //One value is null and other is not null
        if(p == null && q == null) return true; //Equal
        if(p == null || q == null) return false; //Not equal

        //If values are not the same
        if(p.val != q.val) return false;
        
        return dfs(p.left,q.left) && dfs(p.right,q.right); //Recursive Call
    }
}