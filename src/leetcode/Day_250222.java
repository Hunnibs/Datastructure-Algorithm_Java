package leetcode;

public class Day_250222 {
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
        int idx = 0;

        public TreeNode recoverFromPreorder(String traversal) {
            return dfs(traversal, 0);
        }

        private TreeNode dfs(String traversal, int depth) {
            if (idx >= traversal.length()) return null;

            int cnt = 0;
            while(idx + cnt < traversal.length() && traversal.charAt(idx + cnt) == '-') {
                cnt++;
            }

            if (cnt != depth) return null;
            idx += cnt;

            int value = 0;
            while(idx < traversal.length() && Character.isDigit(traversal.charAt(idx))) {
                value = value * 10 + (traversal.charAt(idx++) - '0');
            }

            TreeNode node = new TreeNode(value);

            node.left = dfs(traversal, depth + 1);
            node.right = dfs(traversal, depth + 1);

            return node;
        }
    }
}
