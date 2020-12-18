import java.util.Scanner;

class Number{
    protected int num;
    Number(int n){
        this.num = n;
    }

    boolean checkPrime(int x){
        int c = 0;
        for(int i = 1; i <= x; i++){
            if(x % i == 0)
                c++;
        }
        return (c == 2);
    }
}

class PrimeFactors extends Number{
    PrimeFactors(int n) {
        super(n);
    }

    void calculateFactors(){
        System.out.println("Prime factors of "+num+" are:");
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(checkPrime(i) && num % i == 0){ 
                System.out.print(i+", ");
            }
        }
        System.out.println();
    }
}

class PrimeNumbers extends Number{
    PrimeNumbers(int n) {
        super(n);
    }

    void findPrime(){
        System.out.println("Prime number less than "+num+" are:");
        for(int i = 1; i <= num; i++){
            if(checkPrime(i))
                System.out.print(i+", ");
        }
        System.out.println();
    }
}

class PrimeInheritance {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a number...\n");
        int num = in.nextInt();
        
        PrimeFactors n = new PrimeFactors(num);
        long start = System.nanoTime();
        n.calculateFactors();
        long end = System.nanoTime();

        System.out.println("Time elapsed: "+(end-start)+" ns");
        
        PrimeNumbers p = new PrimeNumbers(num);
        p.findPrime();

        in.close();
    }
}
