import java.util.Scanner;

class CountWords {
    int count = 0;
    public static void main(String args[]){
        CountWords obj = new CountWords();
        obj.input(args);
    }

    void input(String st[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your word...");
        String word = in.nextLine();

        int count = 0;

        for(String i : st){
            if(checkWord(word, i)){
                count++;
            }
        }

        System.out.println("The word '"+word+"' was encountered "+count+" times...");

        in.close();
    }

    boolean checkWord(String word, String s){
        if(word.equalsIgnoreCase(s))
            return true;
        else
            return false;
    }
}
