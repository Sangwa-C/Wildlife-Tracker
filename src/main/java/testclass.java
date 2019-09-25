import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class testclass {

    public static List<testclass> sangwa(){
        String sql =
                "SELECT named FROM sight";

        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(testclass.class);
        }
    }
}