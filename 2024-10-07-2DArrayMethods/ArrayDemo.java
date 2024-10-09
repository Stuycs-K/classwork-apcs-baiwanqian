import java.util.Arrays;
public class ArrayDemo{
  public static void main(String[]args){
    //write your tests here!
    //You can now use Arrays.toString(yourArray) instead of writing arrayToString again.
    //Compare Arrays.toString(yourArray) to YOUR arrayToString() method to make sure yours is correct
    //do not use any other Arrays.method()

    // comparison of Arrays.toString() with my arrayToString()
    int[][] str1 = {{1, 0, -3}, {4, 5, 0}, {0, -8, 9}};
    System.out.println("Expected: " + Arrays.deepToString(str1) + " - Output: " + arrToString(str1));
    int[][] str2 = {{0}, {}, {1}};
    System.out.println("Expected: " + Arrays.deepToString(str2) + " - Output: " + arrToString(str2));
    int[][] str3 = {{}};
    System.out.println("Expected: " + Arrays.deepToString(str3) + " - Output: " + arrToString(str3));

    // test cases for countZeros2D
    int[][] zeros1 = {{1, 0, 3}, {4, 5, 0}, {0, 8, 9}};
    System.out.println("Expected: 3 - Output: " + countZeros2D(zeros1));
    int[][] zeros2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println("Expected: 0 - Output: " + countZeros2D(zeros2));
    int[][] zeros3 = {{}, {0}, {}};
    System.out.println("Expected: 1 - Output: " + countZeros2D(zeros3));
    int[][] zeros4 = {{}, {}};
    System.out.println("Expected: 0 - Output: " + countZeros2D(zeros4));

    // test cases for arr2DSum
    int[][] sum1 = {{-1, 0, -3}, {4, -5, 0}, {0, 8, -9}};
    System.out.println("Expected: -6 - Output: " + arr2DSum(sum1));
    int[][] sum2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println("Expected: 45 - Output: " + arr2DSum(sum2));
    int[][] sum3 = {{}, {1}, {}};
    System.out.println("Expected: 1 - Output: " + arr2DSum(sum3));
    int[][] sum4 = {{}, {}};
    System.out.println("Expected: 0 - Output: " + arr2DSum(sum4));

    // test cases for replaceNegative
    int[][] neg1 = {{-1, -9, 3}, {-4, -2, 6}, {1, 0, -3}};
    replaceNegative(neg1);
    System.out.println("Expected: [[1, 0, 3], [0, 1, 6], [1, 0, 1]] - Output: " + Arrays.deepToString(neg1));
    int[][] neg2 = {{-1, -9, -3}, {-4, -2, -6}, {-1, -5, -3}};
    replaceNegative(neg2);
    System.out.println("Expected: [[1, 0, 0], [0, 1, 0], [0, 0, 1]] - Output: " + Arrays.deepToString(neg2));
    int[][] neg3 = {{1, 2}, {3, 4}};
    replaceNegative(neg3);
    System.out.println("Expected: [[1, 2], [3, 4]] - Output: " + Arrays.deepToString(neg3));
    int[][] neg4 = {{}};
    replaceNegative(neg4);
    System.out.println("Expected: [[]] - Output: " + Arrays.deepToString(neg4));
    int[][] neg5 = {{}, {-4, -2, 6}, {}};
    replaceNegative(neg5);
    System.out.println("Expected: [[], [0, 1, 6]], []] - Output: " + Arrays.deepToString(neg5));

    // test cases for copy
    int[][] original1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] copy1 = copy(original1);
    System.out.println("Original: " + Arrays.deepToString(original1));
    System.out.println("Copy: " + Arrays.deepToString(copy1));
    System.out.println("Different address: " + (original1 != copy1));
    original1[0][0] = 100;
    System.out.println("Modified Original: " + Arrays.deepToString(original1));
    System.out.println("Not Modified Copy: " + Arrays.deepToString(copy1));
    int[][] original2 = {{}, {4, 5, 6}, {}};
    int[][] copy2 = copy(original2);
    System.out.println("Original: " + Arrays.deepToString(original2));
    System.out.println("Copy: " + Arrays.deepToString(copy2));
    System.out.println("Different address: " + (original2 != copy2));
    int[][] original3 = {{}};
    int[][] copy3 = copy(original3);
    System.out.println("Original: " + Arrays.deepToString(original3));
    System.out.println("Copy: " + Arrays.deepToString(copy3));
    System.out.println("Different address: " + (original3 != copy3));

