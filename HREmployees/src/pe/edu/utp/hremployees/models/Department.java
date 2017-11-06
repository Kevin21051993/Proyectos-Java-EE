package pe.edu.utp.hremployees.models;

/**
 * Created by GrupoUTP on 03/06/2017.
 */
public class Department {
    private int id;
    private String name;
    private Location location;
    private Employee manager;
    public Department() {
    }

    public Department(int id, String name, Location location, Employee manager) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public Department setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Department setLocation(Location location) {
        this.location = location;
        return this;
    }

    public Employee getManager() {
        return manager;
    }

    public Department setManager(Employee manager) {
        this.manager = manager;
        return this;
    }
}
