package pe.edu.utp.hremployees.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrupoUTP on 10/06/2017.
 */
public class LocationsEntity extends BaseEntity {

    public LocationsEntity() {
        super();
        setTableName("locations");
    }

    public LocationsEntity(Connection connection) {
        super(connection, "locations");
    }

    public List<Location> findByCriteria(
            String criteria,
            CountriesEntity countriesEntity,
            RegionsEntity regionsEntity) {
        String sql = getDefaultQuery() +
                (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Location> locations = new ArrayList<>();
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) {
                locations.add(
                        Location.build(rs, countriesEntity, regionsEntity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locations;
    }

    public List<Location> findAll(CountriesEntity countriesEntity, RegionsEntity regionsEntity) {
        return findByCriteria("", countriesEntity, regionsEntity);
    }

    public Location findById(int id, CountriesEntity countriesEntity, RegionsEntity regionsEntity) {
        try {
            String sql = "location_id = " + String.valueOf(id);
            return findByCriteria(sql, countriesEntity, regionsEntity).get(0);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
