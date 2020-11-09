class String_Lexicographical_Sort{
    public static void main(String s[]) {
        Arrange sort = new Arrange(s);

        System.out.println("Original Array...\n");
        sort.display();
        sort.lexicographically();
        System.out.println("Array after Sorting...\n");
        sort.display();
    }
}

class Arrange{
    private String s[];
    Arrange(String str[]){
        this.s = str;
    }

    void lexicographically(){
        int len = s.length;
        String buffer;

        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(s[i].compareToIgnoreCase(s[j]) > 0){
                    buffer = s[i];
                    s[i] = s[j];
                    s[j] = buffer;
                }
            }
        } 
    }

    void display(){
        for(String word : s){
            System.out.print(word+",\t");
        }
        System.out.println();
    }
}