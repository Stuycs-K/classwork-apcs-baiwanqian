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
  return "";
}

/*Return the sum of all of the values in the 2D array */
public static int arr2DSum(int[][]nums){
  //use a nested loop to solve this
}

/**Rotate an array by returning a new array with the rows and columns swapped.
  * You may assume the array is rectangular and neither rows nor cols is 0.
  * e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
  */

public static int[][] swapRC(int[][]nums){
  return new int[1][1];
}

public static void main(String[] args) {

  //test cases for arrToSTring (2D Array)
  System.out.println("Expected: [[2, 3, 4], [5, 6, 7], [2, 4, 9]]. output: " + arrToString(new int[][] {{2, 3, 4}, {5, 6, 7}, {2, 4, 9}});
  System.out.println("Expected: [[], [5, 6], [2, 4, 9]]. output: " + arrToString(new int[][] {{}, {5, 6}, {2, 4, 9}});
  }

}
