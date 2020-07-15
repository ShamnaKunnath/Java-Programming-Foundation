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
    //calls the method findStopCodon with several examples and prints out 
    //the results to check if findStopCodon is working correctly
    public void testFindStopCodon(){
    String dna="ATGTAATAGT";
    System.out.println("return (10)"+findStopCodon(dna,0,"AGT"));
    System.out.println("return (3)"+findStopCodon(dna,0,"TAA"));
    dna="AGTTTAATTTAA";
    System.out.println("return (9)"+findStopCodon(dna,0,"TAA"));    
    }
    
    public void testFindGene (){
        //case 1
        String dna="AATGCTAACTAGCTGACTAAT";
        System.out.println(dna);
        System.out.println(findGene(dna,0));
        //case 2
        dna="ATGCCCGTATAAGTAC";
        System.out.println(dna);
        System.out.println(findGene(dna,0));
        //case 3
        dna="ATGCCCGTATAATAGGTACTGATAA";
        System.out.println(dna);
        System.out.println(findGene(dna,0));
        //case 4
        dna="ATGCCCGTAGTACTTTAT";
        System.out.println(dna);
        System.out.println(findGene(dna,0));
        
        System.out.println("Testing printAllGenes.....");
        dna="ATGATCTAATTTATGCTGCAACGGTGAAGA";
        printAllGenes(dna);
    }
    public void printAllGenes(String dna){
    int startIndex=0;
    while(true){
        String currGene=findGene(dna,startIndex);
        if(currGene.isEmpty()){
        break;
        }
        System.out.println(currGene);
        startIndex=dna.indexOf(currGene,startIndex)+currGene.length();
    }
    }
    

}
