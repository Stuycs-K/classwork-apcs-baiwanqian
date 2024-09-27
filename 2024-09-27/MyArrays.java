public class MyArrays {
public static String aryToString(int[] nums) {
  String aString = "[";
  for (int i=0; i < nums.length && nums.length > 0; i++) {
    aString += nums[i];
    if (i != nums.length -1) {
      aString += ", ";
    }
  }
  return aString + "]";
}

  public static void main(String[] args)
// test cases for returnCopy
System.out.println()
