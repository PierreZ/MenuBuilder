package fr.isen.steam;


import fr.isen.steam.business.impl.MenuBuilderBusinessImpl;
import fr.isen.steam.dao.impl.MenuBuilderDAOImpl;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.asm.Type;

import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Map;

/**
 * Created by pierrezemb on 21/02/2016.
 */
public class MenuBuilderBusinessImplTest {

    @Mock
    MenuBuilderBusinessImpl business;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockCreation(){
        assertNotNull(business);
    }

    @Test
    public void OneKey(){

        String daoResult = "Unicorn | Swag";
        when(business.getDAO(TypeMenu.MAIN)).thenReturn(daoResult);

        Map<String, List<String>> myMap = business.buildMenu(TypeMenu.MAIN);

        Assert.assertEquals(0, (myMap.get("Unicorn")).size());
        Assert.assertEquals(0, (myMap.get("Swag")).size());
        Assert.assertEquals(2, myMap.size());
    }
}
