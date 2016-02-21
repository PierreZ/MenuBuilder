package fr.isen.steam.business;

import fr.isen.steam.TypeMenu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by pierrezemb on 20/02/2016.
 */


public interface MenuBuilderBusiness {

    Map<String, List<String>> buildMenu(TypeMenu typeMenu);
}
