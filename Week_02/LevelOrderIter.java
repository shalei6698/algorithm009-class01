import java.util.LinkedList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

/**
 * 429. N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class LevelOrderIter {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new LinkedList<>();
        iter(root, 0, ret);
        return ret;
    }

    public void iter(Node node, int currentLevel, List<List<Integer>> data) {
        if (node == null) {
            return;
        }
        if (data.size() - 1 < currentLevel) {
            List<Integer> newList = new LinkedList<>();
            newList.add(node.val);
            data.add(newList);
        } else {
            data.get(currentLevel).add(node.val);
        }
        if (node.children != null) {
            node.children.forEach(item -> {
                iter(item, currentLevel + 1, data);
            });
        }
    }

}
