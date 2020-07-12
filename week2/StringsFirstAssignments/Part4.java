
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
public class Part4 {
    public void method(){
    int temp=0;
    URLResource url=new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.htm");
    String str="";
    String result="";
    int start=0;
    int end=0;
    int c=0;
    for (String word : url.words()) {
        c=c+1;
        str=word.toLowerCase();
        temp=str.indexOf("youtube.com");
        if(temp!=-1){
        start=str.lastIndexOf("\"", temp);
        end=str.indexOf("\"",temp+1);
        result=word.substring(start+1,end); 
        System.out.println(result);
       }
    }
    System.out.println("total no of words: "+c);
}
}


