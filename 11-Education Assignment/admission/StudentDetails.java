package admission;
import java.util.Scanner;

public class StudentDetails{
    public int age[], roll[];
    public String name[], course[];
    protected int size;

    public void storeDetails(int noofstudents){
        size = noofstudents;
        age = new int[size];
        roll = new int[size];
        name = new String[size];
        course = new String[size];

        Scanner in = new Scanner(System.in);

        for(int i = 0; i < size; i++){
            if(i == 0)
                System.out.println("Enter details of "+(i + 1)+"st Student...");
            else if(i == 1)
                System.out.println("Enter details of "+(i + 1)+"nd Student...");
            else if(i == 2)
                System.out.println("Enter details of "+(i + 1)+"rd Student...");
            else
            System.out.println("Enter details of "+(i + 1)+"th Student...");
            
            System.out.print("Course : ");
            course[i] = in.nextLine();
            System.out.print("Name : ");
            name[i] = in.nextLine();
            System.out.print("Age : ");
            age[i] = in.nextInt();
            System.out.print("Roll : ");
            roll[i] = in.nextInt();
        }
    }

    public void displayDetails(){
        System.out.println("------------Student Details------------");
        System.out.print("Name\t");
        System.out.print("Age\t");
        System.out.print("Roll\t");
        System.out.print("Course\t");
        System.out.println();
        for(int i = 0; i < size; i++){
            System.out.print(name[i]+"\t");
            System.out.print(age[i]+"\t");
            System.out.print(roll[i]+"\t");
            System.out.print(course[i]+"\t");
            System.out.println();
        }
    }
}
