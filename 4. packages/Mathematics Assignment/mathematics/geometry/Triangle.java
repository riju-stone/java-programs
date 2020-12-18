package mathematics.geometry;

public class Triangle {
    public void perimeter(float sides[]){
        float perimeter = sides[0] + sides[1] + sides[2];

        System.out.println("Perimeter is :"+ perimeter+" cm");
    }

    public void area(float sides[]){
        float a = sides[0], b = sides[1], c = sides[2];

        if((a+b)>c && (a+c)>b && (b+c)>a)
          {
            float s=(a+b+c)/2;
            double  area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
             System.out.println("Area of Triangle is: " + area + " square cm");    
           }
         else  
           System.out.println("Triangle cannot exist");
    }
}
