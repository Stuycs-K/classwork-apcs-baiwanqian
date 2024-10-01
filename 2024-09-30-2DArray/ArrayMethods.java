// Names: Jessie Chan (jessiec39@nycstudents.net) and Christine Chen (christinec109@nycstudents.net)
public class ArrayMethods{

  public static String arrToString(int[] nums){
  String s = "";
  for (int i = 0; i < nums.length; i++) {
    s = s + nums[i];
    if (i != nums.length -1) {
      s += ", ";
    }
  }
  s = "[" + s + "]";
  return s;
  }

  //3. Write arrToString, with a 2D array parameter.
//Note: Different parameters are allowed with the same function name.
/**Return a String that represets the 2D array in the format:
  * "[[2, 3, 4], [5, 6, 7], [2, 4, 9]]"
  * Note the comma+space between values, and between arrays
  * You are encouraged to notice that you may want to re-use
  * previous code, but you should NOT duplicate that code. (Don't copy/paste or retype it)
  */

public static String arrToString(int[][]ary){
  //this should use arrToString(int[])
  String twoS = "["
  for (int i = 0; i < ary.length && ary.length > 0; i++) {
    twoS += arrToString(ary[i]);
    if (i != ary.length - 1) {
      twoS += ", ";
    }
  }
  return twoS + "]";
}

/*Return the sum of all of the values in the 2D array */
public static int arr2DSum(int[][]nums){
  //use a nested loop to solve this
  int sum = 0
  for (int i = 0; i < nums.length; i++) {
    for (int n = 0; n < nums[i].length; n++) {
      sum += nums[i][n];
    }
  }
  return sum;
}

/**Rotate an array by returning a new array with the rows and columns swapped.
  * You may assume the array is rectangular and neither rows nor cols is 0.
  * e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
  */
public static int[][] swapRC(int[][]nums){
  int rows = nums.length;
  int cols = nums[0].length;
  int[][] swapped = new int[cols][rows];
  for (int i = 0; i < rows; i++) {
    for (int n = 0; n < cols; n++) {
      swapped[n][i] = nums[i][n];
    }
  }
  return swapped;
}

public static void main(String[] args) {

  //test cases for arrToSTring (2D Array)
  int[][] nums1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  System.out.println("Expected: [[1, 2, 3], [4, 5, 6]], [7, 8, 9]] - Output: " + arrToString(nums1));
  int[][] nums2 = {};
  System.out.println("Expected: [] - Output: " + arrToString(nums2));
  int[][] nums3 = {{}, {1, 2, 3}};
  System.out.println("Expected: [[], [1, 2, 3]] - Output: " + arrToString(nums3));
  int[][] nums4 = {{1, 2, 3}, {}};
  System.out.println("Expected: [[], [1, 2, 3]] - Output: " + arrToString(nums4));

  // test cases for arr2DSum
  int[][] sums1 = {{1, 2, 3}, {4, 5, 6}};
  System.out.println("Expected: 21 - Output: " + arr2DSum(sums1));
  int[][] sums2 = {{7, 8, 9}};
  System.out.println("Expected: 24 - Output: " + arr2DSum(sums2));
  int[][] sums3 = {{0, 0, 0}, {0, 0, 0}};
  System.out.println("Expected: 0 - Output: " + arr2DSum(sums3));
  int[][] sums4 = {};
  System.out.println("Expected: 0 - Output: " + arr2DSum(sums4));
  int[][] sums5 = {{}, {}};
  System.out.println("Expected: 0 - Output: " + arr2DSum(sums5));

  // test cases for swapRC
  int[][] swap1 = {{1, 2, 3}, {4, 5, 6}};
  System.out.println("Expected: {{1, 4}, {2, 5}, {3, 6}} - Output: " + arrToString(swapRC(swap1)));
  int[][] swap2 = {{1, 2}, {3, 4}, {5, 6}};
  System.out.println("Expected: {{1, 3, 5}, {2, 4, 6}} - Output: " + arrToString(swapRC(swap2)));
  int[][] swap3 = {{12}};
  System.out.println("Expected: {{12}}, Output: " + arrToString(swapRC(swap3)));

  }
}
