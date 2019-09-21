import java.util.ArrayList;

public abstract class Animals {
    public int id;
    public String name;
    private static ArrayList<Animals> instances = new ArrayList<>();

//    public Animals(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setInstances(ArrayList<Animals> instances) {
        Animals.instances = instances;
    }
    public static ArrayList<Animals> getAll(){
        return instances;
    }
}
