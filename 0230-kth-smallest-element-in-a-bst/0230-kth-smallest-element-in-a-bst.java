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

    public int countNode(TreeNode root){
        if (root==null) {
            return 0;
        }
        int left = countNode(root.left);
        int right = countNode(root.right);
        return 1+left+right;
    }
    public int findTheNumber(TreeNode root,int k){
        int leftCount = countNode(root.left);
        if (k==leftCount+1) {
            return root.val;
        }
        if (k<=leftCount) {
            return findTheNumber(root.left, k);
        }
        return findTheNumber(root.right, k - leftCount - 1);
    }
    public int kthSmallest(TreeNode root, int k) {
        return findTheNumber(root, k);
    }
}