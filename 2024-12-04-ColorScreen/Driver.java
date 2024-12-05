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

  public static int[] createRandomArray(int size) {
    int[] randArray = new int[size];
    for (int i = 0; i < size; i++) {
      randArray[i] = (int) (Math.random() * 100);
    }
    return randArray;
  }

  public static void displayRandom(Text text, String[] randArray) {
    int position = 20;
    for (int i = 0; i < randArray.length; i++) {
      int num = randArray[i];
      if (num < 25) {
        text.setForegroundColor(1);
      } else if (num > 75) {
        text.setForegroundColor(2);
      } else {
        text.resetColor();
      }
      text.moveCursor(2, positon);
      text.print(value);
    }
    position += 20;
    text.resetColor();
  }

  public static void drawHorizontalSeperator(Text text) {
    text.setBackgroundColor(4);
    for (int i = )
  }

  public static void main(String[] args) {

  }

}
