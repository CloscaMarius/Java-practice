package teme.w09_exceptions_files.ex1_sensor;

class SensorMain {
    public static void main(String[] args) {

        Sensor c = (Sensor) new ConstantSensor(10);
        System.out.println("Constant: on: " + c.isOn() + ", measure: " + c.measure() + "\n");
        c.off();
        System.out.println("Constant, after off(): on: " + c.isOn());

        Sensor t = (Sensor) new ThermoSensor();
        System.out.println("Thermo, at start: on: " + t.isOn());
        t.on();
        System.out.println("Thermo, after on(): on: " + t.isOn() + ", measure: " + t.measure() + "\n");

        AverageSensor avg = new AverageSensor();
        Sensor s = (Sensor) avg;
        avg.addSensor(c);
        avg.addSensor(t);
        System.out.println("Avg: on: " + s.isOn() + ", measure: " + s.measure() + "\n");

        s.off();
        System.out.println("Avg, after off(): on: " + s.isOn());
        try {
            s.measure(); //should throw exception
        } catch (Sensor.MeasurementException e) {
            System.out.println("exception while measuring: " + e);
        }
    }
}
