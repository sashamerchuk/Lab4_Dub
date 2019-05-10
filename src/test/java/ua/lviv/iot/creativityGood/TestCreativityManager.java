package ua.lviv.iot.creativityGood;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.creativity.manager.CreativityManager;
import ua.lviv.iot.creativity.model.CreativityGood;
import ua.lviv.iot.creativity.model.Type;
import ua.lviv.iot.creativity.model.Needle;
import ua.lviv.iot.creativity.model.Thread;
import ua.lviv.iot.creativity.model.Tissue;



public class TestCreativityManager  {

    List<CreativityGood> testCreativityGood = new ArrayList<>();
    CreativityManager testManager = new CreativityManager();
    
    Needle needle = new Needle("Needle",30,Type.FISHING,30);
    Thread thread = new Thread("Thread",10,Type.WEAVING,5);
    Tissue tissue = new Tissue("Tissue",25,Type.WEAVING,10,25);
    
    @BeforeEach
    void setUp() {
        testCreativityGood.add(needle);
        testCreativityGood.add(thread);
        testCreativityGood.add(tissue);
    };

    @Test
    void testSortByPrice() {
        testManager.sortByPrice(testCreativityGood, true);
        Assertions.assertEquals(30,testCreativityGood.get(0).getPrice());
        Assertions.assertEquals(25,testCreativityGood.get(1).getPrice());
        Assertions.assertEquals(10,testCreativityGood.get(2).getPrice());
    };
    
    @Test
    void testSortByName() {
        testManager.sortByName(testCreativityGood, true);
        Assertions.assertEquals("Needle",testCreativityGood.get(2).getName());
        Assertions.assertEquals("Tissue",testCreativityGood.get(0).getName());
        Assertions.assertEquals("Thread",testCreativityGood.get(1).getName());
    };
    
    @Test
    void findByType() {
        testManager.findByType(testCreativityGood, Type.FISHING);
        Assertions.assertEquals(Type.FISHING,testCreativityGood.get(0).getType());

    }
    
    
    
  
}
    
  