    // test cases for swapRC
    int[][] swap1 = {{1, 2, 3}, {4, 5, 6}};
    System.out.println("Expected: [[1, 4], [2, 5], [3, 6]] - Output: " + Arrays.deepToString(swapRC(swap1)));
    int[][] swap2 = {{1, 2}, {3, 4}, {5, 6}};
    System.out.println("Expected: [[1, 3, 5], [2, 4, 6]] - Output: " + Arrays.deepToString(swapRC(swap2)));
    int[][] swap3 = {{12}};
    System.out.println("Expected: [[12]] - Output: " + Arrays.deepToString(swapRC(swap3)));

    // test cases for htmlTable
    int[][] table1 = {{1, 2}, {-5, -6}};
    System.out.println("Expected: <table><tr><td>1</td><td>2</td></tr><tr><td>-5</td><td>-6</td></tr></table> - Output: " + htmlTable(table1));
    int[][] table2 = {{}, {0}};
    System.out.println("Expected: <table><tr></tr><tr><td>0</td></tr></table> - Output: " + htmlTable(table2));
    int[][] table3 = {{}, {}, {}};
    System.out.println("Expected: <table><tr></tr><tr></tr><tr></tr></table> - Output: " + htmlTable(table3));

  }

  //0. Include your prior methods to help you print a 1D/2D array of ints.
  public static String arrToString(int[]ary){
    String aString = "[";
    for (int i=0; i < ary.length && ary.length > 0; i++) {
      aString += ary[i];
      if (i != ary.length -1) {
        aString += ", ";
      }
    }
    return aString + "]";
  }

  //The name of different methods can be the same,
  //as long as the parameters are different! (type and/or quantity must be different)
  //Pro tip: you should be using your 1D arrToString in this method!
  public static String arrToString(int[][]ary){
    String twoS = "[";
    for (int i = 0; i < ary.length; i++) {
      twoS += arrToString(ary[i]);
      if (i != ary.length - 1) {
        twoS += ", ";
      }
    }
    return twoS + "]";
  }

  //1. Calculate and return how many elements equal zero in the 2D array.
  public static int countZeros2D(int[][] nums){
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        if (nums[i][j] == 0) {
          count += 1;
        }
      }
    }
    return count;
  }

  //2. Calculate the sum of a 2d array
  /*Return the sum of all of the values in the 2D array
   *Use a nested loop instead of a helper method*/
  public static int arr2DSum(int[][]nums){
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        sum += nums[i][j];
      }
    }
    return sum;
  }

  //3. Modify a given 2D array of integer as follows:
  //Replace all the negative values:
  //-When the row number is the same as the column number replace
  //that negative with the value 1
  //-All other negatives replace with 0
  public static void replaceNegative(int[][] vals){
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
    return copyArr;
  }

  //5. Rotate an array by returning a new array with the rows and columns swapped.
  //   You may assume the array is rectangular and neither rows nor cols is 0.
  //   e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
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

  //6. Make an HTML table by putting a table tag around the entire 2d array,
  //   tr tags around each row, and td tags around each value.
  //   You may use a helper method
  //   Note there is no whitespace in the string, it all one line with no spaces/tabs.
  //   e.g. htmlTable(new int[][]{{1,2},{3}})  returns:
  // "<table><tr><td>1</td><td>2</td></tr><tr><td>3</td></tr></table>"
  public static String htmlTable(int[] nums) {
    String row = "<tr>";
    for (int i = 0; i < nums.length; i ++) {
      row += "<td>" + nums[i] + "</td>";
    }
    return row + "</tr>";
  }

  public static String htmlTable(int[][]nums) {
    String table = "<table>";
    for (int i = 0; i < nums.length; i++) {
      table += htmlTable(nums[i]);
      }
    return table + "</table>";
  }

}
