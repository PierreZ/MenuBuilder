package fr.isen.steam;

import fr.isen.steam.dao.impl.MenuBuilderDAOImpl;
import fr.isen.steam.utils.SteamException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.AssertTrue;

/**
 * Created by pierrezemb on 21/02/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MenuBuilderDAOImpl.class)
public class MenuBuilderDAOTests {

    @Autowired
    MenuBuilderDAOImpl dao;

    @Test
    public void getOneKey(){

        String data = dao.loadProperty("menu.main");

        Assert.assertTrue(data.length()>0);
    }

    @Test(expected = java.util.MissingResourceException.class)
    public void getNoKey(){
        dao.loadProperty("unicorn");

    }
}
