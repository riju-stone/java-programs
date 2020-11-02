import java.util.Scanner;

class Matrix_Addition {

    Scanner in = new Scanner(System.in);
    public static void main(String args[]) {
        int row = Integer.parseInt(args[0]);
        int col = Integer.parseInt(args[1]);

        int a[][] = new int[row][col];
        int b[][] = new int[row][col];
        int c[][] = new int[row][col];

        //Creating a class object to call a non-static function input()
        Matrix_Addition obj = new Matrix_Addition();

        System.out.println("Enter elements of 1st matrix...");
        obj.input(a, row, col);
        System.out.println("Enter elements of 2nd matrix...");
        obj.input(b, row, col);

        System.out.println("Adding the two matrices...");

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("You entered...");
        obj.display(a, row, col);
        System.out.println("And...");
        obj.display(b, row, col);
        System.out.println("Resultant matrix is...");
        obj.display(c, row, col);
    }

    private void input(int arr[][], int r, int c) {
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] = in.nextInt();
            }
        }
    }

    private void display(int arr[][], int r, int c){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
