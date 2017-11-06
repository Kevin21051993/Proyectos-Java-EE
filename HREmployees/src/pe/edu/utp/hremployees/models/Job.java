package pe.edu.utp.hremployees.models;

/**
 * Created by GrupoUTP on 03/06/2017.
 */
public class Job {
    private String id;
    private String title;
    private float minSalary;
    private float maxSalary;

    public Job() {
    }

    public Job(String id, String title, float minSalary, float maxSalary) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public String getId() {
        return id;
    }

    public Job setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Job setTitle(String title) {
        this.title = title;
        return this;
    }

    public float getMinSalary() {
        return minSalary;
    }

    public Job setMinSalary(float minSalary) {
        this.minSalary = minSalary;
        return this;
    }

    public float getMaxSalary() {
        return maxSalary;
    }

    public Job setMaxSalary(float maxSalary) {
        this.maxSalary = maxSalary;
        return this;
    }
}
