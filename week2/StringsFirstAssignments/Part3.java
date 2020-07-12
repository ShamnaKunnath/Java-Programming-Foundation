
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa,String stringb){
        int temp1=stringb.indexOf(stringa);
        if(temp1==-1){
        return false;
        }
        int temp2=stringb.indexOf(stringa,temp1+1);
        if(temp2==-1){
        return false;
        }
        return true;
    }
    
    public String lastPart(String stringa,String stringb){
    int temp=stringb.indexOf(stringa);
    if(temp==-1){
    return stringb;
    }
    int len=stringa.length();
    return stringb.substring(temp+len);
    }

    public void testing(){
        //case1
        boolean bool=twoOccurrences("by", "A story by Abby Long");
        System.out.println(bool);
        //case2
        bool=twoOccurrences("a", "banana");
        System.out.println(bool);
        //case3
        bool=twoOccurrences("atg", "ctgtatgta");
        System.out.println(bool);
        
        //case1
        String stringa="an";
        String stringb="banana";
        String result=lastPart(stringa,stringb);
        System.out.println("The part of the string after "+stringa + " in " +stringb + " is "+ result);
        //case2
        stringa="zoo";
        stringb="forest";
        result=lastPart(stringa,stringb);
        System.out.println("The part of the string after "+stringa + " in " +stringb + " is "+ result);
    }
    
}
