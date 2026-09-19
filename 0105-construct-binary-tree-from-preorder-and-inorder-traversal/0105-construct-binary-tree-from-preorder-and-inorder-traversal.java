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
    public TreeNode buildTree(int[] preorder, int[] inorder,
                            int preStart,int preEnd,
                            int inStart,int inEnd){
        if (preStart>preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i=inStart;i<=inEnd;i++){
            if (inorder[i]==preorder[preStart]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        root.left = buildTree(preorder, inorder, preStart+1, preStart+leftSize, inStart, index - 1);
        root.right = buildTree(preorder, inorder, preStart+leftSize+1 , preEnd, index+1, inEnd);
        return  root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}