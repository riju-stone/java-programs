package education;

public class Exam{
    public void display(int roll, String subjects[], int marks[], StudentDetails std){
        int pos = 0, flag = 0;
        float per = 0.0f;

        for(int i = 0; i < std.roll.length; i++){
            if(roll == std.roll[i]){
                flag = 1;
                pos = i;
            }
        }
        if(flag == 0){
            System.out.println("You are not yet admitted...");
        }
        else{
            per = calcPercent(marks);

            System.out.println("Roll No - "+roll+" Report Card");
            System.out.println("Name - "+std.name[pos]);
            System.out.println("Course - "+std.course[pos]);
            System.out.println("Marks Statement");
            for(int i = 0; i < subjects.length; i++)
                System.out.println("\t"+subjects[i]+" : "+marks[i]+" out of 100");
            System.out.println("Percentage : "+per+"%");
        }
    }

    private float calcPercent(int marks[]){
        float percent = 0.0f, sum = 0.0f;
        int totalMarks = marks.length * 100;

        for(int i = 0; i < marks.length; i++)
            sum += marks[i];

        percent = sum / totalMarks;
        return percent;
    }
}


