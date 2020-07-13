
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    public int countGenes(String dna){
    int startIndex=0;
    int c=0;
    while(true){
        String currGene=findGene(dna,startIndex);
        if(currGene.isEmpty()){
        break;
        }
        c=c+1;
        startIndex=dna.indexOf(currGene,startIndex)+currGene.length();
    }
    return c;
    }
    
    public void testCountGenes(){
    System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
    System.out.println(countGenes("TAAGATGCCCTAGT")); 
    System.out.println(countGenes("TAAGCCCTAGT")); 
    }
    

}
