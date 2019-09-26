import org.sql2o.Connection;
import java.util.ArrayList;
import java.util.List;

public class Animals {
    public int id;
    public String name;
    private static ArrayList<Animals> instances = new ArrayList<>();

    public Animals(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }


    public static List<Animals> all() {
        String sql = "SELECT * FROM animals ;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animals.class);
        }
    }

}
