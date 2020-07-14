import java.io.*;
import edu.duke.*;
/**
 * Write a description of Part3b here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3b {
public float cgRatio(String dna){
        int Ccount=0;
        int index=dna.indexOf("C");
        while(index!=-1){
        Ccount=Ccount+1;
        index=dna.indexOf("C",index+1);
        }
        int Gcount=0;
        index=dna.indexOf("G");
        while(index!=-1){
        Gcount=Gcount+1;
        index=dna.indexOf("G",index+1);
        }
        return (float)(Ccount+Gcount)/dna.length();
    }
    public int countCTG(String dna){
    int index=dna.indexOf("CTG");
    int count=0;
    while(index!=-1){
    count=count+1;
    index=dna.indexOf("CTG",index+3);
    }
    return count;
    }
    
    public void processGenes(StorageResource sr){
    int length9=0;
    int cgValue=0;
    int max=0;
    int total=0;
    String maxLenstring="";
    for(String s : sr.data()){
        total=total+1;
        if(s.length()>60){
            length9=length9+1;
            System.out.println("Length greter than 60 "+s);
        }
        
        if(cgRatio(s)>.35){
        cgValue=cgValue+1;
        System.out.println("CGratio greater than .35"+s);
        }
        
        if(s.length()>max){
        maxLenstring=s;
        max=s.length();
        }
    }
    System.out.println("Total genes "+total);
    System.out.println("No of genes with len>60 "+length9);
    System.out.println("No of genes with cgRatio>.35 "+cgValue);
    System.out.println("Longest gene "+maxLenstring+" with length "+ max);
    
    }
    
    
       public int findStopCodon(String dna,int startIndex,String stopCodon){
        int currIndex=dna.indexOf(stopCodon,startIndex+3);
        while(currIndex!=-1){
        if((currIndex-startIndex)%3==0){
        return currIndex;
        }
        currIndex=dna.indexOf(stopCodon,currIndex+1);
        }
        return dna.length();
    }
    public String findGene(String dna,int where){
        int startIndex=dna.indexOf("ATG",where);
        if(startIndex==-1){
        return "";
        }
        int taaindex=findStopCodon(dna,startIndex,"TAA");
        int tagindex=findStopCodon(dna,startIndex,"TAG");
        int tgaindex=findStopCodon(dna,startIndex,"TGA");
        int minindex=Math.min(taaindex,Math.min(tagindex,tgaindex));
        if(minindex==dna.length()){
        return "";
        }
        return dna.substring(startIndex,minindex+3);

    }
    public StorageResource getAllGenes(String dna){
    StorageResource genes= new StorageResource();
    int startIndex=0;
    while(true){
        String currGene=findGene(dna,startIndex);
        if(currGene.isEmpty()){
        break;
        }
        genes.add(currGene);
        startIndex=dna.indexOf(currGene,startIndex)+currGene.length();
    }
    return genes;
    }
    
    public void testProcessGenes(){
    FileResource fr = new FileResource("brca1line.fa");
    String dna = fr.asString();
    StorageResource genes= getAllGenes(dna);
    processGenes(genes);
    System.out.println("Count of CTG "+countCTG(dna));
    }
}
