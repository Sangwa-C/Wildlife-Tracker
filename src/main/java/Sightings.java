import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Sightings {
    public int id;
    public String aName;
    public String location;
    public String rangeName;
    public Timestamp sighted;
private static ArrayList<Sightings> instances = new ArrayList<>();

    public Sightings(String aName, String location) {
        this.aName = aName;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getaName() {
        return aName;
    }

    public String getLocation() {
        return location;
    }

    public String getRangeName() {
        return rangeName;
    }

    public Timestamp getSighted() {
        return sighted;
    }

    public static ArrayList<Sightings> getInstances() {
        return instances;
    }

    public  void setInstances(ArrayList<Sightings> instances) {
        Sightings.instances = instances;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sight (named, location, rangename) VALUES (:aName, :location, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("aName", this.aName)
                    .addParameter("location", this.location)
                    .executeUpdate()
                    .getKey();
        }
    }

        public static Sightings find(int id) {
            try(Connection con = DB.sql2o.open()) {
                String sql = "SELECT * FROM sight where id=:id";
                Sightings animals = con.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetchFirst(Sightings.class);
                return animals;
            }
        }

        public List<Sightings> getAnimals() {
            try(Connection con = DB.sql2o.open()) {
                String sql = "SELECT * FROM sight as where id=:id";
                return con.createQuery(sql)
                        .addParameter("id", this.id )
                        .executeAndFetch(Sightings.class);
            }
        }
    public static List<testclass> sangwa(){
        String sql =
                "SELECT named FROM sight";

        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(testclass.class);
        }
    }

    }


