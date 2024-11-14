import java.util.ArrayList;

public class ArrayListPractice {

  public static ArrayList<String>createRandomArray(int size) {
    ArrayList<String> randomList = new ArrayList<String>(size);
    for (int i = 0; i < randomList.size(); i++) {
      int num = (int)(Math.random()*11);
      if (num == 0) {
        randomList.add("");
      } else {
        randomList.add(num);
    }
  }
}

}
