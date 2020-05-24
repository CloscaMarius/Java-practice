package teme.w14_web_pages;

import spark.Request;
import spark.Response;

import java.util.Date;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Example with GET/POST, forms, using the user session
 */
public class HelloWorld6 {

    public static void main(String[] args) {

        //on GET request we return the initial page, with the empty form:
        get("/hello6", HelloWorld6::handleGetHomePage);

        //handle submit from form
        post("/hello6", HelloWorld6::handleLoginRequest);

        //handle forget me requests
        get("/logout", (request, response) -> {
            //remove name from user session
            request.session().removeAttribute("name");

            //continue with another page from this server
            response.redirect("/hello6");
            return null;
        });
    }

    //--- the methods for handling each request ---//
    private static String handleGetHomePage(Request request, Response response) {
        //try to read user name from session (if it was saved already from previous login)
        String currentName = request.session().attribute("name");

        //if user name present on session, use it
        if (currentName != null) {

            String page = "<b>Hello " + currentName + ", welcome back!</b> <br>" +
                    "<a href='/logout'>Forget me!</a>";

            Date creationDate = new Date(request.session().creationTime());
            Date lastAccessDate = new Date(request.session().lastAccessedTime());

            String infoSesiune =
                    "<br> Sesiunea curenta: <br>" +
                            "Id: " + request.session().id() + "<br>" +
                            "Creation time: " + creationDate + "<br>" +
                            "Last access time: " + lastAccessDate + "<br>" +
                            "Max inactive interval:" + request.session().maxInactiveInterval() + "<br>" +
                            "Attribute names: " + request.session().attributes();

            return page + infoSesiune;
        }

        //else must show login page
        return contentOfLoginPage("", null);
    }

    private static String handleLoginRequest(Request request, Response response) {
        String username = request.queryParams("username");
        String password = request.queryParams("password");

        //check if valid
        if (username.contains(" ")) {
            return contentOfLoginPage(username, "Invalid name, cannot contain spaces!");
        }

        //save this name on current user session! (linked to current browser, by a cookie)
        request.session().attribute("name", username);
        request.session().attribute("password", password);
        request.session().maxInactiveInterval(15); //auto expire session in 15 sec without activy

        return "<b>Hello " + username + ", welcome back!</b> <br>" +
                "<a href='/logout'>Forget me!</a>";
    }

    private static String contentOfLoginPage(String oldName, String errorMessage) {

        String errorSection =
                errorMessage != null ?
                        "<h2 style='color:red'>Validation error: " + errorMessage + "</h2>" :
                        "";

        return "<h1>Login Page</h1>" +
                "<br>" +

                errorSection +

                "<form method='POST'>" +

                "<label>Name:</label>" +
                "<input name='username' type='text' required value='" + oldName + "'>" +
                "<br>" +

                "<label>Password:</label>" +
                "<input name='password' type='password' required >" +
                "<br>" +

                "<input type='submit' value='Login'>" +
                "</form>";
    }
}
