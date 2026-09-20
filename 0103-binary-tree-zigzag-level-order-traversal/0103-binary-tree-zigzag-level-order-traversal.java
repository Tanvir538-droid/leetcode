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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mainResult = new ArrayList<>();
        // List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return mainResult;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean trueChecker = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                    if (node.left!=null) {
                        queue.offer(node.left);
                    }
                    if (node.right!=null) {
                        queue.offer(node.right);
                    }
                    
            }
            if (trueChecker==true) {
                Collections.reverse(level);
            }
            mainResult.add(level);
            trueChecker=!trueChecker;
            // Collections.reverse(result);
        }
        return mainResult;
    }
}