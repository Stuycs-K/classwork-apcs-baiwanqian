import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

  public static void main(String[] args) {
    String filename = "Day1Input.txt";
    try {
      File file = new File(filename);
      Scanner input = new Scanner(file);
      String[] instructions = input.nextLine().split(", ")
      int x, y, direction = 0;
      while (input.hasNext()) {
        if(input.next().charAt(0) == 'R') {
          direction += 90;
        } else {
          direction -= 90;
    }

      }
    }
    catch {

    }
  }


}
