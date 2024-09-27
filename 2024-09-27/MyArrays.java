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
