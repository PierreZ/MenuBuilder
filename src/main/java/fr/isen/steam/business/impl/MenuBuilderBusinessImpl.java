package fr.isen.steam.business.impl;

import fr.isen.steam.TypeMenu;
import fr.isen.steam.business.MenuBuilderBusiness;
import fr.isen.steam.dao.MenuBuilderDAO;
import fr.isen.steam.utils.SteamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by pierrezemb on 20/02/2016.
 * Implementation of business according to MenuBuilderBusiness
 */

@Component
public class MenuBuilderBusinessImpl implements MenuBuilderBusiness {

    @Autowired
    private MenuBuilderDAO menuBuilderDAO;

    /**
     * Generate a map from DAO
     * Parsing data into map
     * @param typeMenu
     * @return a map of menu/submenus
     */
    @Override
    public Map<String, List<String>> buildMenu(TypeMenu typeMenu) {

        String data = getDAO(typeMenu);

        Map<String, List<String>> menus = new LinkedHashMap<String, List<String>>();

        String[] parts = data.split("\\|");
        for (String part : parts) {
            String menuName = part.contains(";") ?  (part.split(";"))[0]: part;
            System.out.println("part = " + part);
            List<String> sousmenu = new ArrayList<String>();
            String[] subparts = part.split(";");
            // removing first one
            subparts = Arrays.copyOfRange(subparts, 1, subparts.length);
            for (String subpart : subparts) {
                System.out.println("subpart = " + subpart);
                sousmenu.add(subpart);
            }
            menus.put(menuName, sousmenu);
        }
        return menus;
    }

    /**
     * Getter for DAO
     * @param typeMenu
     * @return string
     */
    public String getDAO(TypeMenu typeMenu){

        String cle;
        switch (typeMenu){
            case MAIN:
                cle = "menu.main";
                break;
            case TAGS:
                cle = "menu.tags";
                break;
            case GENRES:
                cle = "menu.genres";
                break;
            default:
                throw new SteamException("Menu introuvable");
        }
        System.out.println(menuBuilderDAO.loadProperty(cle));
        return menuBuilderDAO.loadProperty(cle);
    }

    /**
     *
     * @return instance of DAO
     */
    public MenuBuilderDAO getMenuBuilderDAO() {
        return menuBuilderDAO;
    }

    /**
     *
     * @param Instance of menuBuilderDAO
     */
    public void setMenuBuilderDAO(MenuBuilderDAO menuBuilderDAO) {
        this.menuBuilderDAO = menuBuilderDAO;
    }

}
