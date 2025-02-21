package leetcode;

import java.util.*;

public class Day_250221 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class FindElements {
        List<Integer> tree = new ArrayList<>();

        public FindElements(TreeNode root) {
            dfs(0, root);
        }

        public boolean find(int target) {
            if (tree.contains(target)) return true;
            else return false;
        }

        public void dfs(int cur, TreeNode root) {
            if (root == null) return;

            tree.add(cur);
            dfs(cur * 2 + 1, root.left);
            dfs(cur * 2 + 2, root.right);
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
}
