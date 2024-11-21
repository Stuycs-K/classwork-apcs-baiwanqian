import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day7 {

  public static int countSupportsTLS(String filename, boolean isPart2) {
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
          } else if (leftBracket > start) {
            supernets.add(ipAddress.substring(start, leftBracket));
            hypernets.add(ipAddress.substring(leftBracket + 1, rightBracket));
            start = rightBracket + 1;
          }
        }

        if (isPart2) {
          boolean containsABA = false;
          ArrayList<String> babs = new ArrayList<>();
          for (int i = 0; i < supernets.size(); i++) {
            for (int j = 0; j < supernets.get(i).length() - 2; j++) {
              String aba = supernets.get(i).substring(j, j + 3);
              if (hasABA(aba)) {
                String bab = "" + aba.charAt(1) + aba.charAt(0) + aba.charAt(1);
                babs.add(bab);
                containsABA = true;
              }
            }
          }
          boolean containsBAB = false;
          if (containsABA) {
            for (int i = 0; i < hypernets.size(); i++) {
              for (int j = 0; j < babs.size(); j++) {
                if (hypernets.get(i).contains(babs.get(j))) {
                  count++;
                  containsBAB = true;
                }
              }
              if (containsBAB) i = hypernets.size();
            }
          }

      } else {
          boolean hasABBAhypernets = false;
          for (int i = 0; i < hypernets.size(); i++) {
            if (hasABBA(hypernets.get(i))) {
              hasABBAhypernets = true;
            }
          }
          if (! hasABBAhypernets) {
            for (int i = 0; i < supernets.size(); i++) {
              if (hasABBA(supernets.get(i))) {
                count++;
              }
            }
          }
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

  public static boolean hasABA(String s) {
    for (int i = 0; i < s.length() - 2; i++) {
      if (s.charAt(i) == s.charAt(i+2) &&
        s.charAt(i) != s.charAt(i+1)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    String filename = "Day7Input.txt";
    System.out.println(countSupportsTLS(filename, false));
    System.out.println(countSupportsTLS(filename, true));
  }

}
