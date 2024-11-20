import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {

  public static int encryptedRoomName(String filename) {
    int sum = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        String encrypted = input.nextLine();
        int lastDashIndex = encrypted.lastIndexOf("-");
        int firstBracketIndex = encrypted.indexOf("[");
        String name = encrypted.substring(0, lastDashIndex).replace("-", "");
        int sectorID = Integer.parseInt(encrypted.substring(lastDashIndex + 1, firstBracketIndex));
        String checksum = encrypted.substring(firstBracketIndex + 1, encrypted.length() - 1);

        if (checksum.equals(realCheckSum(name))) {
          sum += sectorID;
          if (decryptName(name, sectorID).contains("north")) {
            System.out.println("north pole objects " + sectorID);
          }
        }
      }

      input.close();
      } catch (FileNotFoundException ex) {
        System.out.println("File not found");
      }
      return sum;
    }

  public static String realCheckSum(String name) {
    int[] frequency = new int[26];
    for (int i = 0; i < name.length(); i++) {
      char c = name.charAt(i);
      if (c >= 'a' && c <= 'z') {
        frequency[c - 'a']++;
      }
    }
    char[] checksum = new char[5];
    for (int i = 0; i < 5; i++) {
      int maxIndex = -1;
      int maxCount = -1;
      for (int j = 0; j < 26; j++) {
        if (frequency[j] > maxCount ||
          (frequency[j] == maxCount && (maxIndex == -1 || j < maxIndex))) {
            maxCount = frequency[j];
            maxIndex = j;
          }
        }
        if (maxIndex != -1) {
          checksum[i] = (char)(maxIndex + 'a');
          frequency[maxIndex] = -1;
        }
      }
      return new String(checksum);
    }

  public static String decryptName(String name, int sectorID) {
    String decryptedName = " ";
    for (int i = 0; i < name.length(); i++) {
      char c = name.charAt(i);
      if (c < 'a' || c > 'z') {
        decryptedName += "";
      } else {
        char shifted = (char)((c - 'a' + sectorID) % 26 + 'a');
        decryptedName += shifted;
      }
    }
    return decryptedName;
  }

  public static void main(String[] args) {
    System.out.println(encryptedRoomName("Day4Input.txt"));
  }

}
