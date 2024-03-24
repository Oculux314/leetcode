public class Main {

  public static void main(String[] args) {
    ListNode head = x(null);
    head.next = x(null);

    System.out.println(new Solution().hasCycle(head));
  }

  private static ListNode x(ListNode n) {
    ListNode newListNode = new ListNode(0);
    newListNode.next = n;
    return newListNode;
  }
}
