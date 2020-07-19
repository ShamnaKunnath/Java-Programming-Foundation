/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("Number of girl names = " + totalGirls);
        System.out.println("Number of boys names = " + totalBoys);
    }
    
    public int getRank(int year,String name,String gender){
        int rank=0;
        String filename="data/yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)){
                rank+=1;
            }
            if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
                return rank;
            }
        }
        return -1;
    }
    public String getName(int year,int rank,String gender){
        String s="NO NAME";
        int c=0;
        String filename="data/yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender)){
                c+=1;
            }
            if(c==rank){
            return rec.get(0);
            }
        }
        return s;
    }
    public String whatIsNameInYear(String name,int year,int newYear,String gender){
        int rank=getRank(year,name,gender);
        String newName=getName(newYear,rank,gender);
        return newName;
    }
    
    public int yearOfHighestRank(String name,String gender){
        int highestRank=-1;
        int finalyear=-1;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String filename=f.getName();
            String year=filename.substring(3,7);
            int yr=Integer.parseInt(year);
            int rank=getRank(yr,name,gender);
            if(highestRank<0 || (rank>0 && rank<highestRank)){
                highestRank=rank;
                finalyear=yr;
            }
        }
        return finalyear;
    }
    
    public double  getAverageRank(String name,String gender){
        double avgRank=-1.0;
        double total=0.0;
        int c=0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            String filename=f.getName();
            String year=filename.substring(3,7);
            int yr=Integer.parseInt(year);
            int rank=getRank(yr,name,gender);
            if(rank<0){
                return avgRank;
            }
            total+=rank;
            c+=1;
        }
        return total/c;
    }
    
    public int getTotalBirthsRankedHigher(int year,String name,String gender){
        int rank=getRank(year,name,gender);
        int birth=0;
        String filename="data/yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        for (CSVRecord rec : fr.getCSVParser(false)) {
            if(rec.get(1).equals(gender) && rank>1){
                birth+=Integer.parseInt(rec.get(2));
                rank-=1;
            }
        }
        return birth;
    }
    
    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource();
        totalBirths(fr);
        
    }
    
    public void testGetRank(){
       System.out.println(getRank(1971,"Frank","M")); 
    }
    
    public void testGetName(){
        System.out.println(getName(1982,450,"M")); 
    }
    
    public void testwhatIsNameInYear(){
        String name="Owen";
        int year=1974;
        int newYear=2014;
        System.out.println(name+" born in "+year+"  would be "+whatIsNameInYear(name,year,newYear,"M")+" if she was born in "+newYear);
    }
    
    public void testyearOfHighestRank(){
        System.out.println(yearOfHighestRank("Mich","M"));
    }
    
    public void testgetAverageRank(){
        System.out.println(getAverageRank("Robert","M"));
        //System.out.println(getAverageRank("Jacob","M"));
    }
    public void testgetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher(1990,"Drew","M"));
        
    }
}
