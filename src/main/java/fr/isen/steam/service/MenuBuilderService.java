package fr.isen.steam.service;

import fr.isen.steam.TypeMenu;
import fr.isen.steam.business.MenuBuilderBusiness;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

/**
 * Created by pierrezemb on 20/02/2016.
 */
@RestController
@RequestMapping("/api")
public class MenuBuilderService {

    @Inject
    private MenuBuilderBusiness business;

    @RequestMapping("/images/{typeMenu}")
    Map<String, List<String>> buildMenu(@PathVariable("typeMenu")TypeMenu typeMenu){
        return this.business.buildMenu(typeMenu);
    }

    @RequestMapping("/health")
    public String health() {
        return "up";
    }
}