package ua.lviv.iot.creativityGood;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.creativity.model.*;
import ua.lviv.iot.creativity.model.Thread;
import ua.lviv.iot.creativity.manager.CreativityGoodWriter;

class TestCreativityGoodWriter {

    List<CreativityGood> creativityGood = new ArrayList<>();
    CreativityGoodWriter creativityGoodWriter;
    private String filePath = "csvFile";
    
    Needle needle = new Needle("Needle",30,Type.FISHING,30);
    Thread thread = new Thread("Thread",10,Type.WEAVING,5);
    Tissue tissue = new Tissue("Tissue",25,Type.WEAVING,10,25);
    
    @BeforeEach
    void setUp() {
        creativityGood.add(needle);
        creativityGood.add(thread);
        creativityGood.add(tissue);
        
        creativityGoodWriter = new CreativityGoodWriter(filePath);
    }
    
    @Test
    void testWriterToFile() {
        File csvFile = new File(filePath);
        creativityGoodWriter.writeToFile(creativityGood);
        
        try(FileInputStream fileIS = new FileInputStream(csvFile);
                InputStreamReader inputSR = new InputStreamReader(fileIS);
                BufferedReader buffReader = new BufferedReader(inputSR);
                ){
            
            for(CreativityGood creativityG : creativityGood) {
                assertEquals(creativityG.getHeaders(), buffReader.readLine());
                assertEquals(creativityG.toCSV(), buffReader.readLine());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
                
    }
    

}
