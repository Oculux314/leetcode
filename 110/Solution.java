// class Solution {
//   public boolean isBalanced(TreeNode root) {
//     try {
//       getHeight(root);
//     } catch (RuntimeException e) {
//       return false;
//     }
//     return true;
//   }

//   private int getHeight(TreeNode node) {
//     if (node == null) {
//       return 0;
//     }

//     int leftHeight = getHeight(node.left);
//     int rightHeight = getHeight(node.right);
//     if (Math.absExact(rightHeight - leftHeight) > 1) {
//       throw new RuntimeException("Height differ by more than 1");
//     }
//     return Math.max(leftHeight, rightHeight) + 1;
//   }
// }

class Solution {
  public boolean isBalanced(TreeNode root) {
    if (getHeight(root) == -1) return false;
    return true;
  }

  private int getHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }

    int leftHeight = getHeight(node.left);
    int rightHeight = getHeight(node.right);
    if (leftHeight == -1 || rightHeight == -1 || Math.absExact(rightHeight - leftHeight) > 1) {
      return -1;
    }
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
