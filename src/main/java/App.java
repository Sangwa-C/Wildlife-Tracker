import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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


//        get("/", (request, response) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
////            model.put("template", "templates/index.vtl");
//            return new ModelAndView(model, "animal-form.hbs");
//        }, new HandlebarsTemplateEngine

    }
}