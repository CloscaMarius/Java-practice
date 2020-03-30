package teme.w09_exceptions_files.ex2_reactor;

class PlantMain {
    public static void main(String[] args) {

        System.out.println("Creating and starting a new power plant and reactor:");

        PlantController pc = new PlantController(new PowerPlant(120), new Reactor(150));
        pc.run();
    }
}
