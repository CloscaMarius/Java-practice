package teme.w01_intro;

class Ex10_ComparingShapes {

    static final double PI = 3.141592; //approximate value of PI constant from math, can be used in your computation


    static double circleArea(double radius) {
        //A = PI * R^2
        return PI * radius * radius;
    }

    static double circleLength(double radius) {
        //L = 2 * PI * R
        return 2 * PI * radius;
    }


    static double squareArea(double side) {

        return side * side;
    }

    static double squarePerimeter(double side) {

        return 4 * side;
    }


    /**
     * Computes and compares the AREAS of 2 different shapes
     *
     * @param radius radius of the circle shape
     * @param side   side of the square shape
     * @return "square" if the square shape has the bigger area, or "circle" otherwise
     */
    static String whichHasGreaterArea(double radius, double side) {

        return squareArea(side) > circleArea(radius) ? "square" : "circle";
    }

    /**
     * Computes and compares the PERIMETERS of 2 different shapes
     *
     * @param radius radius of the circle shape
     * @param side   side of the square shape
     * @return "square" if the square shape has the bigger perimeter, or "circle" otherwise
     */
    static String whichHasGreaterPerimeter(double radius, double side) {

        return squarePerimeter(side) > circleLength(radius) ? "square" : "circle";
    }

    //--- MAIN, just for manual tests ---//
    public static void main(String[] args) {
        System.out.println("Area of circle with r=5: " + circleArea(5));
        System.out.println("Length of circle with r=5: " + circleLength(5));

        System.out.println("Area of square with side=8: " + squareArea(8));
        System.out.println("Perimeter of square with side=8: " + squarePerimeter(8));

        System.out.println("circle(r=5) vs square(l=8) - has greater AREA: '" + whichHasGreaterArea(5, 8) + "'");
        System.out.println("circle(r=5) vs square(l=8) - has greater PERIMETER: '" + whichHasGreaterPerimeter(5, 8) + "'");
    }
}
