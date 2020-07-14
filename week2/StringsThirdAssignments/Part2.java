
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
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
    
    public void test(){
    System.out.println(cgRatio("ATGCCATAG"));
    String dna="CTG";
    System.out.println("count of CTG in "+dna+" is "+countCTG(dna));
    dna="AATTTCTGAACTGTT";
    System.out.println("count of CTG in "+dna+" is "+countCTG(dna));
    dna="CTGCTGCTG";
    System.out.println("count of CTG in "+dna+" is "+countCTG(dna));
    }

}
