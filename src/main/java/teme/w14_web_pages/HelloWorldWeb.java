package teme.w14_web_pages;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class HelloWorldWeb {
    public static void main(String[] args) {

        get("/hello1", (request, response) -> "Hello, stranger!");

        System.out.println("Server started, see: http://localhost:4567/hello1 ...");

        get("/hello2", (request, response) -> {
            return "<h1 style='color:blue'>" +
                    "Hello, <i> world </i> !" +
                    "</h1>" +
                    "Altceva dupa...";
        });

        System.out.println("Server started, see: http://localhost:4567/hello2 ...");

        get("/hello3/:name", (request, response) -> {
            String userName = request.params(":name");
            return "Hello, " + userName;
        });

        System.out.println("Server started, see: http://localhost:4567/hello3 ...");

        //todo: add a 2nd param for address, read it
        //and include it in the response page (on a separate line, bold)
        //example url: localhost:4567/hello4?name=Ion&address=Vaslui
        get("/hello4", (request, response) -> {
            String name = request.queryParams("name");
            String address = request.queryParams("address");
            if (name != null && address != null) {
                return "<b>Hello " + name + ", so you're from " + address + ", huh?</b>";
            } else {
                response.status(400);
                return "Bad Request";
            }
        });

        System.out.println("Server started, see: http://localhost:4567/hello4 ...");

        //------- With user form -------//
        //on GET request we return the initial page, with the empty form:
        get("/hello5", ((request, response) -> {
            return "Need to know you: <br> <br>" +
                    "<form method='POST'>" +

                    "<label>Name:</label>" +
                    "<input name='username' type='text' required>" +
                    "<br>" +

                    "<label>Address:</label>" +
                    "<input name='address' type='text' required >" +
                    "<br>" +

                    "<label>Age:</label>" +
                    "<input name='age' type='number' min='1' max='99'>" +
                    "<br>" +

                    "<input type='submit' value='Send'>" +
                    "</form>";
        }));

        //after submit of form, we arrive on server on the POST method for same page
        //and here we read the submitted form info (as query params), use them and
        //build the response page
        post("/hello5", (request, response) -> {
            String username = request.queryParams("username");
            String address = request.queryParams("address");
            String age = request.queryParams("age");

            if (age != null && !age.isEmpty()) {
                return "<b>Hello " + username + ", so you're from "
                        + address + ", huh?</b> <br>"
                        + "And quite young, at " + age + " years..";
            } else {
                return "<b>Hello " + username + ", so you're from "
                        + address + ", huh?</b>";
            }
        });

        System.out.println("Server started, see: http://localhost:4567/hello5 ...");


        get("/hello6", ((request, response) -> {
            String name = request.session().attribute("username");


            if (name != null) {
                request.session().maxInactiveInterval(15);
                request.session().attribute("username", name);
                return "<b>Welcome back " + name + "</b>";

            }
            return "Need to know you: <br> <br>" +
                    "<form method='POST'>" +

                    "<label>Name:</label>" +
                    "<input name='username' type='text' required>" +
                    "<br> <br>" +

                    "<input type='submit' value='Send'>" +
                    "</form>";
        }));

        post("/hello6", (request, response) -> {
            String username = request.queryParams("username");
            String address = request.queryParams("address");
            String age = request.queryParams("age");

            if (username != null) {
                request.session().attribute("username", username);

                return "<b> Hello " + username;
            }
            return null;

        });

        get("/forgetme", (request, response) -> {
            request.session().removeAttribute("username");
            response.redirect("/hello6");
            return null;
        });
        System.out.println("Server started, see: http://localhost:4567/hello6 ...");


        get("/hello7", ((request, response) -> {
            return "Need to know you: <br> <br>" +
                    "<form method='POST'>" +

                    "<label>Name:</label>" +
                    "<input name='username' type='text' required pattern=\"[a-zA-Z\\s]+\" title=\"No digits or other characters\" required>" +
                    "<br>" +

                    "<label>Address:</label>" +
                    "<input name='address' type='text' required >" +
                    "<br>" +

                    "<label>Age:</label>" +
                    "<input name='age' type='number' min='1' max='99'>" +
                    "<br>" +

                    "<input type='submit' value='Send'>" +
                    "</form>";
        }));

        post("/hello7", (request, response) -> {
            String username = request.queryParams("username");
            String address = request.queryParams("address");
            String age = request.queryParams("age");

            if (age != null && !age.isEmpty()) {
                return "<b>Hello " + username + ", so you're from "
                        + address + ", huh?</b> <br>"
                        + "And quite young, at " + age + " years..";
            } else {
                return "<b>Hello " + username + ", so you're from "
                        + address + ", huh?</b>";
            }
        });

        System.out.println("Server started, see: http://localhost:4567/hello7 ...");


        get("/hello8", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("hello", "Velocity World");

            // The vm files are located under the resources directory
            return new ModelAndView(model, "hello.vm");
        }, new VelocityTemplateEngine());


        System.out.println("Server started, see: http://localhost:4567/hello8 ...");

    }


}
