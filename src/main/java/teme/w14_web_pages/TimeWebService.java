package teme.w14_web_pages;

import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.Date;

import static spark.Spark.get;
import static spark.Spark.post;

public class TimeWebService {
    public static void main(String[] args) {

        get("/time1", ((request, response) -> {
            Date date = new Date();
            return date.toString();
        }));
        System.out.println("Server started, see: http://localhost:4567/time1");

        get("/time2", ((request, response) -> {
            LocalDateTime now = LocalDateTime.now();
            Gson gson = new Gson();
            String currentTimeAsJson = gson.toJson(now);
            return currentTimeAsJson;
        }));
        System.out.println("Server started, see: http://localhost:4567/time2");

        get("/hello", (request, response) -> {
            Greeting greeting = new Greeting("Ionel", "Good morning!");
            String json = new Gson().toJson(greeting);
            return json;
        });
        System.out.println("Server started, see: http://localhost:4567/hello");

        post("/hello", (request, response) -> {

            //read body and convert from json to a matching java class (instance)
            String body = request.body();
            System.out.println("The body of the request: " + body);
            ClientInfo clientInfo = new Gson().fromJson(body, ClientInfo.class);

            //use the class instance to build response
            String rezultat = "Hello, " + clientInfo.getName() +
                    "! How's the weather in " + clientInfo.getAddress() + "?";
            return rezultat;
        });
        System.out.println("Server started, see: http://localhost:4567/hello");
    }
}

class Greeting {

    private final String name;
    private final String message;

    Greeting(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}

class ClientInfo {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}