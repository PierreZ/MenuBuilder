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
 */
@RestController
@RequestMapping("/api")
public class MenuBuilderService {

    @Inject
    private MenuBuilderBusiness business;

    @RequestMapping("/images/{typeMenu}")
    Map<String, List<String>> buildMenu(@PathVariable("typeMenu")TypeMenu typeMenu){
        System.out.println(typeMenu);
        System.out.println(business.getClass());
        return this.business.buildMenu(typeMenu);
    }

    @RequestMapping("/health")
    public String health() {
        return "up";
    }
}