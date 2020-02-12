package teme.w02_flow;

class Ex3_FinancialSimulation {

    static int simulate(double initial, double interestPct, double target) {

        System.out.printf("\nSimulation started, with parameters: initial: %.2f, interest: %.2f%%, target: %.2f\n",
                initial, interestPct, target);

        //TODO: compute and return right result (may also print details for each passing year if you want to)
        return -1;
    }

    public static void main(String[] args) {
        simulate(1000, 10, 900);
        simulate(1000, 10, 1000);
        simulate(1000, 10, 1100);
        simulate(1000, 10, 1600);

        simulate(1000, 2.5, 1500);
        simulate(1000, 0.1, 1500);
    }
}
