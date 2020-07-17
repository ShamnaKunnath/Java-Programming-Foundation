import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of CSVMinHumidity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CSVMinHumidity {
     public CSVRecord lowestHumidityInFile(CSVParser parser) {
        //start with largestSoFar as nothing
        CSVRecord smallestSoFar = null;
        //For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            // use method to compare two records
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
        }
        //The largestSoFar is the answer
        return smallestSoFar;
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord smallest = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Lowest Humidity was " + smallest.get("Humidity") +
                   " at " + smallest.get("DateUTC"));
    }
    
        public CSVRecord getSmallestOfTwo (CSVRecord currentRow, CSVRecord smallestSoFar) {
        //If largestSoFar is nothing
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        }
        //Otherwise
        else {
            double currentTemp=9999;
            double smallestTemp =9999;
            if(!currentRow.get("Humidity").equals("N/A")){
               currentTemp = Double.parseDouble(currentRow.get("Humidity"));
            }
            if(!smallestSoFar.get("Humidity").equals("N/A")){
                smallestTemp = Double.parseDouble(smallestSoFar.get("Humidity"));
            }
            //Check if currentRow’s temperature > largestSoFar’s
            if ( currentTemp < smallestTemp){
                //If so update largestSoFar to currentRow
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }
    
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord smallestSoFar = null;
        File temp=null;
        DirectoryResource dr = new DirectoryResource();
        // iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            // use method to get largest in file.
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            // use method to compare two records
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar);
            if(temp==null){
                temp=f;
            }
            if(smallestSoFar==currentRow){
                temp=f;
            }
        }
        //System.out.println("Coldest day was in file "+temp.getName());
        return smallestSoFar;
    }
    
    public void testLowestHumidityInManyFiles()  {
        CSVRecord smallest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + smallest.get("Humidity") +
                   " at " + smallest.get("DateUTC"));
    }


}
