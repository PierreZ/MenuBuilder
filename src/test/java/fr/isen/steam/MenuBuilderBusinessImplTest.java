package fr.isen.steam;


import fr.isen.steam.business.impl.MenuBuilderBusinessImpl;
import fr.isen.steam.dao.MenuBuilderDAO;
import fr.isen.steam.dao.impl.MenuBuilderDAOImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Map;

/**
 * Created by pierrezemb on 21/02/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class MenuBuilderBusinessImplTest {

    private MenuBuilderBusinessImpl business;

    @Before
    public void start() {
        business = mock(MenuBuilderBusinessImpl.class);
    }

    @Test
    public void testMockCreation(){
        assertNotNull(business);
    }

    @Test
    public void OneKey(){

        String daoResult = "Unicorn|Swag";

        business = mock(MenuBuilderBusinessImpl.class);
        when(business.getDAO(TypeMenu.MAIN)).thenReturn(daoResult);

        Map<String, List<String>> myMap = business.buildMenu(TypeMenu.MAIN);

        assertNotNull(myMap);

        Assert.assertEquals(2, myMap.size());

        System.out.println(myMap);

        Assert.assertEquals(0, (myMap.get("Unicorn")).size());
        Assert.assertEquals(0, (myMap.get("Swag")).size());
    }
}