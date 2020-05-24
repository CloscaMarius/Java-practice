package teme.w14_web_pages;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Ex1TimeServerWeb {
    public static void main(String[] args) {
        get("/time", ((request, response) -> {

            LocalDateTime now = LocalDateTime.now();
            int day = now.getDayOfMonth();
            int month = now.getMonthValue();
            int year = now.getYear();
            int hour = now.getHour();
            int min = now.getMinute();
            int sec = now.getSecond();
            LocalDateTime start = now.minusDays(1);
            LocalDateTime stop = now.plusDays(1);

            long totalDays = ChronoUnit.DAYS.between(start, stop);
            long elapsedDays = ChronoUnit.DAYS.between(start, now);

            long percentage = (elapsedDays * 100) / totalDays;
            DecimalFormat df = new DecimalFormat("0.00");
            double percentDouble = Math.floor(percentage * 100) / 100;

            return "<head>" +
                    "<meta http-equiv='refresh' content='5'>" +
                    "</head>" +
                    "<h1 style='color:blue'>" +
                    "Date: " + descriptionOfDate(day, month, year) + "<br>" +
                    "Time: " + descriptionOfTime(hour, min, sec) + "<br> " + "" +
                    "Percentage of the day: " + df.format(percentDouble) + " %"
                    + "</h1>" +
                    "<a href='/time'>Go back</a>";

        }));
        get("/time1", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "http://localhost:4567/time")
            );
        });

        System.out.println("Server started, see: http://localhost:4567/time ...");
    }

    static String descriptionOfDate(int day, int month, int year) {
        String result = "";
        String dayStr = "";
        String monthStr = "";
        dayStr = day <= 9 ? "0" + day : String.valueOf(day);
        monthStr = month <= 9 ? "0" + month : String.valueOf(month);
        result += dayStr + "-" + monthStr + "-" + year;

        return result;
    }

    static String descriptionOfTime(int hour, int min, int sec) {
        String result = "";
        String minutes = "";
        String seconds = "";
        minutes = min <= 9 ? "0" + min : String.valueOf(min);
        seconds = sec <= 9 ? "0" + sec : String.valueOf(sec);

        if (hour >= 0 && hour <= 12) {
            result += hour + ":" + minutes + ":" + seconds + " AM";
        } else if (hour > 12) {
            result += hour - 12 + ":" + min + ":" + seconds + " PM";
        }
        return result;
    }

}
