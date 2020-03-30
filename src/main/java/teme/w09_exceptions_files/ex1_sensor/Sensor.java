package teme.w09_exceptions_files.ex1_sensor;

/**
 * Defines common behavior for all sensors
 */
interface Sensor {

    /**
     * @return true if the sensor is on
     */
    boolean isOn();

    /**
     * Switches the sensor on
     */
    void on();

    /**
     * Switches the sensor off
     */
    void off();

    /**
     * @return the sensor reading if the sensor is on
     * @throws MeasurementException if sensor cannot measure
     */
    int measure() throws MeasurementException;


    //Also defined in interface the class for the exception, is part of the sensor API
    //Is a nested class, can be accesses from outside as: Sensor.MeasurementException
    class MeasurementException extends RuntimeException {

        MeasurementException() {
        }

        MeasurementException(String msg) {
            super(msg);
        }
    }
}
