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
    public TreeNode buiTreeNode(int[] preorder, int[] postorder, int preStart,int preEnd,int postStart,int postEnd){
        if (preStart>preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int child = preorder[preStart+1];
        int index = 0;
        for(int i=postStart;i<=postEnd;i++){
            if (child==postorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - postStart + 1;
        root.left = buiTreeNode(preorder, postorder, preStart+1, preStart+leftSize, postStart, index);
        root.right = buiTreeNode(preorder, postorder, preStart+leftSize+1, preEnd, index+1, postEnd-1);
        return  root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return buiTreeNode(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
    }
}