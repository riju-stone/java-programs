import java.io.*;

class SingleLetterException extends Exception{
    SingleLetterException(String mssg){
        System.out.println("\n"+mssg+"\n");
    }
}

class ReverseWord {
    public static void main(String args[]) throws IOException{

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        ReverseWord obj = new ReverseWord();

        System.out.println("Enter your Sentence");
        String sen = stdin.readLine();
        sen = sen.trim();
        try{
            obj.parseSentence(sen);
        }
        catch(SingleLetterException e){
            e.getMessage();
        }
    }

    void parseSentence(String s) throws SingleLetterException {
        char ab;
        String word = "";

        int len = s.length();

        for(int i = 0; i < len; i++){
            ab = s.charAt(i);
            if(ab != ' ')
                word = word + ab;
            else{
                if(word.length() == 1)
                    throw new SingleLetterException("Exception: Single letter cannot be reversed");
                else{
                    reverse(word); 
                    word = "";
                }    
            }  
        }
    }

    void reverse(String w){
        char word[] = w.toCharArray();
        int len = word.length;

        for(int i = len -1; i >= 0; i--)
            System.out.print(word[i]);
        System.out.print(" ");
    }
}