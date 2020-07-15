
/**
 * Write a description of Assgnment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Assgnment {
 public String countryInfo(CSVParser parser,String country){
    String info="NOT FOUND";
    for(CSVRecord record : parser){
        if(country.contains(record.get("Country"))){
            return(country+":"+record.get("Exports")+":"+record.get("Value (dollars)"));
        }
        
    }
    return info;
    }
 public int numberOfExporters(CSVParser parser,String exportItem){
     int count=0;
     for(CSVRecord record : parser){
         String export = record.get("Exports");
         if(export.contains(exportItem)){
             count=count +1;
         }
     }
     return count;
 }
 public void bigExporters(CSVParser parser,String amount){
     for(CSVRecord record : parser){
         String value=record.get("Value (dollars)");
         if(value.length() > amount.length()){
            System.out.println(record.get("Country")+" "+value);
         }
       
     }
 }
 public void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
     for(CSVRecord record : parser){
         String exports=record.get("Exports");
         if(exports.contains(exportItem1) && exports.contains(exportItem2)){
             System.out.println(record.get("Country"));
            }
     }
 }
 
 public void tester(){
        FileResource fr= new FileResource();
        CSVParser parser=fr.getCSVParser();
        System.out.println(countryInfo(parser,"Nauru"));
        System.out.println("..............................");
        
        parser=fr.getCSVParser();
        listExportersTwoProducts(parser,"fish","nuts");
        System.out.println("..............................");
        
        parser=fr.getCSVParser();
        System.out.println(numberOfExporters(parser,"gold"));
        System.out.println("..............................");
        
        parser=fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
 }

}
