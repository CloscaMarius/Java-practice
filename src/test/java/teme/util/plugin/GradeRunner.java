package teme.util.plugin;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

public class GradeRunner extends Runner {

    private int finalGrade;
    private int totalGrade;
    private final Class<?> testClass;

    public GradeRunner(Class<?> testClass) {
        super();
        this.finalGrade = 0;
        this.totalGrade = 0;
        this.testClass = testClass;
    }

    @Override
    public Description getDescription() {
        return Description.createTestDescription(testClass, "Runner for grade evaluation");
    }

    @Override
    public void run(RunNotifier notifier) {
        try {
            Object testObject = testClass.getDeclaredConstructor().newInstance();
            Arrays.asList(testClass.getMethods()).forEach(
                    method -> {
                        Description description = Description.createTestDescription(testClass, method.getName());
                        try {
                            if (method.isAnnotationPresent(Test.class)) {
                                int maxGrade = getGrade(method);
                                // run the method
                                totalGrade += maxGrade;
                                method.invoke(testObject);
                                finalGrade += maxGrade;
                                // notify listeners a test started after invoking the method,
                                // because for some reason, if a test fails the result goes at the end of
                                // the result list(even after the gradle    )
                                notifier.fireTestStarted(description);
                                // notify listeners a test finished
                                notifier.fireTestFinished(description);
                            }
                        } catch (Throwable e) {
                            Failure failure = new Failure(description, e.getCause());
                            notifier.fireTestFailure(failure);
                        }
                    }
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create a fake test successful test with the final gradle as a description
        String header = String.format("Grade for %s", testClass.getSimpleName());
        Description gradeDescription = Description.createTestDescription(testClass,
                String.format("%s %s: %s %s",
                        String.join("", Collections.nCopies(20, ">")),
                        header,
                        String.format("%s/%s", finalGrade, totalGrade),
                        String.join("", Collections.nCopies(20, "<"))
                )
        );

        // We don't need to notify starting the test, otherwise there will be a duplicate result
        notifier.fireTestIgnored(gradeDescription);
    }

    private int getGrade(Method method) {
        Grade grade = method.getAnnotation(Grade.class);
        return grade != null ? grade.value() : 0;
    }
}
