package fr.isen.steam.dao.impl;

import fr.isen.steam.dao.MenuBuilderDAO;
import fr.isen.steam.utils.SteamException;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * Created by pierrezemb on 21/02/2016.
 * This is the implementation of MenuBuilderDAO
 */
@Component
public class MenuBuilderDAOImpl implements MenuBuilderDAO {

    /**
     * Override method. Only a wrapper for getProperty
     * @param cle
     * @return the raw string to parse
     */
    @Override
    public String loadProperty(String cle) {
        return getProperty(cle);
    }

    /**
     * Actual method that is loading the needed property
     * @param cle
     * @return the raw string to parse
     */
    public String getProperty(String cle) {

        ResourceBundle resourceBundle = null;
        resourceBundle = PropertyResourceBundle.getBundle("menus");
        if (resourceBundle == null)
            throw new SteamException("Property file not found");
        String msg = resourceBundle.getString(cle);
        if (msg == null) {
            throw new SteamException("Key not found");
        }
        return msg;
    }

}