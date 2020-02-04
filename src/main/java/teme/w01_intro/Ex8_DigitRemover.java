package teme.w01_intro;

class Ex8_DigitRemover {

    static int removeMiddleDigit(int n) {
        //todo: your code here!
        return 0;
    }

    //manual tests
    public static void main(String[] args) {
        //invalid:
        System.out.println("removeMiddleDigit(123)    = " + removeMiddleDigit(123));
        System.out.println("removeMiddleDigit(-12345) = " + removeMiddleDigit(-12345));
        System.out.println("removeMiddleDigit(9999)   = " + removeMiddleDigit(9999));
        System.out.println("removeMiddleDigit(100000) = " + removeMiddleDigit(100000));
        //valid:
        System.out.println("removeMiddleDigit(12345)  = " + removeMiddleDigit(12345));
    }
}
