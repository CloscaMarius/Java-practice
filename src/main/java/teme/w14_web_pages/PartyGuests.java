package teme.w14_web_pages;

/*
Vrem sa tinem minte pe server:
- o lista de invitati
- la fiecare conteaza:  numele, si numarul de invitati extra cu care vine (1,2..)
 */

import com.google.gson.Gson;
import spark.Spark;

import java.util.HashMap;
import java.util.Map;

public class PartyGuests {

    private static Map<String, Guest> guestsMap = new HashMap<>();

    public static void main(String[] args) {

        //add some initial entries
        guestsMap.put("Cristi", new Guest("Cristi", 1));
        guestsMap.put("Lucian", new Guest("Lucian", 0));

        // Our REST API - mapping common CRUD actions on HTTP methods + urls:
        //  - Get:     GET    '/guests'         -> returnat lista cu toti guests
        //  - Create:  POST   '/guests/:name' , body: Guest(json) -> add new guest
        //  - Update:  PUT    '/guests/:name' , body: Guest(json) -> update given guest (if found)
        //  - Delete:  DELETE '/guests/:name'  -> remove guest (by name) from list

        //Get all:
        Spark.get("/guests", (request, response) -> {
            String guestsMapAsJson = new Gson().toJson(guestsMap);
            return guestsMapAsJson;
        });

        //Create:
        Spark.post("/guests/:name", (request, response) -> {
            String name = request.params("name");
            String body = request.body();
            Guest newGuest = new Gson().fromJson(body, Guest.class);

            if (guestsMap.containsKey(newGuest.getName())) {
                response.status(400);
                return "Request already submitted";
            } else {
                guestsMap.put(newGuest.getName(), newGuest);
                response.status(201);
                return "Added new guest";
            }
        });

        //Update:
        Spark.put("/guests/:name", (request, response) -> {
            String name = request.params("name");
            String body = request.body();
            Guest newGuest = new Gson().fromJson(body, Guest.class);

            if (guestsMap.containsKey(newGuest.getName())) {
                guestsMap.put(newGuest.getName(), newGuest);
                response.status(201);
                return "Updated guest";
            } else {
                response.status(404);
                return "Guest not found";
            }
        });

        //Delete:
        Spark.delete("/guests/:name", (request, response) -> {
            String name = request.params("name");
            String body = request.body();
            Guest newGuest = new Gson().fromJson(body, Guest.class);

            if (guestsMap.containsKey(newGuest.getName())) {
                guestsMap.remove(newGuest.getName(), newGuest);
                response.status(201);
                return "Guest removed";
            } else {
                response.status(404);
                return "Guest not found";
            }
        });

        System.out.println("Server started, see: http://localhost:4567/guests");
    }
}

class Guest {
    String name;
    int extraGuests;

    public Guest(String name, int extraGuests) {
        this.name = name;
        this.extraGuests = extraGuests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExtraGuests() {
        return extraGuests;
    }

    public void setExtraGuests(int extraGuests) {
        this.extraGuests = extraGuests;
    }
}