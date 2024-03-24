import java.util.Stack;

class Solution {
  enum Bracket {
    ROUND,
    CURLY,
    SQUARE
  }

  public boolean isValid(String s) {
    Stack<Bracket> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(Bracket.ROUND);
      } else if (c == '{') {
        stack.push(Bracket.CURLY);
      } else if (c == '[') {
        stack.push(Bracket.SQUARE);
      } else if (c == ')') {
        if (stack.isEmpty() || stack.pop() != Bracket.ROUND) {
          return false;
        }
      } else if (c == '}') {
        if (stack.isEmpty() || stack.pop() != Bracket.CURLY) {
          return false;
        }
      } else if (c == ']') {
        if (stack.isEmpty() || stack.pop() != Bracket.SQUARE) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
