import org.sql2o.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Sightings {
    public int id;
    public String aname;
    public String health;
    public String age;
    public String location;
    public String rangename;
    public Timestamp sighted;

    public Sightings(String aname, String health, String age, String location, String rangename) {
        this.aname = aname;
        this.health = health;
        this.age = age;
        this.location = location;
        this.rangename = rangename;
    }

    public String getaname() { return aname; }

    public void setaname(String aname) { this.aname = aname; }

    public String getHealth() { return health; }

    public void setHealth(String health) { this.health = health; }

    public String getAge() { return age; }

    public int getId() {
        return id;
    }

    public void setAge(String age) { this.age = age; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getRangerName() { return rangename; }

    public void setRangerName(String rangerName) { this.rangename = rangerName; }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (aname, health,age,location,rangename, sighted) VALUES (:aname, :health,:age, :location, :rangename, now());";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("aname", this.aname)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .addParameter("rangename", this.rangename)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings ;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class);
        }
    }
}


