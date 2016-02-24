package fr.isen.steam.dao;

/**
 * Created by pierrezemb on 20/02/2016.
 * Interface for DAO
 * Only one method
 */
public interface MenuBuilderDAO {

    /**
     * load property is loading property from PropertyResourceBundle
     * @param cle
     * @return a raw string of data
     */
    String loadProperty(final String cle);
}