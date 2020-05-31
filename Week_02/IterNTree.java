import java.util.LinkedList;
import java.util.List;

// Definition for a Node.
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//};


/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class IterNTree {
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new LinkedList<>();
        if (root != null) {
            ret.add(root.val);
            if (root.children != null) {
                root.children.forEach(item -> ret.addAll(preorder(item)));
            }
        }
        return ret;
    }
}
