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
              printTypingEffect(password);
            }
          } else {
            // part 1
            password[count] = hex.charAt(5);
            count++;
            printTypingEffect(password);
          }
        }
        index++;
      }
    } catch (Exception e) {
      System.out.println("Error: " + e);
    }
    System.out.println();
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

  private static void printTypingEffect(char[] password) {
    System.out.print("\rPassword: ");
    for (int i = 0; i < password.length; i++) {
      if (password[i] == '\0') {
        System.out.print("_");
      } else {
        System.out.print(password[i]);
      }
    }
  }

  public static void main(String[] args) {
    String doorID = "cxdnnyjw";
    System.out.println("\nPart 1:");
    retrievePassword(doorID);
    System.out.println("\nPart 2:");
    retrievePasswordPart2(doorID);
  }

}
