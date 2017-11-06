package pe.edu.utp.hremployees.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 02/06/2017.
 */
public class Country {
    private String id;
    private String name;
    private Region region;

    public String getId() {
        return id;
    }

    public String getIdAsValue() { return "'" + getId() + "'";}

    public Country setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getNameAsValue() { return "'" + getName() + "'";}

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Country setRegion(Region region) {
        this.region = region;
        return this;
    }

    public static Country build(ResultSet rs, RegionsEntity regionsEntity) {
        try {
            return (new Country())
                            .setId(rs.getString("country_id"))
                    .setName(rs.getString("country_name"))
                    .setRegion(regionsEntity.findById(rs.getInt("region_id")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
