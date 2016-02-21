package fr.isen.steam.dao.impl;

import fr.isen.steam.dao.MenuBuilderDAO;
import fr.isen.steam.utils.SteamException;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pierrezemb on 21/02/2016.
 */
@Component
public class MenuBuilderDAOImpl implements MenuBuilderDAO {
    @Override
    public String loadProperty(String cle) {
        return getProperty(cle);
    }

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