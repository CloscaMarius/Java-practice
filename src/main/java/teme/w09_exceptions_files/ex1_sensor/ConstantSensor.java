package teme.w09_exceptions_files.ex1_sensor;


class ConstantSensor implements Sensor {

    private int valueNumber;

    ConstantSensor(int value) {
        valueNumber = value;
    }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() throws MeasurementException {
        return valueNumber;
    }

}
