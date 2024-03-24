class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] countS = new int[26];
    int[] countT = new int[26];
    count(countS, s);
    count(countT, t);
    
    for (int i = 0; i < 26; i++) {
      if (countS[i] != countT[i]) {
        return false;
      }
    }

    return true;
  }

  private void count(int[] countArray, String str) {
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int arrayIndex = (int) (c - 'a');
      countArray[arrayIndex]++;
    }
  }
}