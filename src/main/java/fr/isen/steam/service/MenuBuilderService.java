package fr.isen.steam.service;

import fr.isen.steam.TypeMenu;
import fr.isen.steam.business.MenuBuilderBusiness;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by pierrezemb on 20/02/2016.
 * Service controller for MenuBuilder
 * 2 endpoint:
 * /api/health
 * /api/images/{typeMenu}
 */
@RestController
@RequestMapping("/api")
public class MenuBuilderService {

    @Inject
    private MenuBuilderBusiness business;

    /**
     * Endpoint for /images/{typeMenu}
     * @param typeMenu
     * @return a Map<String, List of submenu<String>>
     */
    @RequestMapping("/images/{typeMenu}")
    Map<String, List<String>> buildMenu(@PathVariable("typeMenu")TypeMenu typeMenu){
        return this.business.buildMenu(typeMenu);
    }

    /**
     * Endpoint for /api/health
     * @return status of application, usefull for shinken/artimon/metrology stuff
     */
    @RequestMapping("/health")
    public String health() {
        return "up";
    }
}