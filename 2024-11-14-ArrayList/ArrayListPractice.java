import java.util.ArrayList;

public class ArrayListPractice {

  public static ArrayList<String>createRandomArray(int size) {
    ArrayList<String> randomList = new ArrayList<String>(size);
    for (int i = 0; i < size; i++) {
      int num = (int)(Math.random()*11);
      if (num == 0) {
        randomList.add("");
      } else {
        randomList.add("" + num);
      }
    }
    return randomList;
  }

  public static void replaceEmpty(ArrayList<String> original){
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
    for (int i = original.size() - 1; i >= 0; i--) {
      newList.add(original.get(i));
    }
    return newList;
  }

  public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
  //return a new ArrayList that has all values of a and b in alternating order that is:
  //a[0], b[0], a[1], b[1]...
  //If one list is longer than the other, just attach the remaining values to the end.
    ArrayList<String> newList = new ArrayList<String>(a.size() + b.size());
    int i = 0;
    while (i < a.size() || i < b.size()) {
      if (i < a.size()) {
        newList.add(a.get(i));
      }
      if (i < b.size()) {
        newList.add(b.get(i));
      }
      i++;
    }
    return newList;
  }

  public static void main(String[] args) {

    // test createRandomArray
    ArrayList<String> rand1 = createRandomArray(10);
    System.out.println("Random Array: " + rand1);
    // test replaceEmpty
    replaceEmpty(rand1);
    System.out.println("Replaced empty strings: " + rand1);
    // test makeReversedList
    ArrayList<String> reversed1 = makeReversedList(rand1);
    System.out.println("Reversed List: " + reversed1);
    // test mixLists
    ArrayList<String> listA = new ArrayList<>();
    listA.add("1");
    listA.add("3");
    listA.add("5");
    ArrayList<String> listB = new ArrayList<>();
    listB.add("2");
    listB.add("4");
    listB.add("6");
    listB.add("8");
    listB.add("10");
    ArrayList<String> mixed1 = mixLists(listA, listB);
    System.out.println("Mixed List: " + mixed1);

    // test createRandomArray
    ArrayList<String> rand2 = createRandomArray(50);
    System.out.println("Random Array: " + rand2);
    rand2.set(0, " ");
    // test replaceEmpty
    replaceEmpty(rand2);
    System.out.println("Replaced empty strings: " + rand2);
    // test makeReversedList
    ArrayList<String> reversed2 = makeReversedList(rand2);
    System.out.println("Reversed List: " + reversed2);
    // test mixLists
    ArrayList<String> mixed2 = mixLists(rand1, rand2);
    System.out.println("Mixed List: " + mixed2);

    // test createRandomArray
    ArrayList<String> rand3 = createRandomArray(2000);
    System.out.println("Random Array: " + rand3);
    // test replaceEmpty
    replaceEmpty(rand3);
    System.out.println("Replaced empty strings: " + rand3);
    // test makeReversedList
    ArrayList<String> reversed3 = makeReversedList(rand3);
    System.out.println("Reversed List: " + reversed3);
    // test mixLists
    ArrayList<String> rand4 = createRandomArray(2000);
    ArrayList<String> mixed3 = mixLists(rand3, rand4);
    System.out.println("Mixed List: " + mixed3);

  }
}
