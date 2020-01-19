public  class Calculator {

    public static int calculate(int a, int b, char sign) {
        switch (sign) {
            case ('+'):
                return a + b;
            case ('-'):
                return a - b;
            case ('*'):
                return a * b;
            case ('/'):
                    return a / b;

            default:
                throw new IncorrectInput();
        }
    }
}
