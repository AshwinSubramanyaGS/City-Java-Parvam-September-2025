import java.util.ArrayList;
import java.util.Collections;
public class Exercise4{
    public static void main(String args[]){
        ArrayList<String> strings= new ArrayList<>();
        Collections.addAll(strings,"1", "2","3", "4");
        ArrayList<String> newStrings= new ArrayList<>();
        for(int i=strings.size()-1;i>=0;i--){
            newStrings.add(strings.get(i));
        }
        
        for(String s: newStrings){
            System.out.print(s+" ");
        }
    }
}