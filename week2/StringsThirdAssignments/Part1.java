import edu.duke.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
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
    
    public void testOn(String dna){
    StorageResource genes=getAllGenes(dna);
    for (String s: genes.data()){
    System.out.println(s);
    }
    }
    
    public void test(){
    String dna="ATGTAAGATGCCCTAGT";
    System.out.println("Print all genes on"+ dna + ":");
    testOn(dna);
    dna="TAAGATGCCCTAGT";
    System.out.println("Print all genes on"+ dna + ":");
    testOn(dna);
    dna="TAAGCCCTAGT";
    System.out.println("Print all genes on"+ dna + ":");
    testOn(dna);
    }
}
