package ua.lviv.iot.creativity.manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import ua.lviv.iot.creativity.model.CreativityGood;

public class CreativityGoodWriter {

    private String filePath;

    public CreativityGoodWriter() {
};

    public CreativityGoodWriter(String filePath) {
         this.filePath = filePath;
    };

    public void writeToFile(List<CreativityGood> creativityGood) {
        File csvFile = new File(filePath + ".csv");
        try(FileOutputStream fileOS = new FileOutputStream(csvFile);
                OutputStreamWriter osw = new OutputStreamWriter(fileOS, StandardCharsets.UTF_8);
                BufferedWriter buffWriter = new BufferedWriter(osw);){

            for(CreativityGood creativityG : creativityGood) {
                buffWriter.write(creativityG.getHeaders());
                buffWriter.newLine();
                buffWriter.write(creativityG.toCSV());
                buffWriter.newLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
}
}

    public String getFilePath() {
        return filePath;
}

    public void setFilePath(String filePath) {
        this.filePath=filePath;
}

}
