package teme.w05_oop2.ex2_cylinder;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * MAX GRADE: 27p
 */
@RunWith(GradeRunner.class)
public class CircleCylinderTest {

    @Test
    @Grade
    public void TODO_uncomment_rest_of_tests_when_done() {
        //useless, but just to keep a few imports (needed for commented code) from being optimized
        assertEquals(Method.class, Method.class);
        assertTrue(true);
        //fail("TODO: Uncomment rest of tests when done!"); //and also comment out this line...
    }

    private static final double PRECISION = 0.001;

    //--- CIRCLE = 4p ---//
    @Test
    @Grade(2)
    public void circle_properties() {
        Circle c = new Circle(0.1, 0.2, 2.5);
        assertEquals(0.1, c.getCenterX(), PRECISION);
        assertEquals(0.2, c.getCenterY(), PRECISION);
        assertEquals(2.5, c.getRadius(), PRECISION);
    }

    @Test
    @Grade(1)
    public void circle_computations() {
        Circle c = new Circle(0.1, 0.2, 2.5);
        assertEquals(19.634, c.area(), PRECISION);
        assertEquals(15.707, c.length(), PRECISION);
    }

    @Test
    @Grade(1)
    public void circle_toString() {
        Circle c = new Circle(0.1, 0.2, 2.5);
        assertTrue(c.toString().contains("Circle"));
        assertTrue(c.toString().contains("0.1"));
        assertTrue(c.toString().contains("0.2"));
        assertTrue(c.toString().contains("2.5"));
    }

