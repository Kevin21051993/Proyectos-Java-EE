package pe.edu.utp.hremployees.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrupoUTP on 03/06/2017.
 */
public class CountriesEntity extends BaseEntity {

    public CountriesEntity(Connection connection) {
        super(connection, "countries");
    }

    public CountriesEntity() {
        super();
    }

    public List<Country> findAll(RegionsEntity regionsEntity) {
        return findByCriteria("", regionsEntity);
    }

    public Country findById(String id, RegionsEntity regionsEntity) {
        String criteria = "country_id = " + "'" + id + "'";
        return findByCriteria(criteria, regionsEntity).get(0);
    }

    public List<Country> findByCriteria(String criteria, RegionsEntity regionsEntity) {
        String sql = getDefaultQuery() + (criteria.isEmpty() ? "" : " WHERE " + criteria);
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(sql);
            if(rs == null) return null;
            while(rs.next()) countries.add(Country.build(rs, regionsEntity));
            return countries;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    public List<Country> findByRegion(Region region, RegionsEntity regionsEntity) {
        String criteria = "region_id = " + region.getIdAsString();
        return findByCriteria(criteria, regionsEntity);
    }

    public List<Country> findAllOrderByName(RegionsEntity regionsEntity, boolean isAscending) {
        return findByCriteria("true ORDER BY country_name" +
                (isAscending ? "" : " DESC"), regionsEntity );
    }

    public boolean add(Country country) {
        String sql = "INSERT INTO countries(country_id, country_name, region_id) VALUES(" +
                country.getIdAsValue() + ", " +
                country.getNameAsValue() + ", " +
                country.getRegion().getIdAsString() + ")";
        return change(sql);
    }

    public boolean update(Country country) {
        String sql = "UPDATE countries SET " +
                "country_name = " + country.getNameAsValue() + ", " +
                "region_id = " + country.getRegion().getIdAsString() +
                " WHERE country_id = " + country.getIdAsValue();
        return change(sql);
    }

    public boolean delete(Country country) {
        String sql = "DELETE FROM countries WHERE country_id = " +
                country.getIdAsValue();
        return change(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM countries WHERE country_id = " +
                "'" + id + "'";
        return change(sql);
    }

}
