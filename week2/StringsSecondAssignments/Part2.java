
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa,String stringb){
    int c=0;
    int startIndex=stringb.indexOf(stringa);
    while(startIndex!=-1){
     c=c+1;
     startIndex=stringb.indexOf(stringa,startIndex+stringa.length());
    }
    return c;
}
    public void testHowMany(){
    System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
    System.out.println(howMany("AA", "ATAAAA"));
    System.out.println(howMany("AA", "BBBBB"));
    System.out.println(howMany("AA", "ATAAAAAAAA"));
    }
}
