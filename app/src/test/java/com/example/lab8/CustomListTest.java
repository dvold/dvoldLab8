package com.example.lab8;


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

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * this checks if a list has a city * @param city * @return boolean
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        City testCity1 = new City("Estevan", "SK");
        City testCity2 = new City("Edmonton", "AB");
        boolean haveCity1 = list.hasCity(testCity1);
        boolean haveCity2 = list.hasCity(testCity2);
        assertEquals(haveCity1,true);
        assertEquals(haveCity2,false);
    }

    /**
     * Deletes a city from a list * @param city
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), 1);
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.getCount(), 2);
        list.deleteCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), 1);
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.countCities(), 2);
        list.addCity(new City("Vancouver", "BC"));
        assertEquals(list.countCities(), 3);
    }

}
