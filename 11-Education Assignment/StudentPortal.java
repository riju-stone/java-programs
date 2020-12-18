import admission.*;
import education.*;

import java.util.Scanner;

class StudentPortal {
    public static void main(String args[]){
        int choice, size = 0;
        String cond;

        Scanner in = new Scanner(System.in);
        StudentPortal obj = new StudentPortal();

        do{
            System.out.println("====== Welcome ======");
            System.out.println("What do you wanna do ?");
            System.out.println("1. Admission Section");
            System.out.println("2. Library Section");
            System.out.println("3. Assignment Section");
            System.out.println("4. Examination Section");
            System.out.println("Enter you choice");
            choice = in.nextInt();

            StudentDetails std = new StudentDetails();

            switch(choice){
                case 1:
                System.out.println("---- Welcome to Admission Section ----");
                    System.out.println("Enter number of students");
                    size = in.nextInt();

                    std.storeDetails(size);
                    std.displayDetails();
                break;
                case 2:
                    System.out.println("---- Welcome to Library Section ----");
                    obj.libSec();
                break;
                case 3:
                    System.out.println("---- Welcome to the Assignment Section ----");
                    obj.assignSec();
                break;
                case 4:
                    System.out.println("---- Welcome to the Examination Section ----");
                    obj.examSec(std);
                break;
                default:
                    System.out.println("Invalid Choice...");
            }
            System.out.println("Do want to visit another section ? (Y/N)");
            cond = in.next();
        }while(cond.equalsIgnoreCase("y"));

        System.out.println("Thank You for Visiting...");
    }

    void libSec(){
        int ch;
        Library lib = new Library();
        Scanner in = new Scanner(System.in);

        String bname;
        int roll, dos;
        double fine;

        System.out.println("State your purpose");
        System.out.println("1. Take a book");
        System.out.println("2. Return a book");
        System.out.println("Enter choice");
        ch = in.nextInt();

        switch(ch){
            case 1:
                System.out.println("Enter your roll number");
                roll = in.nextInt();
                in.nextLine();
                System.out.println("Enter book name");
                bname = in.nextLine();

                lib.takeBooks(bname, roll);
            break;
            case 2:
                System.out.println("Enter your roll number");
                roll = in.nextInt();
                in.nextLine();
                System.out.println("Enter book name");
                bname = in.nextLine();
                System.out.println("For how many days did you keep the book ?");
                dos = in.nextInt();

                fine = lib.returnBooks(bname, roll, dos);

                if(fine == 0){
                    System.out.println("You returned the book on time !");
                    System.out.println("So, no fine was levied...");
                } else {
                    System.out.println("You could't return the book on time !");
                    System.out.println("So, a fine of Rs. "+fine+" was levied...");
                }

            break;
            default:
                System.out.println("Invalid Choice");
        }
    }

    void assignSec(){
        Scanner in = new Scanner(System.in);
        Assignment assign = new Assignment();

        String assignmentName;
        String assignmentDate;
        int roll;

        System.out.println("Enter your roll number");
        roll = in.nextInt();
        in.nextLine();
        System.out.println("Enter book name");
        assignmentName = in.nextLine();
        System.out.println("For how many days did you keep the book ?");
        assignmentDate = in.nextLine();

        assign.submissionDate(roll, assignmentName, assignmentDate);
    }

    void examSec(StudentDetails std){
        Scanner in = new Scanner(System.in);
        Exam ex = new Exam();

        String subjectNames[];
        int subjectMarks[];
        int roll, subjects;

        System.out.println("Enter your roll number");
        roll = in.nextInt();
        in.nextLine();
        System.out.println("Enter number of subjects");
        subjects = in.nextInt();

        subjectNames = new String[subjects];
        subjectMarks = new int[subjects];

        System.out.println("Enter subject names and marks");
        for(int i = 0; i < subjects; i++){
            System.out.println("Enter name");
            subjectNames[i] = in.nextLine();
            in.nextLine();
            System.out.println("Enter marks");
            subjectMarks[i] = in.nextInt();
        }

        ex.display(roll, subjectNames, subjectMarks, std);
    }
}
