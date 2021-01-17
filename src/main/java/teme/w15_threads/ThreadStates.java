package teme.w15_threads;

public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello!");

        Thread myThread = Thread.currentThread();
        System.out.println(
                "Id: " + myThread.getId() +
                        ", name: " + myThread.getName() +
                        ", priority: " + myThread.getPriority() +
                        ", state: " + myThread.getState());

        System.out.println("sleeping...");
        Thread.sleep(5000);

        System.out.println("after sleep");

        System.out.println("Bye");
    }
}
