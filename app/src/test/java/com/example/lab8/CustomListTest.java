package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        CustomList cityList = MockCityList();
        City mock = (City) mockCity();
        cityList.addCity(mock);
        // test if the list size has changed
        assertEquals(1, cityList.getCount());
        assertTrue(cityList.hasCity(mock));

        City city = new City("Test","Test2");
        assertFalse(cityList.hasCity(city));
    }


    @Test
    void testDelete() throws Exception {
        CustomList cityList = MockCityList();
        // add a sample city
        City city = new City("Test","Test2");
        City mock = mockCity();
        cityList.addCity(city);
        cityList.addCity(mock);
        assertEquals(2, cityList.getCount());

        // test the delete functionality
        cityList.deleteCity(mock);
        assertEquals(1, cityList.getCount());
        assertFalse(cityList.hasCity(mockCity()));

        // check if the sample city is still there
        assertTrue(cityList.hasCity(city));

        // test if the exception works
        try{
            cityList.deleteCity(mock);
        }
        catch(Exception e) {
            assertEquals("This city is not in the list, failed to delete.", e.getMessage());
        }
    }

    @Test
    void countCities() {
        CustomList cityList = MockCityList();
        City city = new City("Test","Test2");
        cityList.addCity(city);
        assertEquals(1, cityList.getCount());
    }



}
