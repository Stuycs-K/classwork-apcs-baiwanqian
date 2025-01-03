public class makeWords {

  public static void makeWords(int remainingLetters, String result, String alphabet) {
    if (remainingLetters == 0) {
      System.out.println(result);
      return;
    }
    for (int i = 0; i < alphabet.length(); i++) {
      makeWords(remainingLetters - 1, result + alphabet.charAt(i), alphabet);
    }
  }

}
