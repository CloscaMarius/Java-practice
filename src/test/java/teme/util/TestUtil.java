package teme.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestUtil {
    public static String runCapturingOutput(Runnable runnable) {

        System.out.println("[TestUtil]: Capturing System.out output...");
        String out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {

            System.setOut(new PrintStream(outContent));
            runnable.run();
            out = outContent.toString();
        } finally {
            System.setOut(originalOut);
        }

        System.out.println("[TestUtil]: ...done, captured output:\n---------------\n" + out + "\n---------------\n");
        return out;
    }
}
