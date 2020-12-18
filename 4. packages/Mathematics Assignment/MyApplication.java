import mathematics.geometry.*;
import mathematics.algebra.TwoDEquation;
import java.util.Scanner;

class MyApplication {

    private static Scanner in;
    public static void main(String args[]){

        int choice, cond, side;
        float sides[];
        double a, b, c;
        in = new Scanner(System.in);
        MyApplication obj = new MyApplication();

        do{
            System.out.println("1. Calculate Root of a Quadratic Equation");
            System.out.println("2. Calculate Area and Perimeter of a Square, Rectangle or Triangle");
            System.out.println("Enter Choice");
            choice = in.nextInt();

            switch(choice){
                case 1:
                    TwoDEquation root = new TwoDEquation();

                    System.out.println("Enter coefficient of X^2");
                    a = in.nextDouble();
                    System.out.println("Enter coefficient of X");
                    b = in.nextDouble();
                    System.out.println("Enter constant");
                    c = in.nextDouble();

                    root.calcRoot(a, b, c);
                break;
                case 2:
                    System.out.println("Enter number of sides");
                    side = in.nextInt();
                    sides = new float[side];
                    
                    if(side == 3){
                        System.out.println("Did you mean a Triangle ?");
                        Triangle tri = new Triangle();
                        sides = obj.inputSides(side);
                        tri.perimeter(sides);
                        tri.area(sides);

                    }
                    else if(side == 4){
                        System.out.println("Hmm a four sided figure...");
                        Rectangle rec = new Rectangle();
                        sides = obj.inputSides(2);
                        rec.perimeter(sides);
                        rec.area(sides);
                    }
                break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println("Give it another go ? (1 = Yes, 0 = No)");
            cond = in.nextInt();
        }while(cond == 1);
    }

    float[] inputSides(int noofsides) {

        in = new Scanner(System.in);
        float sides[] = new float[noofsides];
        for(int i = 0; i < noofsides; i++){
            System.out.println("Enter Side Length(in cm)");
            sides[i] = in.nextFloat();
        }
        return sides;
    }
}
