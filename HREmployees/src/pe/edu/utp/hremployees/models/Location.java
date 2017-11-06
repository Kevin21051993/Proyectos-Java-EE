package pe.edu.utp.hremployees.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 03/06/2017.
 */
public class Location {
    private int id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Country country;

    public Location() {
    }

    public Location(int id, String streetAddress, String postalCode, String city, String stateProvince, Country country) {
        this.id = id;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public Location setId(int id) {
        this.id = id;
        return this;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public Location setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Location setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public Location setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Location setCountry(Country country) {
        this.country = country;
        return this;
    }

    public static Location build(ResultSet resultSet,
                                 CountriesEntity countriesEntity,
                                 RegionsEntity regionsEntity) {
        try {
            return (new Location())
                    .setId(resultSet.getInt("location_id"))
                    .setCity(resultSet.getString("city"))
                    .setStreetAddress(resultSet.getString("street_address"))
                    .setPostalCode(resultSet.getString("postal_code"))
                    .setStateProvince(resultSet.getString("state_province"))
                    .setCountry(countriesEntity.findById(
                            resultSet.getString("country_id"), regionsEntity));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
