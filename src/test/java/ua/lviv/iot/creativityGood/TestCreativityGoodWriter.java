package ua.lviv.iot.creativityGood;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.creativity.manager.CreativityGoodWriter;
import ua.lviv.iot.creativity.model.*;
import ua.lviv.iot.creativity.model.Thread;

class TestCreativityGoodWriter {
    List<CreativityGood> testCreativityGood = new ArrayList<>();
    CreativityGoodWriter creativityGoodWriter;
    private String filePath = "csvFile.csv";
    
    Needle needle = new Needle("Needle", 100, Type.FISHING, 100 );
    Thread thread = new Thread("Thread", 150,Type.FISHING,100);
    Tissue tissue = new Tissue("Tissue",200,Type.FISHING,100,100);
    
    @BeforeEach
    void setUp() {
        testCreativityGood.add(needle);
        testCreativityGood.add(thread);
        testCreativityGood.add(tissue);
        
        creativityGoodWriter = new CreativityGoodWriter(filePath);
    }
    @BeforeEach
    void tearDown() {
        testCreativityGood.clear();
    }
    
    
    @Test
    void testWriterToFile(){
        File cvsFile = new File(filePath);
        creativityGoodWriter.writeToFile(testCreativityGood);
        
        try(FileInputStream fis = new FileInputStream(cvsFile);
                InputStreamReader isr= new InputStreamReader(fis);
                BufferedReader bufReader = new BufferedReader(isr);){
            for( CreativityGood creativityGood: testCreativityGood) {
                assertEquals(creativityGood.getHeaders(), bufReader.readLine());
                assertEquals(creativityGood.toCSV(),bufReader.readLine());
            }
                      
        }catch(Exception e) {
            
            e.printStackTrace();
        }
    }
}