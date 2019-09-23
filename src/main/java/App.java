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
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "home.hbs");
        }, new HandlebarsTemplateEngine());


        get("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            model.put("template", "templates/index.vtl");
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
//            response.redirect("/");
        }, new HandlebarsTemplateEngine());


        get("/listanimal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Animals> animals=Animals.all();
            model.put("animals",animals);
            return new ModelAndView(model, "listanimal.hbs");
        }, new HandlebarsTemplateEngine());




    }
}