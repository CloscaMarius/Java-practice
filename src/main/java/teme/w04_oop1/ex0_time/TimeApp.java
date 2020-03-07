package teme.w04_oop1.ex0_time;


/**
 * This is the main class for this exercise, which contains a main() method
 * and is used to test the separate Time class (to be defined)
 */
class TimeApp {

    //some manual tests of Time class
    public static void main(String[] args) {

        Time t1 = new Time();
        Time t2 = new Time();
        System.out.println("t1 == t2 ?: " + (t1 == t2));
        System.out.println("t1: " + t1 + ", t2: " + t2);

        Time t3 = new Time(-11, 10, 30);
        System.out.println(t3.toString());
        System.out.println(t3);
        System.out.println(t3.secondsSinceMidnight());
        Time t4 = new Time(5, 5, 5);
        Time t5 = new Time(3, 3, 3);
        Time[] times = {t4, t5, t3};
        System.out.println("last time is: " + TimeUtils.findLatest(times).toString());


    }
}


class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public static int createInstancesCounter;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    boolean isAfter(Time other) {
        return other.secondsSinceMidnight() < (this.hours * 60 * 60 + this.minutes * 60 + this.seconds);
    }


    Time() {
        this(23, 59, 59);
    }

    Time(int hours, int minutes, int seconds) {
        this.hours = hours >= 0 && hours <= 23 ? hours : 0;
        this.minutes = minutes >= 0 && minutes <= 59 ? minutes : 0;
        this.seconds = seconds >= 0 && seconds <= 59 ? seconds : 0;
        createInstancesCounter++;
    }

    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

    int secondsSinceMidnight() {
        return hours * 60 * 60 + minutes * 60 + seconds;
    }

    int secondsSince(Time otherTime) {
        return this.secondsSinceMidnight() - otherTime.secondsSinceMidnight();
    }
}

class TimeUtils {
    static String descriptionOf(Time t) {
        return t.toString();
    }

    static Time findLatest(Time[] times) {

        int n = times.length;
        for (int j = 1; j < n; j++) {
            Time t0 = times[j];
            int i = j - 1;
            while ((i > -1) && (times[i].secondsSinceMidnight() > t0.secondsSinceMidnight())) {
                times[i + 1] = times[i];
                i--;
            }
            times[i + 1] = t0;
        }
        return times[times.length - 1];
    }

}

