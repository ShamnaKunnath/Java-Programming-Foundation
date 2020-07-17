import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of averageTemparature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class averageTemparature {
    public Double averageTemperatureInFile(CSVParser parser) {
        Double totalT=0.0;
        int c=0;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            c += 1;
             totalT += Double.parseDouble(currentRow.get("TemperatureF"));
        }
        return (totalT/c);
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Double avg = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temparature is " + avg);
    }

}
