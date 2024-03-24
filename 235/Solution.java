class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (p == q) {
      return p;
    }

    TreeNode smaller;
    TreeNode bigger;

    if (p.val < q.val) {
      smaller = p;
      bigger = q;
    } else {
      smaller = q;
      bigger = p;
    }

    TreeNode x = root;
    while (true) {
      if (smaller.val <= x.val && x.val <= bigger.val) {
        return x;
      } else if (x.val < smaller.val) {
        x = x.right;
      } else {
        x = x.left;
      }
    }
  }
}
