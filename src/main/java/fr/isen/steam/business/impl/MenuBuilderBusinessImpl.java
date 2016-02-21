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
 */

@Component
public class MenuBuilderBusinessImpl implements MenuBuilderBusiness{

    @Autowired
    private MenuBuilderDAO menuBuilderDAO;

    @Override
    public Map<String, List<String>> buildMenu(TypeMenu typeMenu) {

        return generateStruct(getDAO(typeMenu));
    }

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
        return menuBuilderDAO.loadProperty(cle);
    }

    /**
     * Returns the right format from DAO
     * Parse string: menu are separated by | and sousmenu by ;
     * @param data to parse
     * @return map. Key is menu, list are the sous-menu
     */
    private Map<String,List<String>> generateStruct(String data) {

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
}