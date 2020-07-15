
/**
 * Write a description of WhichCountriesExporters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class WhichCountriesExporters {
    public void listExporters(CSVParser parser,String exportOfInterest){
    for(CSVRecord record : parser){
        String export=record.get("Exports");
        if(export.contains(exportOfInterest)){
            System.out.println(record.get("Country"));
        }
    }
    
    }
    public void whoExportscoffee(){
        FileResource fr= new FileResource();
        CSVParser parser=fr.getCSVParser();
        listExporters(parser,"coffee");
    }

}
