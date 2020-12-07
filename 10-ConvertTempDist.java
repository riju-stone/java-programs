import java.util.Scanner;

interface Convert{

    abstract double tempConv(double value);

    abstract double distConv(double value);

    abstract void display(double val, String unit);
}

class Temperature implements Convert{
    protected double cel;

    Temperature(){
        this.cel = 0.0d;
    }

    double input(){
        Scanner in = new Scanner(System.in);
        double cel;

        System.out.println("Enter temperature in celcius");
        cel = in.nextDouble();

        in.close();
        return cel;
    }

    @Override
    public double tempConv(double value){
        return ((value * 9/5) + 32);
    }

    @Override
    public void display(double val, String unit){
        System.out.println("Converted Result: "+val+" "+unit);
    }

    //Left Unimplimented
    public double distConv(double value){
        return value;
    }

}

class Distance implements Convert{
   protected double feet;

   Distance(){
       this.feet = 0.0d;
   }

   double input(){
        Scanner in = new Scanner(System.in);
        double feet;

        System.out.println("Enter temperature in feet");
        feet = in.nextDouble();

        in.close();
        return feet;
    }

    @Override
    public double distConv(double value) {
        return (value * 12);
    }

    @Override
    public void display(double val, String unit){
        System.out.println("Converted Result: "+val+" "+unit);
    }

    //Left Unimplemented
    public double tempConv(double value){
        return value;
    }
}

class ConvertTempDist{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("Convert Temperature or Distance ?");
        System.out.println("Enter Choice (T/D)");

        char choice = in.next().charAt(0);

        double cel, feet;
        double res;

        switch(choice){
            case 'T':

                Temperature temp = new Temperature();
                cel = temp.input();
                res = Math.floor(temp.tempConv(cel));
                temp.display(res, "F");

                break;
            case 'D':

                Distance dist = new Distance();
                feet = dist.input();
                res = Math.floor(dist.distConv(feet));
                dist.display(res, "inch");

                break;
            default:
                System.out.println("More features soon...");
        } 
        
        in.close();
   }
}


