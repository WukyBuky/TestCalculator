import java.util.Scanner;

public class Controller {

    private String input;
    private String left;
    private String right;
    private char sign;
    private char[] signs = {'+', '-', '*', '/'};
    ParserArabic parserArabic = new ParserArabic();
    ParserRoman parserRoman = new ParserRoman();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Controller c = new Controller();
        System.out.println("Введите  выражение вида\"1+2\" или \"VI/III\". Для выхода нажмите \"Enter\"");
        while (true) {

            c.parserCaller();
        }
    }

        public void parserCaller () {
            input = left = right = null;
            char choice = (getInput());
            if (choice >= '0' && choice <= '9') {
                if (parserArabic.parseString(left, right)) {
                    int result = Calculator.calculate(parserArabic.validLeft, parserArabic.validRight, sign);
                    System.out.println(result);
                }
                else throw new IncorrectInput();
            } else if (parserRoman.parseString(left.toUpperCase(), right.toUpperCase())) {
                int result = Calculator.calculate(parserRoman.validLeft, parserRoman.validRight, sign);
                System.out.println(convertToRoman(result));
            } else throw new IncorrectInput();
        }


        private String convertToRoman (int x){
            String output = "";
            if(x<0)
            {
                output="-";
                x = -x;
            }
            //x in [0,100]
            if (x==100)output+="C";
            else {
                if (x>=90){
                    output+="XC";
                    x-=90;
                }
                if (x >= 50) {
                    output += "L";
                    x-=50;
                }
                if(x>=40){
                    output+="XL";
                    x-=40;
                }
                else {
                    while (x>=10){
                        output+="X";
                        x-=10;
                    }
                }
                if (x==9) {
                    output += "IX";
                } else {
                    if (x<5){
                        if(x==4) {
                            output += "IV";
                        } else while (x>0){
                            output+="I";
                            x--;
                        }
                    } else {
                        output+="V";
                        x-=5;
                        while (x>0){
                            output+="I";
                            x--;
                        }
                    }
                }
            }
            return output;
        }

    private char getInput() {
        left = null;
        right = null;
        sign = 0;
        input = scanner.nextLine();
        for (int i = 0; i < signs.length; i++) {
            int x = input.indexOf(signs[i]);
            if (x > 0) {
                sign = input.charAt(x);
                left = input.substring(0, (x));
                right = input.substring(x + 1);
                break;
            }
        }
        return left.charAt(0); //добавить проверку на null
    }
}

