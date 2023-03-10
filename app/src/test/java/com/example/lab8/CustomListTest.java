package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    public CustomList TestCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    private City testCity() {
        return new City("Edmonton", "Alberta");
    }

    //Adds a city to CityList and checks if the length changes by 1.
    @Test
    public void addCityTest(){
        list = TestCityList();
        int listSize = list.getCount();
        list.addCity(new City("Test", "Test1"));
        assertEquals(list.getCount(),listSize + 1);
    }

    // Creates a test city, adds it to CityList and asserts if it is there.
    @Test
    void testHasCity() {
        CustomList cityList = TestCityList();
        City mock = (City) testCity();
        cityList.addCity(mock);

        assertEquals(1, cityList.getCount());
        assertTrue(cityList.hasCity(mock));

        City city = new City("Test","Test2");
        assertFalse(cityList.hasCity(city));
    }


    // Adds a sample city and tests the delete function
    @Test
    void testDelete() throws Exception {
        CustomList cityList = TestCityList();
        City city = new City("Test","Test2");
        City mock = testCity();
        cityList.addCity(city);
        cityList.addCity(mock);
        assertEquals(2, cityList.getCount());

        cityList.deleteCity(mock);
        assertEquals(1, cityList.getCount());
        assertFalse(cityList.hasCity(testCity()));

        assertTrue(cityList.hasCity(city));

        try{
            cityList.deleteCity(mock);
        }
        catch(Exception e) {
            assertEquals("This city cannot be found in the list.", e.getMessage());
        }
    }

    @Test
    void countCities() {
        CustomList cityList = TestCityList();
        City city = new City("Test","Test2");
        cityList.addCity(city);
        assertEquals(1, cityList.getCount());
    }



}
