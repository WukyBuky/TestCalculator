public class ParserArabic  {

    int validLeft, validRight;



    public boolean parseString(String left, String right) {
        validLeft = Integer.parseInt(left);
        validRight = Integer.parseInt(right);
        if (validLeft >= 0 & validLeft < 10 & validRight >= 0 & validRight < 10) {
           // System.out.println(validLeft + "Arabic" + validRight);
            return true;
    } else return false;
    }


}
