package pe.edu.utp.hremployees.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 02/06/2017.
 */
public class Region {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getIdAsString() {
        return String.valueOf(getId());
    }

    public Region setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue() {
        return "'" + getName() + "'";
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    public static Region build(ResultSet resultSet) {
        try {
            return (new Region())
                    .setId(resultSet.getInt("region_id"))
                    .setName(resultSet.getString("region_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
