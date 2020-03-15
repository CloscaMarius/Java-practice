package teme.w05_oop2.ex2_cylinder;

class CircleCylinder {

    public static void main(String[] args) {

        //TODO: some manual tests, you may uncomment/run this after you created the required classes/interfaces

        Circle base = new Circle(0.1, 0.2, 2.5);
        System.out.println("base: " + base);
        System.out.println("base area: " + base.area() + ", length: " + base.length());

        //with inheritance:
        CylinderH ch = new CylinderH(0.1, 0.2, 2.5, 3.5);
        System.out.println("\nch: " + ch);
        System.out.println("ch: base: " + ch.getBase());
        System.out.println("ch: base area: " + ch.getBase().area());
        System.out.println("ch: total area: " + ch.area() + ", volume: " + ch.volume());
        System.out.println("ch length?: " + ch.length());

        //with composition:
        CylinderC cc = new CylinderC(0.1, 0.2, 2.5, 3.5);
        System.out.println("\ncc: " + cc);
        System.out.println("cc: base: " + cc.getBase());
        System.out.println("cc: base area: " + cc.getBase().area());
        System.out.println("cc: total area: " + cc.area() + ", volume: " + cc.volume());
        System.out.println("cc length?: " + cc.length()); //=> will result in compile error
    }
}

//TODO: you may create the classes (Circle, etc) directly here (but must not be 'public') our in other files under this package, your choice

class Circle {

    private double centerX;
    private double centerY;
    private double radius;

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    double area() {
        return Math.PI * Math.pow(radius, 2);
    }


    public double length() {
        return Math.PI * radius * 2;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                ", radius=" + radius +
                '}';
    }
}

class CylinderH extends Circle implements Cylinder {

    private double height;

    CylinderH(double centerX, double centerY, double radius, double height) {
        super(centerX, centerY, radius);
        this.height = height;
    }

    CylinderH(Circle base, double height) {
        this(base.getCenterX(), base.getCenterY(), base.getRadius(), height);
    }

    @Override
    public double length() {
        return super.length();
    }

    public String toStringHeight() {
        return "CylinderH{" +
                "height=" + height +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() + this.toStringHeight();
    }


    @Override
    public Circle getBase() {
        return new Circle(super.getCenterX(), super.getCenterY(), super.getRadius());
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double volume() {
        return getBase().area() * height;
    }

    @Override
    public double area() {
        return 2 * super.area() + this.height * length();
    }
}

class CylinderC implements Cylinder {
    private Circle circle;
    private double height;

    CylinderC(double centerX, double centerY, double radius, double height) {
        this.circle = new Circle(centerX, centerY, radius);
        this.height = height;
    }

    CylinderC(Circle circle, double height) {
        this.circle = circle;
        this.height = height;
    }


    double length() {
        return getBase().length();
    }

    public double area() {
        return 2 * getBase().area() + this.height * length();
    }

    public String toStringHeight() {
        return "CylinderH{" +
                "height=" + this.height +
                '}';
    }

    public String toString() {
        return this.circle.toString() + this.toStringHeight();
    }

    @Override
    public Circle getBase() {
        return circle;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double volume() {
        return getBase().area() * this.height;
    }
}

interface Cylinder {

    Circle getBase();

    double getHeight();

    double volume();

    default double area() {
        return 0;
    }

}