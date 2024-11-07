public class Driver{
  public static void main(String[] args){
    Animal cow =  new Animal("moo", 3, "cow");
    cow.speak();

    Bird bird_test = new Bird("cacow", 2, "bird", 4.0, "yellow");
    bird_test.speak();

    Animal a1 = new Animal("woof", 1, "dog");
    Bird b1 = new Bird("chirp", 9, "songbird", 2.0, "pink");
    // Bird b2 = new Animal("ribbit", 5, "frog");
    Animal a2 = new Bird("quack", 7, "duck", 8.0, "golden");
  }
}
