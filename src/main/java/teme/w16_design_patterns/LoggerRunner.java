package teme.w16_design_patterns;

public class LoggerRunner {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        System.out.println(l1);
        System.out.println(l2);
        l1.info("this is an info message");
        l2.warn("this is a warning message");
        l1.error("this is an error message");
        l1.getProperties();
    }
}
