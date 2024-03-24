public class Main {

  public static void main(String[] args) {
    // TreeNode root = t(1,t(2,t(3,t(4,null,null),t(4,null,null)),t(3,null,null)),t(2,null,null));
    // TreeNode root = t(1, null, t(2, null, t(3, null, null)));
    TreeNode root =
        t(1, t(2, t(4, t(8, null, null), null), t(5, null, null)), t(3, t(6, null, null), null));

    System.out.println(new Solution().isBalanced(root));
  }

  private static TreeNode t(int v, TreeNode l, TreeNode r) {
    return new TreeNode(v, l, r);
  }
}
