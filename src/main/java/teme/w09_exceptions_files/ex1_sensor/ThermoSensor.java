package teme.w09_exceptions_files.ex1_sensor;


import java.util.Random;


class ThermoSensor implements Sensor {

    private boolean sensorSwitch;

    @Override
    public boolean isOn() {
        return sensorSwitch;
    }

    @Override
    public void on() {
        sensorSwitch = true;
    }

    @Override
    public void off() {
        sensorSwitch = false;
    }

    @Override
    public int measure() throws MeasurementException {
        int min = -30;
        int max = 30;
        if (sensorSwitch) {

            return new Random().nextInt(max - min + 1) + min;

        } else {
            throw new MeasurementException();
        }
    }
}
