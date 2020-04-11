package teme.w09_exceptions_files.ex2_reactor;

class PlantController {

    private PowerPlant plant;
    private Reactor reactor;

    PlantController(PowerPlant plant, Reactor reactor) {
        this.plant = plant;
        this.reactor = reactor;
    }

    void run() {

        try {
            adjust();
        } catch (ReactorCriticalException e) {
            e.printStackTrace();
            this.plant.soundAlarm();
            shutdown();

        }
    }


    boolean needAdjustment() {
        return this.plant.getTargetPower() - this.reactor.getPower() > 10;
    }

    void adjust() throws ReactorCriticalException {
        while (needAdjustment()) {
            this.reactor.increase();
        }
    }

    void shutdown() {
        while (this.reactor.getPower() != 0) {
            this.reactor.decrease();
        }
    }
}
