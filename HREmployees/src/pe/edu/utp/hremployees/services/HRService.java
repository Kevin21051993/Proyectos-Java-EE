package pe.edu.utp.hremployees.services;

import pe.edu.utp.hremployees.models.Country;
import pe.edu.utp.hremployees.models.HRDataStore;
import pe.edu.utp.hremployees.models.Region;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by GrupoUTP on 10/06/2017.
 */
public class HRService {
    private Connection connection;
    private HRDataStore dataStore;

    public HRService(InitialContext ctx) {
        try {
            connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource"))
                    .getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public HRService() {
        try {
            InitialContext ctx = new InitialContext();
            connection = ((DataSource) ctx.lookup("jdbc/MySQLDataSource"))
                    .getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private Connection getConnection() {
        return connection;
    }

    private HRDataStore getDataStore() {
        if(dataStore == null) {
            dataStore = new HRDataStore(getConnection());
        }
        return dataStore;
    }

    public List<Region> getRegions() {
        return getDataStore().findAllRegions();
    }

    public List<Country> getCountries() { return getDataStore().findAllCountries(); }

    public List<Country> getCountriesForRegion(Region region) {
        return getDataStore().findCountriesByRegion(region);
    }

    public int getCountriesCountForRegion(Region region) {
        return getCountriesForRegion(region).size();
    }

    public List<Country> getCountriesOrderByName() {
        return getDataStore().findAllCountriesOrderByName();
    }

    public Region getRegionById(int id) {
        return getDataStore().findRegionById(id);
    }

    public Region getRegionById(String id) {
        return getDataStore().findRegionById(
                Integer.parseInt(id));
    }

    public boolean updateRegion(Region region) {
        return getDataStore().updateRegion(region);
    }
}
