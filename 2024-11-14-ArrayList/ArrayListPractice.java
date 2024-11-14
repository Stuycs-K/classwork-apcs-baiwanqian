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

  public static void replaceEmpty( ArrayList<String> original){
    //Modify the ArrayList such that it has all of the empty strings are
    //replaced with the word "Empty".
    for (int i = 0; i < original.size(); i++) {
      if (original.get(i).equals("")) {
        original.set(i, "Empty");
      }
    }
  }

  public static ArrayList<String> makeReversedList( ArrayList<String> original){
    //return a new ArrayList that is in the reversed order of the original.
    ArrayList<String> newList = new ArrayList<String>(original.size());
    for (int i = 0; i < newList.size(); i++) {
      newList.set(i, original.get(original.size()- (i +1)));
    }
    return newList;
  }

  
}