    //--- CYLINDER-H = 8p ---//
    @Test
    @Grade(3)
    public void cylinderH_firstConstructor() {
        CylinderH c = new CylinderH(0.1, 0.2, 2.5, 3.5);
        assertEquals(3.5, c.getHeight(), PRECISION);
        assertEquals(0.1, c.getBase().getCenterX(), PRECISION);
        assertEquals(0.2, c.getBase().getCenterY(), PRECISION);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderH_secondConstructor() {
        CylinderH c = new CylinderH(new Circle(0.1, 0.2, 2.5), 3.5);
        assertEquals(3.5, c.getHeight(), PRECISION);
        assertEquals(0.1, c.getBase().getCenterX(), PRECISION);
        assertEquals(0.2, c.getBase().getCenterY(), PRECISION);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
    }

    @Test
    @Grade(2)
    public void cylinderH_computations() {
        CylinderH c = new CylinderH(0.1, 0.2, 2.5, 3.5);
        assertEquals(68.722, c.volume(), PRECISION);
        assertEquals(94.247, c.area(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderH_getBaseReturnsSimpleCircle() {
        CylinderH c = new CylinderH(0.1, 0.2, 2.5, 3.5);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
        assertEquals(19.634, c.getBase().area(), PRECISION);
        assertEquals(15.707, c.getBase().length(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderH_toString() {
        CylinderH c = new CylinderH(0.1, 0.2, 2.5, 3.5);
        assertTrue(c.toString().contains("Cylinder"));
        assertTrue(c.toString().contains("0.1"));
        assertTrue(c.toString().contains("0.2"));
        assertTrue(c.toString().contains("2.5"));
        assertTrue(c.toString().contains("3.5"));
    }


    //--- CYLINDER-C = 8p ---//
    @Test
    @Grade(3)
    public void cylinderC_firstConstructor() {
        CylinderC c = new CylinderC(0.1, 0.2, 2.5, 3.5);
        assertEquals(3.5, c.getHeight(), PRECISION);
        assertEquals(0.1, c.getBase().getCenterX(), PRECISION);
        assertEquals(0.2, c.getBase().getCenterY(), PRECISION);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderC_secondConstructor() {
        CylinderC c = new CylinderC(new Circle(0.1, 0.2, 2.5), 3.5);
        assertEquals(3.5, c.getHeight(), PRECISION);
        assertEquals(0.1, c.getBase().getCenterX(), PRECISION);
        assertEquals(0.2, c.getBase().getCenterY(), PRECISION);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
    }

    @Test
    @Grade(2)
    public void cylinderC_computations() {
        CylinderC c = new CylinderC(0.1, 0.2, 2.5, 3.5);
        assertEquals(68.722, c.volume(), PRECISION);
        assertEquals(94.247, c.area(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderC_getBaseReturnsSimpleCircle() {
        CylinderC c = new CylinderC(0.1, 0.2, 2.5, 3.5);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
        assertEquals(19.634, c.getBase().area(), PRECISION);
        assertEquals(15.707, c.getBase().length(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderC_toString() {
        CylinderC c = new CylinderC(0.1, 0.2, 2.5, 3.5);
        assertTrue(c.toString().contains("Cylinder"));
        assertTrue(c.toString().contains("0.1"));
        assertTrue(c.toString().contains("0.2"));
        assertTrue(c.toString().contains("2.5"));
        assertTrue(c.toString().contains("3.5"));
    }


    //--- CYLINDER INTERFACE = 4p ---//
    @Test
    @Grade(1)
    public void cylinderInterface_implementedByThe2Classes() {
        CylinderH ch = new CylinderH(0.1, 0.2, 2.5, 3.5);
        CylinderC cc = new CylinderC(0.1, 0.2, 2.5, 3.5);
        assertTrue(ch instanceof Cylinder);
        assertTrue(cc instanceof Cylinder);
    }

    @Test
    @Grade(1)
    public void cylinderInterface_cylinderHImplementation_properties() {
        Cylinder c = new CylinderH(0.1, 0.2, 2.5, 3.5);
        assertEquals(3.5, c.getHeight(), PRECISION);
        assertEquals(0.1, c.getBase().getCenterX(), PRECISION);
        assertEquals(0.2, c.getBase().getCenterY(), PRECISION);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderInterface_cylinderHImplementation_computations() {
        Cylinder c = new CylinderH(0.1, 0.2, 2.5, 3.5);
        assertEquals(19.634, c.getBase().area(), PRECISION);
        assertEquals(15.707, c.getBase().length(), PRECISION);
        assertEquals(68.722, c.volume(), PRECISION);
        assertEquals(94.247, c.area(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderInterface_cylinderCImplementation_properties() {
        Cylinder c = new CylinderC(0.1, 0.2, 2.5, 3.5);
        assertEquals(3.5, c.getHeight(), PRECISION);
        assertEquals(0.1, c.getBase().getCenterX(), PRECISION);
        assertEquals(0.2, c.getBase().getCenterY(), PRECISION);
        assertEquals(2.5, c.getBase().getRadius(), PRECISION);
    }

    @Test
    @Grade(1)
    public void cylinderInterface_cylinderCImplementation_computations() {
        Cylinder c = new CylinderC(0.1, 0.2, 2.5, 3.5);
        assertEquals(19.634, c.getBase().area(), PRECISION);
        assertEquals(15.707, c.getBase().length(), PRECISION);
        assertEquals(68.722, c.volume(), PRECISION);
        assertEquals(94.247, c.area(), PRECISION);
    }

    //--- CYLINDER INTERFACE - DEFAULT METHODS = 2p ---//
    @Test
    @Grade(1)
    public void cylinderInterface_hasDefaultMethod_area() {
        try {
            Method m = Cylinder.class.getMethod("area");
            assertTrue("Cylinder.area() method should have a default implementation", m.isDefault());
        } catch (NoSuchMethodException e) {
            fail("Cylinder.area() method should exist");
        }
    }

    @Test
    @Grade(1)
    public void cylinderInterface_hasDefaultMethod_volume() {
        try {
            Method m = Cylinder.class.getMethod("area");
            assertTrue("Cylinder.area() method should have a default implementation", m.isDefault());
        } catch (NoSuchMethodException e) {
            fail("Cylinder.volume() method should exist");
        }
    }
}
