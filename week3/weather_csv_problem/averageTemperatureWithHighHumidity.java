import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of averageTemperatureWithHighHumidity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class averageTemperatureWithHighHumidity {
    
    public Double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value) {
        Double totalT=0.0;
        int c=0;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
           if(Integer.parseInt(currentRow.get("Humidity"))>=value){
               c += 1;
               totalT += Double.parseDouble(currentRow.get("TemperatureF"));
        }
        }
        return (totalT/c);
    }
    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        Double avg = averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
        System.out.println("Average temparature is " + avg);
    }
}