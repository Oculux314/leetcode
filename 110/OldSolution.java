import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class OldSolution {
  Deque<TreeNode> queue = new LinkedList<>();
  Set<TreeNode> visited = new HashSet<>();
  Map<TreeNode, Integer> heights = new HashMap<>();
  int minHeight = -1;
  int maxHeight = -1;

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }

    queue.add(root);
    heights.put(root, 0);
    while (!queue.isEmpty()) {
      TreeNode current = queue.remove();
      if (!visited.contains(current)) {
        visit(current);
        if (maxHeight - minHeight > 1) {
          return false;
        }
      }
    }

    return true;
  }

  private void visit(TreeNode node) {
    visited.add(node);
    int height = heights.get(node);
    if (node.left == null || node.right == null) {
      if (minHeight == -1 || height < minHeight) {
        minHeight = height;
      }
      if (maxHeight == -1 || height > maxHeight) {
        maxHeight = height;
      }
    }

    if (node.left != null) {
      queue.add(node.left);
      heights.put(node.left, height + 1);
    }
    if (node.right != null) {
      queue.add(node.right);
      heights.put(node.right, height + 1);
    }
  }
}
