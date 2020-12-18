package admission;

public class Library {
    public void takeBooks(String bname, int roll){
        if(bname.equals("")){
            System.out.println("You didn't specify any book");
        }
        else
            System.out.println(bname+" was loaned to student with roll "+roll+" for 10 days.");
    }

    public double returnBooks(String bname, int roll, int noofdays){
        double fine = 0.0d;

        if(noofdays >= 10){
            fine = 30.0d;
        }
        return fine;
    }
}
