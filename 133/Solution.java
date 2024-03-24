import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
  Deque<Node> dq = new LinkedList<>();
  Map<Node, Node> map = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    dq.push(node);
    while (!dq.isEmpty()) {
      Node current = dq.pop();
      if (!visited(current)) {
        visit(current);
      }
    }

    return map.get(node);
  }

  private void visit(Node current) {
    Node clonedNode = new Node(current.val);
    map.put(current, clonedNode);

    for (Node neighbour : current.neighbors) {
      if (visited(neighbour)) {
        Node clonedNeighbour = map.get(neighbour);
        clonedNode.neighbors.add(clonedNeighbour);
        clonedNeighbour.neighbors.add(clonedNode);
      } else {
        dq.push(neighbour);
      }
    }
  }

  private boolean visited(Node current) {
    return map.containsKey(current);
  }
}
