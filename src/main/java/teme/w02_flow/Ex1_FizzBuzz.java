package teme.w02_flow;

class Ex1_FizzBuzz {

    static String fizzBuzz(int i) {
        if ((i % 3) == 0 && (i % 5) == 0) {
            return "fizzbuzz";
        } else if ((i % 3) == 0) {
            return "fizz";
        } else if (i % 5 == 0) {
            return "buzz";
        } else {
            return String.valueOf(i);
        }
    }

    static void printAllFizzBuzzUpTo(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(fizzBuzz(i));
        }
    }


    public static void main(String[] args) {
        System.out.println(" 2 -> " + fizzBuzz(2));
        System.out.println(" 6 -> " + fizzBuzz(6));
        System.out.println("10 -> " + fizzBuzz(10));
        System.out.println("30 -> " + fizzBuzz(30));

        System.out.println("\nAll up to 20:");
        printAllFizzBuzzUpTo(20);
    }
}
