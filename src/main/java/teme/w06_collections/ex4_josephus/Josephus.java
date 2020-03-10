package teme.w06_collections.ex4_josephus;

class Josephus {

    /**
     * @return the number of the last remaining soldier
     */
    static int eliminate(int total, int step) {
        System.out.println("\nTotal soldiers: " + total + ", will eliminate them with step: " + step);

        //TODO!!
        int remaining = -1;

        System.out.println("Last standing: " + remaining);
        return remaining;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        eliminate(1, 1);
        eliminate(3, 1);
        eliminate(5, 2);
        eliminate(5, 3);
        eliminate(5, 7);
        eliminate(10, 3);
    }
}
