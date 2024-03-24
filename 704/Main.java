import java.util.Date;

public class Main {

  public static void main(String[] args) {
    int[] nums = {-1,0,3,5,9,12};
    int res = new Solution().search(nums, 9);
    System.out.println(res);
    System.out.println("Test completed at: " + new Date());
  }
}
