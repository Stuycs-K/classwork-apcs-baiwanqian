public class Demo{

  /*
  Write this method third. Test it then move on
  to the others.
  */
  public static double distance(Point a, Point b){
    return Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
  }

  public static void main(String[]args){
    Point p1 = new Point(1,1);
    Point p2 = new Point(-1,-1);
    Point p3 = new Point(3,4);
    Point p1Copy = new Point(p1);
    System.out.println( p3);
    System.out.println( distance(p1,p2));
    System.out.println( Point.distance(p1,p2));
    System.out.println( p1.distanceTo(p2));
    System.out.println( p1Copy);
    Point n1 = new Point(0,0);
    Point n2 = new Point(0,0);
    Point n3 = new Point(-9,0);
    Point n1Copy = new Point(n1);
    System.out.println( n3);
    System.out.println( distance(n1,n2));
    System.out.println( Point.distance(n1,n2));
    System.out.println( n1.distanceTo(n2));
    System.out.println( n1Copy);
    Point e1 = new Point(-999,1999);
    Point e2 = new Point(1,1);
    Point e3 = new Point(0,0);
    Point e1Copy = new Point(e1);
    System.out.println( e3);
    System.out.println( distance(e1,e2));
    System.out.println( Point.distance(e1,e2));
    System.out.println( e1.distanceTo(e2));
    System.out.println( e1Copy);

    // Equilateral triangle
    Point point1 = new Point(0, 0);
    Point point2 = new Point(1, 0);
    Point point3 = new Point(0.5, Math.sqrt(3) / 2);
    System.out.println(point1);
    System.out.println(point2);
    System.out.println(point3);
    System.out.println("Distance between p1 and p2: " + distance(point1, point2));
    System.out.println("Distance between p2 and p3: " + distance(point2, point3));
    System.out.println("Distance between p1 and p3: " + distance(point1, point3));
      }
}
