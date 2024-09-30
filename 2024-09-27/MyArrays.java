public class MyArrays {

  public static String arrayToString(int[] nums) {
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
    int[] copy = new int[ary.length];
    for (int i = 0; i < ary.length; i++) {
      copy[i] = ary[i];
    }
    return copy;
  }

  public static int[] concatArray(int[] ary1, int[] ary2) {
    int[] concatenated = new int[ary1.length + ary2.length];
    for (int i = 0; i < ary1.length; i++) {
      concatenated[i] = ary1[i];
    }
    for (int i = 0; i < ary2.length; i++) {
      concatenated[ary1.length + i] = ary2[i];
    }
    return concatenated;
  }

  public static void main(String[] args) {

  // test cases for returnCopy
    int[] original = {1, 2, 3, 4, 5};
    int[] copy = returnCopy(original);
    System.out.println("Original: " + arrayToString(original));
    System.out.println("Copy: " + arrayToString(copy));
    System.out.println("Different address: " + (original != copy));

    int[] original1 = {};
    int[] copy1 = returnCopy(original1);
    System.out.println("Original: " + arrayToString(original1));
    System.out.println("Copy: " + arrayToString(copy1));
    System.out.println("Different address: " + (original1 != copy1));

    int[] original2 = {1};
    int[] copy2 = returnCopy(original2);
    System.out.println("Original: " + arrayToString(original2));
    System.out.println("Copy: " + arrayToString(copy2));
    System.out.println("Different address: " + (original2 != copy2));

  // test cases for concatArray
    int[] ary1 = {1, 2, 3};
    int[] ary2 = {4, 5, 6};
    int[] concatenated1 = concatArray(ary1, ary2);
    System.out.println("Concatenated Arrays: " + arrayToString(concatenated1));

    int[] ary3 = {};
    int[] concatenated2 = concatArray(ary1, ary3);
    System.out.println("Concatenated Arrays: " + arrayToString(concatenated2));

    int[] ary4 = {};
    int[] concatenated3 = concatArray(ary3, ary4);
    System.out.println("Concatenated Arrays: " + arrayToString(concatenated3));

  }
}
