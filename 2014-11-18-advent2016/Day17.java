import java.security.*;
import java.util.ArrayList;

public class Day17 {

  public static String findShortestPath(String passcode) {
    String shortestPath = null;
    String[] directions = {"U", "D", "L", "R"};
    int[] xChange = {-1, 1, 0, 0}; // position offset in row when moving
    int[] yChange = {0, 0, -1, 1}; // position offset in column when moving
    ArrayList<int[]> positions = new ArrayList<int[]>();
    ArrayList<String> paths = new ArrayList<String>();
    // starting point (0,0)
    positions.add(new int[]{0,0});
    paths.add("");
    // while there are remaining new paths
    while (paths.size() > 0) {
      int[] position = positions.remove(0);
      String path = paths.remove(0);
      int x = position[0];
      int y = position[1];
      if (x == 3 && y == 3) {
        if (shortestPath == null || path.length() < shortestPath.length()) {
          shortestPath = path;
        }
      } else {
        String hash = md5(passcode + path).substring(0,4);
        for (int i = 0; i < 4; i++) {
          char doorStatus = hash.charAt(i);
          // check if door is open (b-f)
          if (doorStatus >= 'b' && doorStatus <= 'f') {
            int newX = x + xChange[i];
            int newY = y + yChange[i];
            // check if position is on grid
            if (newX >= 0 && newX < 4 && newY >= 0 && newY < 4) {
              positions.add(new int[]{newX, newY});
              paths.add(path + directions[i]);
            }
          }
        }
      }
    }
    return shortestPath;
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
    String passcode = "ioramepc";
    System.out.println(findShortestPath(passcode));
  }

}
