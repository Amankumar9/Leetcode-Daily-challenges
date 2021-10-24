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

class Solution {
    //T=O(logn*logn)
    //S=O(logn)
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        int leftHeight=leftHeight(root);
        int rightHeight=rightHeight(root);
        if(leftHeight==rightHeight){
            return (1<<leftHeight)-1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }

    public int leftHeight(TreeNode node){
        if(node==null)return 0;
        int height=0;
        while(node!=null){
            node=node.left;
            ++height;
        }
        return height;
    }

    public int rightHeight(TreeNode node){
        if(node==null)return 0;
        int height=0;
        while(node!=null){
            node=node.right;
            ++height;
        }
        return height;
    }
}