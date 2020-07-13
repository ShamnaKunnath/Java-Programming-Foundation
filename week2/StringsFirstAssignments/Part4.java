
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class Part4 {
    public void method(){
    int pos=0;
    URLResource url =new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    String str="";
    String result="";
    int start=0;
    int end=0;
    int c=0;
    for (String word : url.words()) {
        c=c+1;
        str=word.toLowerCase();
        pos=str.indexOf("youtube.com");
        if(pos!=-1){
        start=str.lastIndexOf("\"", pos);
        end=str.indexOf("\"",pos+1);
        result=word.substring(start+1,end); 
        System.out.println(result);
       }
    }
}
}
//(taaindex==-1||(tgaindex!=-1 &&tgaindex<taaindex))  minIndex=tgaindex;

