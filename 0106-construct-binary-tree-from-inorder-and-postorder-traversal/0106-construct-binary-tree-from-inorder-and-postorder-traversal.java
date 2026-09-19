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
    public TreeNode buiTreeNode(int[] inorder, int[] postorder, int inStart,int inEnd,int postStart,int postEnd){
        if (postStart>postEnd) {
            return null;  
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index=0;
        for(int i=inStart;i<=inEnd;i++){
            if (inorder[i]==postorder[postEnd]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = buiTreeNode(inorder, postorder, inStart, index-1, postStart, postStart+leftSize-1);
        root.right = buiTreeNode(inorder, postorder, index+1, inEnd, postStart+leftSize, postEnd-1);
        return  root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buiTreeNode(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
}