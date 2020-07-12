
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene (String dna,int startCodon,int stopCodon){
    String cpyDna= dna.toUpperCase();
    startCodon=cpyDna.indexOf("ATG");
    String result="";
    if(startCodon==-1){
    return "";
    }
    stopCodon=cpyDna.indexOf("TAA",startCodon+3);
    if(stopCodon==-1){
    return "";
    }
    if((startCodon-stopCodon)%3!=0){
    return "";
    }
    result=dna.substring(startCodon,stopCodon+3);
    return result;
    }
    
    public void testSimpleGene(){
        //case 1:no "ATG"
    String dna="CGATTAA";
    int startCodon=0;
    int stopCodon=0;
    System.out.println("DNA strand is "+dna);
    String gene=findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("DNA strand is "+gene);
    
    //case 2: no "TAA"
    dna="CGAATG";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("DNA strand is "+gene);
    
    //case 3: no "ATG" or "TAA"
    dna="CGGTTTTAGG";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("DNA strand is "+gene);
    
    //case 4: gene length is a multiple of 3
    dna="ATGACCTTTGACTAA";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("DNA strand is "+gene);
    
    //case 5: gene length is not a multiple of 3
    dna="ATGACCTTTGATAA";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("DNA strand is "+gene);
    
    //case 6: lowercase dna
    dna="atgacctttgactaa";
    System.out.println("DNA strand is "+dna);
    gene=findSimpleGene(dna,startCodon,stopCodon);
    System.out.println("DNA strand is "+gene);
    

    }

}
