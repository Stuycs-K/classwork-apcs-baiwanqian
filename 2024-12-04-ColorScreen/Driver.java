import java.util.Random;

public class Driver {

  public static void drawBorder(Text text) {
    text.setBackgroundColor(4);
    for (int i = 1; i <=80; i++) {
      text.moveCursor(1, i);
      text.print(" ");
      text.moveCursor(30, i);
      text.print(" ");
    }
    for (int i = 2; i <= 29; i++) {
      text.moveCursor(i, 1);
      text.print(" ");
      text.moveCursor(i, 80);
      text.print(" ");
    }
    text.resetColor();
  }

  public static void randomInteger

  public static void main(String[] args) {

  }

}
