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

  public static int[] returnCopy(int[] ary) {
  }

  public static int[] concatArray(int[] ary1, int[] ary2) {
  }

  public static void main(String[] args) {

  // test cases for returnCopy
    int[] original = {1, 2, 3, 4, 5};
    int[] copy = returnCopy(original);
    System.out.println("returnCopy - Original: " + aryToString(original));
    System.out.println("returnCopy - Copy: " + aryToString(copy));
    System.out.println("returnCopy - Different address: " + (original != copy));

    int[] original = {};
    int[] copy = returnCopy(original);
    System.out.println("returnCopy - Original: " + aryToString(original));
    System.out.println("returnCopy - Copy: " + aryToString(copy));
    System.out.println("returnCopy - Different address: " + (original != copy));

  }
