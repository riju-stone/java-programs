class Calculator {
    public static void main(String args[]){

        int num = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[2]);
        char operator = args[1].charAt(0);

        float result = 0;

        switch(operator){
            case '+':
                result = num + num2;
                break;
            case '-':
                result = num - num2;
                break;
            case 'x':
                result = num * num2;
                break;
            case '/':
                result = (float) num / num2;
                break;
            default:
                System.out.println("Operator currently not supported...");
        }

        System.out.println("The result is: " + result);
    }
}
