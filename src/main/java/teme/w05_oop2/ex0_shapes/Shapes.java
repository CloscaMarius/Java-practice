package teme.w05_oop2.ex0_shapes;

import static java.lang.Math.sqrt;

class Shapes {
    public static void main(String[] args) {

        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        System.out.println("p1: " + p1 + ", p2: " + p2 + ", dist: " + p1.distanceTo(p2));

        //--- Uncomment after solving a) b) ---//
        /*
        CircleShape cs = new CircleShape(5);
        RectangleShape rs = new RectangleShape(6, 8);
        System.out.println("\nCircleShape cs: " + cs);
        System.out.println("RectangleShape rs: " + rs);
        System.out.println("cs area: " + cs.computeArea());
        System.out.println("rs area: " + rs.computeArea());
        System.out.println("cs > rs ?: " + cs.isLargerThan(rs));
        System.out.println("rs > cs ?: " + rs.isLargerThan(cs));
        */

        //--- Uncomment after solving c) ---//
        /*
        cs.resize(1.1);
        rs.resize(1.25);
        System.out.println("cs after resize 1.1x : cs: " + cs + ", area: " + cs.computeArea());
        System.out.println("rs after resize 1.25x : rs: " + rs + ", area: " + rs.computeArea());
        */

        //--- Uncomment after solving d) ---//
        /*
        Circle c = new Circle(5, p1);
        Rectangle r = new Rectangle(6, 8, p1);
        System.out.println("\nCircle c: " + c);
        System.out.println("Rectangle r: " + r);
        System.out.println("c center: " + c.getCenter());
        System.out.println("c-r distance: " + c.distanceTo(r));
        System.out.println("r-c distance: " + r.distanceTo(c));
        c.move(1, 2);
        r.move(3, 4);
        System.out.println("\nafter move: ");
        System.out.println("c: " + c);
        System.out.println("r: " + r);
        System.out.println("c-r distance: " + c.distanceTo(r));
        System.out.println("r-c distance: " + r.distanceTo(c));
        */

        //--- Uncomment after solving e) ---//
        /*
        Square s = new Square(7, p1);
        System.out.println("\nSquare: s: " + s + ", area: " + s.computeArea() + ", center: " + s.getCenter());
        System.out.println("s-r distance: " + s.distanceTo(r));
        s.move(0.5, 0.5);
        System.out.println("after move s: " + s);
        */

        //--- Uncomment after solving f) ---//
        /*
        System.out.println("\ns > c ? " + s.isLargerThan(c) + " (s: " + s + ", s.area: " + s.computeArea() + "; c: " + c + ", c.area: " + c.computeArea() + ")");
        System.out.println("\nMaking the square bigger than circle:");
        s.growUntilLargerThan(c.computeArea(), 1.1);
        System.out.println("after: s > c ? " + s.isLargerThan(c) + " (s: " + s + ", s.area: " + s.computeArea() + "; c: " + c + ", c.area: " + c.computeArea() + ")");
        System.out.println("\nNow making the circle bigger again:");
        c.growUntilLargerThan(s.computeArea(), 1.1);
        System.out.println("after: c > s ? " + c.isLargerThan(s) + " (s: " + s + ", s.area: " + s.computeArea() + "; c: " + c + ", c.area: " + c.computeArea() + ")");
        */
    }
}

//================ POINT ================//
class Point {
    private final double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    double distanceTo(Point other) {
        return sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }
}


//================ SHAPES ================//

//TODO: add your classes,interfaces here...
