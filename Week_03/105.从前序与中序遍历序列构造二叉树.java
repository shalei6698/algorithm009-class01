import java.util.HashMap;
import java.util.Map;

import sun.security.util.Length;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 
 */

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return getTree(preorder, inorder, 0, 0, preorder.length, inMap);
    }

    TreeNode getTree(int[] preorder, int[] inorder, int preStart, int inStart, int length, Map<Integer, Integer> inMap) {
        // terminater 
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(preorder[preStart]);
        }

        // process
        TreeNode root = new TreeNode(preorder[preStart]);
        Integer inRootIdx = inMap.get(root.val);
        int leftLength = inRootIdx - inStart;
        int rightLength = length - leftLength - 1;

        // drill down
        root.left = getTree(preorder, inorder, preStart + 1, inStart, leftLength, inMap);
        root.right = getTree(preorder, inorder, preStart + leftLength + 1, inRootIdx + 1, length - leftLength - 1, inMap);

        return root;
    }
}
// @lc code=end

