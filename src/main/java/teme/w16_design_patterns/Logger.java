package teme.w16_design_patterns;

import java.util.HashMap;
import java.util.Map;

public class Logger {

    private Logger() {

    }

    private static final Logger INSTANCE = new Logger();

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void info(String message) {
        System.out.println("[INFO]: " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN]: " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR]: " + message);
    }

    public Map<String, Object> getProperties() {
        return new HashMap<>(); // load properties from file or something
    }
}
