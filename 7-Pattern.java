import java.util.Scanner;

class Pattern {
    public static void main(String args[]){
        Scanner in  = new Scanner(System.in);
        Pattern obj = new Pattern();

        String word = args[0];
        
        System.out.println("Enter your choice of pattern (Options 1 to 4)");
        int ch = in.nextInt();

        switch(ch){
            case 1:
                obj.patternForwardInverted(word);
                break;
            case 2:
                obj.patternBackwardsStraight(word);
                break;
            case 3:
                obj.patternForwardStraight(word);
                break;
            case 4:
                obj.patternBackwardsInverted(word);
                break;
            default:
                System.out.println("Invalid choice...");
        }

        in.close();
    }

    void patternForwardInverted(String s){
        int len = s.length();
        char ab;

        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                ab = s.charAt(j);
                System.out.print(ab+" ");
            }
            System.out.println();
        }
    }

    void patternBackwardsStraight(String s){
        int len = s.length();
        char ab;

        for(int i = 0; i < len; i++){
            for(int j = 0; j <= i; j++){
                ab = s.charAt(j);
                System.out.print(ab+" ");
            }
            System.out.println();
        }
    }

    void patternForwardStraight(String s){
        int len = s.length();
        char ab;

        for(int i = len-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                ab = s.charAt(j);
                System.out.print(ab+" ");
            }
            System.out.println();
        }
    }

    void patternBackwardsInverted(String s){
        int len = s.length();

        StringBuffer sbr = new StringBuffer(s);
        sbr.reverse();
        s = sbr.toString();

        char ab;
        int j;
        
        for(int i = 0; i < len; i++){
            j = i;
            while(j >= 0){
                ab = s.charAt(j);
                System.out.print(ab+" ");
                j--;
            }
            System.out.println();
        }
    }
}
