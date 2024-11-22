import java.security.*;

public class Day14 {

  public static int keyIndex(String salt, boolean part2) {
    int index = 0;
    int keyCount = 0;
    while (keyCount < 64) {
      String hash;
      if (part2) {
        hash = findStretchedHash(salt + index);
      } else {
        hash = md5(salt + index);
      }
      char triplet = findTriplet(hash);
      if (triplet != '\u0000') {
        if (hasQuintuplet(salt, index, triplet, part2)) {
          keyCount++;
        }
      }
      index++;
    }
    return index - 1;
  }

  public static char findTriplet(String hash) {
    for (int i = 0; i < hash.length() - 2; i++) {
      if (hash.charAt(i) == hash.charAt(i+1) && hash.charAt(i+1) == hash.charAt(i+2)) {
        return hash.charAt(i);
      }
    }
    return '\u0000';
  }

  public static boolean hasQuintuplet(String salt, int index, char triplet, boolean part2) {
    for (int i = index + 1; i <= index + 1000; i++) {
      String hash;
      if (part2) {
        hash = findStretchedHash(salt + i);
      } else {
        hash = md5(salt + i);
      }
      for (int j = 0; j < hash.length() - 4; j++) {
        if (hash.charAt(j) == triplet && hash.charAt(j + 1) == triplet &&
            hash.charAt(j + 2) == triplet && hash.charAt(j + 3) == triplet &&
            hash.charAt(j + 4) == triplet) {
          return true;
        }
      }
    }
    return false;
  }

  public static String findStretchedHash(String hash) {
    for (int i = 0; i < 2016; i++) {
      hash = md5(hash);
    }
    return hash;
  }

  public static String md5(String input) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] hash = md.digest(input.getBytes("UTF-8"));
      return bytesToHex(hash);
    } catch (Exception e) {
      System.out.println("Error: " + e);
      return null;
    }
  }

  public static String bytesToHex(byte[] bytes) {
    String hexString = "0123456789abcdef";
    String hexResult = "";
    for (int i = 0; i < bytes.length; i++) {
      // convert to unsigned byte (between 0 to 255 instead of -128 to 127)
      int unsignedByte;
      if (bytes[i] < 0) {
        unsignedByte = bytes[i] + 256;
      } else {
        unsignedByte = bytes[i];
      }
      // upper 4 bits
      int upper = unsignedByte / 16;
      // lower 4 bits
      int lower = unsignedByte % 16;
      hexResult += hexString.charAt(upper);
      hexResult += hexString.charAt(lower);
    }
    return hexResult;
  }

  public static void main(String[] args) {
    String salt = "yjdafjpo";
    System.out.println("64th key index: " + keyIndex(salt, false));
    System.out.println("64th key index + stretched hash: " + keyIndex(salt, true));
  }

}
