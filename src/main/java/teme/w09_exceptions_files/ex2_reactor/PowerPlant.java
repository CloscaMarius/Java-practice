package teme.w09_exceptions_files.ex2_reactor;

class PowerPlant {

    private int targetPower;
    private boolean alarmTriggered = false;

    PowerPlant(int targetPower) {
        this.targetPower = targetPower;
    }

    int getTargetPower() {
        return this.targetPower;
    }

    void soundAlarm() {
        alarmTriggered = true;
        System.out.println("Alarm!");
    }

    boolean hasAlarmSounded() {
        return alarmTriggered;
    }
}
