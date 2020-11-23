class SortInt {
    public static void main(String args[]){
        SortInt obj = new SortInt();

        int len = args.length;
        int num[] = new int[len+1];

        for(int i = 0; i < len; i++){
            num[i] = Integer.parseInt(args[i]);
        }

        System.out.println("You entered...");
        obj.display(num);
        obj.selectionSort(num);
    }   

    void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int max = array[i];
            int pos = i;
            for (int j = i+1; j < array.length-1; j++) {
                if (array[j] > max) {
                    max = array[j];
                    pos = j;
                }
            }
            int temp = array[i];
            array[i] = max;
            array[pos] = temp;
        }

        System.out.println("After Sorting");
        display(array);
    }

    void display(int []array){
        for(int i = 0; i < array.length-1; i++){
            System.out.print(array[i]+", ");
        }
        System.out.println();
    }
}
