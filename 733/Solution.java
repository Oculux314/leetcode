import java.util.Deque;
import java.util.LinkedList;

class Solution {
  private class Pixel {
    int row;
    int col;
    int color;

    public Pixel(int row, int col, int color) {
      this.row = row;
      this.col = col;
      this.color = color;
    }

    @Override
    public boolean equals(Object other) {
      if (other == null || !(other instanceof Pixel)) {
        return false;
      }

      Pixel otherPix = (Pixel) other;
      if (this.row == otherPix.row && this.col == otherPix.col) {
        return true;
      }

      return false;
    }

    public void visit(int newColour) {
      visited[row][col] = true;
      image[row][col] = newColour;
      checkAndQueue(row + 1, col, color);
      checkAndQueue(row, col + 1, color);
      checkAndQueue(row - 1, col, color);
      checkAndQueue(row, col - 1, color);
    }
  }

  private Deque<Pixel> queue = new LinkedList<>();
  int[][] image;
  boolean[][] visited;

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    this.image = image;
    this.visited = new boolean[image.length][image[0].length];
    queue.add(new Pixel(sr, sc, getColor(sr, sc)));
    while (!queue.isEmpty()) {
      Pixel current = queue.remove();
      if (!visited[current.row][current.col]) {
        current.visit(color);
      }
    }

    return image;
  }

  public void checkAndQueue(int row, int col, int color) {
    try {
      if (getColor(row, col) == color && !visited[row][col]) {
        queue.add(new Pixel(row, col, color));
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      // Edge of board: do nothing
    }
  }

  public int getColor(int row, int col) {
    return image[row][col];
  }
}
