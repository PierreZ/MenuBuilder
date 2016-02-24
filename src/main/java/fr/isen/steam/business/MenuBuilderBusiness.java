package fr.isen.steam.business;

import fr.isen.steam.TypeMenu;
import java.util.List;
import java.util.Map;

/**
 * Created by pierrezemb on 20/02/2016.
 * Interface for Business
 */


public interface MenuBuilderBusiness {

    /**
     * Generate the map according to dao
     * @param typeMenu
     * @return map of menu and submenu
     */
    Map<String, List<String>> buildMenu(TypeMenu typeMenu);
}
