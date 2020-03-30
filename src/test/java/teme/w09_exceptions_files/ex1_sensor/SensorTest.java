package teme.w09_exceptions_files.ex1_sensor;

import org.junit.Test;
import org.junit.runner.RunWith;
import teme.util.plugin.Grade;
import teme.util.plugin.GradeRunner;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.*;

/**
 * MAX GRADE: 15p
 */
@SuppressWarnings("RedundantCast")
@RunWith(GradeRunner.class)
public class SensorTest {

    @Test
    @Grade(1)
    public void constantSensor_defaultState() {
        assertTrue(((Sensor) new ConstantSensor(0)).isOn());
    }

    @Test
    @Grade(1)
    public void constantSensor_onOffIgnored() {
        Sensor s = (Sensor) new ConstantSensor(0);
        s.off();
        s.off();
        assertTrue(s.isOn());
        s.on();
        s.on();
        assertTrue(s.isOn());
    }

    @Test
    @Grade(1)
    public void constantSensor_measure() {
        Sensor s = (Sensor) new ConstantSensor(10);
        for (int i = 1; i < 5; i++) {
            assertEquals(10, s.measure());
        }

        s = (Sensor) new ConstantSensor(0);
        for (int i = 1; i < 5; i++) {
            assertEquals(0, s.measure());
        }

        s = (Sensor) new ConstantSensor(-100);
        for (int i = 1; i < 5; i++) {
            assertEquals(-100, s.measure());
        }
    }


    @Test
    @Grade(1)
    public void thermoSensor_defaultState() {
        assertFalse(((Sensor) new ThermoSensor()).isOn());
    }

    @Test
    @Grade(1)
    public void thermoSensor_onOff() {
        Sensor sensor = (Sensor) new ThermoSensor();

        sensor.on();
        assertTrue(sensor.isOn());

        //repeated operation is ok
        sensor.on();
        assertTrue(sensor.isOn());


        sensor.off();
        assertFalse(sensor.isOn());

        //repeated operation is ok
        sensor.off();
        assertFalse(sensor.isOn());
    }

    @Test
    @Grade(1)
    public void thermoSensor_measureWhileOff() {
        Sensor sensor = (Sensor) new ThermoSensor();

        sensor.on();
        sensor.measure(); //should work

        sensor.off();
        try {
            sensor.measure();
            fail("measure() worked with thermo sensor off!");
        } catch (Sensor.MeasurementException ignore) {
            //ok
        }
    }

    @Test
    @Grade(1)
    public void thermoSensor_rangeOfMeasuredValues() {
        Sensor sensor = (Sensor) new ThermoSensor();
        sensor.on();

        Set<Integer> values = Stream.generate(sensor::measure).limit(60).collect(toSet());
        System.out.println("Distinct values after 50 measurements: " + values);
        assertTrue(values.size() >= 30);
        assertTrue(values.stream().allMatch(v -> v >= -30 && v <= 30));
    }


    @Test
    @Grade(2)
    public void averageSensor_isOn() {
        AverageSensor avg = new AverageSensor();
        Sensor as = (Sensor) avg;

        Sensor t1 = (Sensor) new ThermoSensor();
        t1.on();

        avg.addSensor(t1);
        assertTrue(as.isOn());

        t1.off();
        assertFalse(as.isOn());

        t1.on();
        assertTrue(as.isOn());

        Sensor t2 = (Sensor) new ThermoSensor();
        avg.addSensor(t2);

        t2.off();
        assertFalse(as.isOn());

        t2.on();
        assertTrue(as.isOn());

        t1.off();
        assertFalse(as.isOn());

        t2.off();
        assertFalse(as.isOn());

        t1.on();
        t2.on();
        assertTrue(as.isOn());

        Sensor c = (Sensor) new ConstantSensor(1);
        c.on();

        avg.addSensor(c);
        assertTrue(as.isOn());
    }

    @Test
    @Grade(2)
    public void averageSensor_onOff_changeSensorState() {
        Sensor t1 = (Sensor) new ThermoSensor();
        Sensor t2 = (Sensor) new ThermoSensor();
        Sensor c = (Sensor) new ConstantSensor(0);

        t1.off();
        t2.off();

        AverageSensor avg = new AverageSensor();
        Sensor as = (Sensor) avg;

        as.on(); //no exception for empty

        avg.addSensor(t1);
        as.on();
        assertTrue(t1.isOn());

        as.off();
        assertFalse(t1.isOn());

        avg.addSensor(t2);
        as.on();
        assertTrue(t1.isOn());

        t1.off();
        t2.off();
        assertFalse(t1.isOn());
        assertFalse(t1.isOn());

        as.on();
        assertTrue(t1.isOn());
        assertTrue(t2.isOn());

        as.off();
        assertFalse(t1.isOn() && t2.isOn()); //at least one must be off

        avg.addSensor(c);
        as.on();
        assertTrue(t1.isOn());
        assertTrue(t2.isOn());
        assertTrue(c.isOn());
    }

    @Test
    @Grade(1)
    public void averageSensor_measureFailsWhenEmpty() {
        Sensor s = (Sensor) (new AverageSensor());

        //measure while empty
        try {
            s.measure();
            fail("measure() should throw exception when average sensor is empty");
        } catch (Sensor.MeasurementException ignore) {
            //ok
        }
    }

    @Test
    @Grade(1)
    public void averageSensor_measureFailsWhenOff() {
        AverageSensor avg = new AverageSensor();
        Sensor as = (Sensor) avg;

        avg.addSensor((Sensor) new ThermoSensor());

        as.off();
        assertFalse(as.isOn());
        try {
            as.measure();
            fail("measure() should throw exception when average sensor is off");
        } catch (Sensor.MeasurementException ignore) {
            //ok
        }

        as.on();
        assertTrue(as.isOn());
        as.measure(); //no exception

        avg.addSensor((Sensor) new ThermoSensor());
        avg.addSensor((Sensor) new ConstantSensor(1));
        as.on();
        assertTrue(as.isOn());
        as.measure(); //no exception
    }

    @Test
    @Grade(1)
    public void averageSensor_measureValues_constantSensors() {
        AverageSensor avg = new AverageSensor();
        Sensor as = (Sensor) avg;

        avg.addSensor((Sensor) new ConstantSensor(10));
        as.on();
        for (int i = 0; i < 5; i++) {
            assertEquals(10, as.measure());
        }

        avg.addSensor((Sensor) new ConstantSensor(20));
        as.on();
        for (int i = 0; i < 5; i++) {
            assertEquals(15, as.measure());
        }
    }

    @Test
    @Grade(1)
    public void averageSensor_measureValues_mixedSensors() {
        AverageSensor avg = new AverageSensor();
        avg.addSensor((Sensor) new ConstantSensor(10));
        avg.addSensor((Sensor) new ConstantSensor(20));
        avg.addSensor((Sensor) new ThermoSensor());

        Sensor as = (Sensor) avg;
        as.on();
        assertTrue(Stream.generate(as::measure).limit(60).allMatch(v -> v >= 0 && v <= 20));
    }
}
