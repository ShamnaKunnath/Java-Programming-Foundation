
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene (String dna){
    String result="";
    int startIndex=dna.indexOf("ATG");
    if(startIndex==-1){
    return "";
    }
    int stopIndex=dna.indexOf("TAA",startIndex+3);
    if(stopIndex==-1){
    return "";
    }
    if((stopIndex-startIndex)%3!=0){
    return "";
    }
    result=dna.substring(startIndex,stopIndex+3);
    return result;
    }
    
    public void testSimpleGene(){
        //case 1:no "ATG"
    String dna="AAATGCCCTAACTAGATTAAGAAACC";
    System.out.println("DNA strand is "+dna);
    String gene=findSimpleGene(dna);
    System.out.println("DNA strand is "+gene);
    
    //case 2: no "TAA"
    dna="CGAATG";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna);
    System.out.println("DNA strand is "+gene);
    
    //case 3: no "ATG" or "TAA"
    dna="CGgTTTTAGG";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna);
    System.out.println("DNA strand is "+gene);
    
    //case 4: gene length is a multiple of 3
    dna="ATGACCTTTGACTAA";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna);
    System.out.println("DNA strand is "+gene);
    
    //case 5: gene length is not a multiple of 3
    dna="ATGACCTTTGATAA";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna);
    System.out.println("DNA strand is "+gene);

    }

}
