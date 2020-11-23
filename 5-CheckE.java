class CheckE {
    public static void main(String args[]){
        CheckE obj = new CheckE();

        for(String i : args){
            if(obj.checkForE(i)){
                System.out.println(i);
            }

        }
    }

    boolean checkForE(String s){
        char ab;
        int len = s.length();
        int flag = 0;

        for(int i = 0; i < len; i++){
            ab = s.charAt(i);
            if(ab == 'E' || ab == 'e'){
                flag = 1;
            }
        }
        if(flag == 1)
            return true;
        else  
            return false;  
    }
}
