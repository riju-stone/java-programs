import java.util.Scanner;

class Height{
    private int m, cm;

    Height(int m, int cm){
        this.m = m;
        this.cm = cm;
    }

    Height Add(Height h){
        Height res = new Height(this.m, this.cm);
        res.m = this.m + h.m;
        res.cm = this.cm + h.cm;

        if(res.cm >= 100){
            res.m += res.cm / 100;
            res.cm = res.cm % 100;
        }

        return res;
    }

    void display(){
        System.out.println("The added height is: ");
        System.out.println(this.m+" m "+this.cm+" cm");
    }
}

class AddedHeight{
    public static void main(String args[]){
        int m1, cm1, m2, cm2;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter 1st Height in meter and centimeter");
        m1 = in.nextInt();
        cm1 = in.nextInt();

        System.out.println("Enter 2nd Height in meter and centimeter");
        m2 = in.nextInt();
        cm2 = in.nextInt();

        Height h1 = new Height(m1, cm1);
        Height h2 = new Height(m2, cm2);
        Height h3 = h1.Add(h2);

        h3.display();
        in.close();
    }
}
