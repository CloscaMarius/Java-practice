package teme.w09_exceptions_files.ex2_reactor;

import java.util.Random;

class Reactor {

    private int power = 0;
    private int criticalPower;

    Reactor(int criticalPower) {
        this.criticalPower = criticalPower;
    }

    int getPower() {
        return this.power;
    }

    void increase() throws ReactorCriticalException {
        int min = 1;
        int max = 100;
        if (this.criticalPower > this.power) {
            this.power += new Random().nextInt(max - min + 1) + min;
            if (this.criticalPower < this.power) {
                throw new ReactorCriticalException();
            }
        }
    }

    void decrease() {
        int min = 1;
        int max = 100;

        if (power >= 0) {
            this.power -= new Random().nextInt(max - min + 1) + min;
            if (power < 0) {
                this.power = 0;
            }
        }
    }
}
