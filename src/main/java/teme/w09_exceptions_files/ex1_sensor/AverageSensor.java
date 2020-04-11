package teme.w09_exceptions_files.ex1_sensor;


import java.util.ArrayList;
import java.util.List;


class AverageSensor implements Sensor {

    private List<Sensor> sensors = new ArrayList<>();
    private static int valueNumber;
    private static boolean sensorSwitch;

    void addSensor(Sensor s) {
        sensors.add(s);
    }

    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                sensorSwitch = false;
                return false;
            }
        }
        sensorSwitch = true;
        return true;
    }

    @Override
    public void on() {
        for (Sensor s : sensors) {
            s.on();
        }
        sensorSwitch = true;
    }

    @Override
    public void off() {
        for (Sensor s : sensors) {
            s.off();
        }
        sensorSwitch = false;
    }

    @Override
    public int measure() throws MeasurementException {
        if (!sensorSwitch || sensors.isEmpty()) {
            throw new MeasurementException();
        }

        int sum = 0;
        int count = 0;

        for (Sensor s : sensors) {
            sum += s.measure();
            count++;
        }
        return sum / count;

        /*return (int) sensors.stream()
                .mapToInt(Sensor::measure)
                .average()
                .orElse(0);*/
    }
}
