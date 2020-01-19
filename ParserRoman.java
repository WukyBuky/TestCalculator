import java.util.HashMap;
import java.util.Map;

public class ParserRoman {
    String left, right;
    int validLeft, validRight;
    Map<String, Integer> alaphabet = new HashMap<>(10);

    public ParserRoman() {
        alaphabet.put("I",1);
        alaphabet.put("II",2);
        alaphabet.put("III",3);
        alaphabet.put("IV",4);
        alaphabet.put("V",5);
        alaphabet.put("VI",6);
        alaphabet.put("VII",7);
        alaphabet.put("VIII",8);
        alaphabet.put("IX",9);
        alaphabet.put("X",10);
    }


    public boolean parseString (String left, String right){
        if(alaphabet.containsKey(left)&alaphabet.containsKey(right)){
          validLeft=alaphabet.get(left);
          validRight=alaphabet.get(right);
          return true;
        } return false;
    }

}
