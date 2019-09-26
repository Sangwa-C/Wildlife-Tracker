import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class testclass extends Sightings {

    public testclass(String aName, String health, String age, String location, String rangerName) {
        super(aName, health, age, location, rangerName);
    }

    public static List<testclass> sangwa(){
        String sql = "SELECT * FROM sight";

        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(testclass.class);
        }
    }
}