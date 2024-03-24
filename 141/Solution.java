public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }

    int period = 1;
    int elapsed = 0;
    ListNode fixedNode = head;
    ListNode x = head;
    while (x.next != null) {
      if (x.next == fixedNode) {
        return true;
      }
      if (elapsed >= period) {
        elapsed = 0;
        period *= 2;
        fixedNode = x;
      }
      elapsed++;
      x = x.next;
    }

    return false;
  }
}
