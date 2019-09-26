import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import static spark.Spark.get;

public class App {

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animals.all());
            return new ModelAndView(model, "home.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
          List<Sightings> sightings = Sightings.all();
            model.put("sightings", sightings );
            List<Animals> animals=Animals.all();
            model.put("animals",animals);
            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Animals> animals=Animals.all();
            model.put("animals",animals);
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Animals newanimals= new Animals(name);
            model.put("name", name);
            newanimals.save();
            return new ModelAndView(model, "animal.hbs");
        }, new HandlebarsTemplateEngine());


        get("/listanimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animals> animals=Animals.all();
            model.put("animals",animals);
            return new ModelAndView(model, "listanimal.hbs");
        }, new HandlebarsTemplateEngine());

        get("/listanimal", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sightings> sightings =  Sightings.all();
            model.put("sightings" , sightings);
            return new ModelAndView(model, "listanimal.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String aname = request.queryParams("aname");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String rangename = request.queryParams("rangename");

            Sightings newSightings= new Sightings(aname,health,age,location,rangename);

            newSightings.save();

            model.put("aname", aname);
            model.put("health", health);
            model.put("age", age);
            model.put("location", location);
            model.put("rangename", rangename);
            response.redirect("/listanimal");

            return new ModelAndView(model, "listanimal.hbs");
        }, new HandlebarsTemplateEngine());




    }
}