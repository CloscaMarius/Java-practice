package teme.w04_oop1.ex3_point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class PointApp {

    //just for manual testing of the Room class
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        System.out.println(p1.distanceTo(new Point(4, 5)));

    }
}

//TODO: define your Point class here (or in a separate file in same package)
class Point {

    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return x + ", " + y;
    }

    double distanceTo(Point other) {

        double deltaX = this.x - other.x;
        double deltaY = this.y - other.y;

        double dist = sqrt(pow(deltaX, 2) + pow(deltaY, 2));

        return dist;
    }

    void move(double deltaX, double deltaY) {
        this.x = x + deltaX;
        this.y = y + deltaY;

    }

    static boolean canFormTriangle(Point p1, Point p2, Point p3) {

        double deltaX12 = pow((p1.x - p2.x), 2);
        double deltaX13 = pow((p1.x - p3.x), 2);
        double deltaX23 = pow((p2.x - p3.x), 2);

        double deltaY12 = pow((p1.y - p2.y), 2);
        double deltaY13 = pow((p1.y - p3.y), 2);
        double deltaY23 = pow((p2.y - p3.y), 2);

        double dist12 = sqrt(deltaX12 + deltaY12);
        double dist13 = sqrt(deltaX13 + deltaY13);
        double dist23 = sqrt(deltaX23 + deltaY23);

        return dist12 + dist13 > dist23 && dist13 + dist23 > dist12 && dist12 + dist23 > dist13;

    }
   /* static boolean positiveSides(double dist12, double dist13, double dist23) {
        return dist12 > 0 && dist13 > 0 && dist23 > 0;
    }
    static boolean canFormValidTriangle(double dist12, double dist13, double dist23) {

        return positiveSides(dist12, dist13, dist23) && canFormTriangle(Point p1, Point p2, Point p3);
    }*/


    static boolean canFormRightAngledTriangle(Point p1, Point p2, Point p3) {
        double deltaX12 = pow((p1.x - p2.x), 2);
        double deltaX13 = pow((p1.x - p3.x), 2);
        double deltaX23 = pow((p2.x - p3.x), 2);

        double deltaY12 = pow((p1.y - p2.y), 2);
        double deltaY13 = pow((p1.y - p3.y), 2);
        double deltaY23 = pow((p2.y - p3.y), 2);

        double dist12 = sqrt(deltaX12 + deltaY12);
        double dist13 = sqrt(deltaX13 + deltaY13);
        double dist23 = sqrt(deltaX23 + deltaY23);

        return canFormTriangle(p1, p2, p3) && (pitagora(dist12, dist13, dist23) || pitagora(dist23, dist12, dist13) || pitagora(dist23, dist13, dist12));
    }

    static boolean pitagora(double dist12, double dist13, double dist23) {
        return dist12 * dist12 + dist13 * dist13 == dist23 * dist23;
    }


}
