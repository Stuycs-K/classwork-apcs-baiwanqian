import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day7 {

  public static int countSupportsTLS(String filename) {
    int count = 0;
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      while (input.hasNextLine()) {
        String ipAddress = input.nextLine();
        ArrayList<String> supernets = new ArrayList<>();
        ArrayList<String> hypernets = new ArrayList<>();
        int start = 0;
        while (start < ipAddress.length()) {
          int leftBracket = ipAddress.indexOf("[", start);
          int rightBracket = ipAddress.indexOf("]", start);
          if (leftBracket == -1 && rightBracket == -1) {
            supernets.add(ipAddress.substring(start));
            start = ipAddress.length();
          } else {
            supernets.add(ipAddress.substring(start, rightBracket));
            hypernets.add(ipAddress.substring(leftBracket + 1, rightBracket));
            start = rightBracket + 1;
          }
        }
        boolean hasABBAhypernets = false;
        for (int i = 0; i < hypernets.size(); i++) {
          if (hasABBA(hypernets.get(i))) {
            hasABBAhypernets = true;
          }
        }
        boolean hasABBAsupernets = false;
        if (! hasABBAhypernets) {
          for (int j = 0; j < supernets.size(); j++) {
            if (hasABBA(supernets.get(j))) {
              hasABBAsupernets = true;
            }
          }
        }
        if (hasABBAsupernets) {
          count++;
        }
      }
      input.close();
    } catch (FileNotFoundException ex) {
      System.out.println("File not found");
    }
    return count;
  }

  public static boolean hasABBA(String s) {
    for (int i = 0; i < s.length() - 3; i++) {
      if (s.charAt(i) == s.charAt(i+3) &&
        s.charAt(i+1) == s.charAt(i+2) &&
        s.charAt(i) != s.charAt(i+1)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String filename = "Day7Input.txt";
    System.out.println(countSupportsTLS(filename));
  }

}
