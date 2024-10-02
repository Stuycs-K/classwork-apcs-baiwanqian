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
  String twoS = "[";
  for (int i = 0; i < ary.length; i++) {
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
  int sum = 0;
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

//3. Modify a given 2D array of integer as follows:
//Replace all the negative values:
//-When the row number is the same as the column number replace
//that negative with the value 1
//-All other negatives replace with 0
public static void replaceNegative(int[][] vals) {
  for (int i = 0; i < vals.length; i++) {
    for (int n = 0; n < vals[i].length; n++) {
      if (vals[i][n] < 0) {
        if (i == n) {
          vals[i][n] = 1;
        } else {
          vals[i][n] = 0;
        }
      }
    }
  }
}

//4. Make a copy of the given 2d array.
//When testing : make sure that changing the original does NOT change the copy.
//DO NOT use any built in methods that "copy" an array.
//You SHOULD write a helper method for this.
//If you don't see a good way to do that, you should stop and look at prior methods.

//helper function to copy 1D array
public static int[] copy(int[] row) {
  int[] copyRows = new int[row.length];
  for (int i = 0; i < row.length; i++) {
    copyRows[i] = row[i];
  }
  return copyRows;
}

public static int[][] copy(int[][] nums) {
  int[][] copyArr = new int[nums.length][];
    for (int i = 0; i < nums.length; i++) {
      copyArr[i] = copy(nums[i]);
    }
  }
  return copyArr;
}

public static void main(String[] args) {
  //test cases for arrToSTring (2D Array)
  int[][] nums1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  System.out.println("Expected: [[1, 2, 3], [4, 5, 6], [7, 8, 9]] - Output: " + arrToString(nums1));
  int[][] nums2 = {};
  System.out.println("Expected: [] - Output: " + arrToString(nums2));
  int[][] nums3 = {{}, {1, 2, 3}};
  System.out.println("Expected: [[], [1, 2, 3]] - Output: " + arrToString(nums3));
  int[][] nums4 = {{1, 2, 3}, {}};
  System.out.println("Expected: [[1, 2, 3], []] - Output: " + arrToString(nums4));

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
  System.out.println("Expected: [[1, 4], [2, 5], [3, 6]] - Output: " + arrToString(swapRC(swap1)));
  int[][] swap2 = {{1, 2}, {3, 4}, {5, 6}};
  System.out.println("Expected: [[1, 3, 5], [2, 4, 6]] - Output: " + arrToString(swapRC(swap2)));
  int[][] swap3 = {{12}};
  System.out.println("Expected: [[12]] - Output: " + arrToString(swapRC(swap3)));

  // test cases for replaceNegative
  int[][] neg1 = {{-1, -9, 3}, {-4, -2, 6}, {1, 0, -3}};
  replaceNegative(neg1);
  System.out.println("Expected: [[1, 0, 3], [0, 1, 6], [1, 0, 1]] - Output: " + arrToString(neg1));
  int[][] neg2 = {{-1, -9, -3}, {-4, -2, -6}, {-1, -5, -3}};
  replaceNegative(neg2);
  System.out.println("Expected: [[1, 0, 0], [0, 1, 0], [0, 0, 1]] - Output: " + arrToString(neg2));
  int[][] neg3 = {{1, 2}, {3, 4}};
  replaceNegative(neg3);
  System.out.println("Expected: [[1, 2], [3, 4]] - Output: " + arrToString(neg3));
  int[][] neg4 = {{}};
  replaceNegative(neg4);
  System.out.println("Expected: [[]] - Output: " + arrToString(neg4));
  int[][] neg5 = {{}, {-4, -2, 6}, {}};
  replaceNegative(neg5);
  System.out.println("Expected: [[], [0, 1, 6]], []] - Output: " + arrToString(neg5));

  // test cases for copy
  int[][] original1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  int[][] copy1 = copy(original1);
  System.out.println("Original: " + arrToString(original1));
  System.out.println("Copy: " + arrToString(copy1));
  System.out.println("Different address: " + (original1 != copy1));
  original1[0][0] = 100;
  System.out.println("Modified Original: " + arrToString(original1));
  System.out.println("Not Modified Copy: " + arrToString(copy1));
  int[][] original2 = {{}, {4, 5, 6}, {}};
  int[][] copy2 = copy(original2);
  System.out.println("Original: " + arrToString(original2));
  System.out.println("Copy: " + arrToString(copy2));
  System.out.println("Different address: " + (original2 != copy2));
  int[][] original3 = {{}};
  int[][] copy3 = copy(original3);
  System.out.println("Original: " + arrToString(original3));
  System.out.println("Copy: " + arrToString(copy3));
  System.out.println("Different address: " + (original3 != copy3));
  }

}
