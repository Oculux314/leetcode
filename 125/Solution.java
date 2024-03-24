import java.util.ArrayList;
import java.util.List;

public class Solution {

  public boolean isPalindrome(String s) {
    List<Character> filtered = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z')) {
        filtered.add(c);
      } else if ('A' <= c && c <= 'Z') {
        filtered.add((char) (c + ('a' - 'A')));
      }
    }

    for (int i = 0; i < filtered.size() / 2; i++) {
      if (filtered.get(i) != filtered.get(filtered.size() - 1 - i)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
  }
}
