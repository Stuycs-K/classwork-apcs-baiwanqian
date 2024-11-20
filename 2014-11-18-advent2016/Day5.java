import java.security.*;

public class Day5 {
  // very very slow :(

  private static String computePassword(String doorID, boolean positional) {
    char[] password = new char[8];
    boolean[] positionFull = new boolean[8];
    int index = 0, count = 0;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      while (count < 8) {
        byte[] array = md.digest((doorID + index).getBytes("UTF-8"));
        String hex = bytesToHex(array);
        if (hex.substring(0, 5).equals("00000")) {
          if (positional) {
            // part 2
            int position = hex.charAt(5) - '0';
            if (position >= 0 && position < 8 && !positionFull[position]) {
              password[position] = hex.charAt(6);
              positionFull[position] = true;
              count++;
            }
          } else {
            // part 1
            password[count] = hex.charAt(5);
            count++;
          }
        }
        index++;
      }
    } catch (Exception e) {
      System.out.println("Error: " + e);
    }
    return new String(password);
  }

  public static String retrievePassword(String doorID) {
    return computePassword(doorID, false);
  }

  public static String retrievePasswordPart2(String doorID) {
    return computePassword(doorID, true);
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
    String doorID = "cxdnnyjw";
    System.out.println(retrievePassword(doorID));
    System.out.println(retrievePasswordPart2(doorID));
  }

}
