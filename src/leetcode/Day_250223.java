package leetcode;

public class Day_250223 {
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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            int n = preorder.length;
            int preIndex = 0;
            int postIndex = 0;

            return constructTree(preorder, postorder, n-1, preIndex, postIndex);
        }

        private TreeNode constructTree(int[] preorder, int[] postorder, int n, int preIndex, int postIndex) {
            if (preIndex > n) return null;

            if (preIndex == n) {
                return new TreeNode(preorder[preIndex]);
            }

            int count = 1;
            while(postorder[postIndex + count - 1] != preorder[preIndex + 1]) {
                count++;
            }

            TreeNode node = new TreeNode(preorder[preIndex]);
            node.left = constructTree(preorder, postorder, preIndex + count, preIndex + 1, postIndex);
            node.right = constructTree(preorder, postorder, n, preIndex + count + 1, postIndex + count);

            return node;
        }
    }
}
