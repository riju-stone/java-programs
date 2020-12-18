package mathematics.geometry;

public class Rectangle {
    public void perimeter(float sides[]){
        float l = sides[0], b = sides[1];

        float perimeter = 2*(l + b);

        System.out.println("Perimeter is : "+perimeter + " cm");
    }

    public void area(float sides[]){
        float l = sides[0], b = sides[1];

        float area = l * b;

        System.out.println("Area is : "+area+ " squared cm");
    }
}
