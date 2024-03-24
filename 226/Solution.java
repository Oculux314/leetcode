import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution {

  Deque<TreeNode> dq = new LinkedList<>();
  Set<TreeNode> visited = new HashSet<>();

  public TreeNode invertTree(TreeNode root) {
    search(root);
    return root;
  }

  private void search(TreeNode root) {
    dq.push(root);
    while (!dq.isEmpty()) {
      TreeNode current = dq.pop();
      if (!visited.contains(current)) {
        visit(current);
      }
    }
  }

  private void visit(TreeNode node) {
    if (node == null) {
      return;
    }

    visited.add(node);
    dq.push(node.right);
    dq.push(node.left);

    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;
  }
}
