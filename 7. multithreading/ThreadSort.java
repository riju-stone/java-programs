import java.io.*;

class ThreadSort {
    public static void main(String args[]) throws IOException
    {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter size of array");
        int s = Integer.parseInt(stdin.readLine());

        int a[] = new int[s];

        System.out.println("Enter array elements...");
        for(int i = 0; i < s; i++)
            a[i] = Integer.parseInt(stdin.readLine());

        BubbleSort bubbleThread = new BubbleSort(a);
        IndexSort indexThread = new IndexSort(a);

        bubbleThread.start();
        indexThread.start();
    }
}

class BubbleSort extends Thread{
    int arr[];
    BubbleSort(int a[]){
        this.arr = a;
    }

    public void run(){
        int n = arr.length;  
        int temp = 0;  

        long start, end, elapsed;

        start = System.nanoTime();
        for(int i=0; i < n; i++){  
            for(int j=1; j < (n-i); j++){  
                if(arr[j-1] > arr[j]){   
                    temp = arr[j-1];  
                    arr[j-1] = arr[j];  
                    arr[j] = temp;  
                }             
            }  
        }

        end = System.nanoTime();
        elapsed = end - start;

        System.out.println("======Bubble Sort======");
        for(int i=0; i < n; i++)
            System.out.println("Sorted by Bubble: "+arr[i]);

        System.out.println("Bubble Sort Took "+elapsed+" ns");
    }
}

class IndexSort extends Thread{
    int arr[];
    IndexSort(int a[]){
        this.arr = a;
    }
    
    public void run(){
        int n = arr.length;  
        int temp = 0;  
        int index[] = new int[n];

        long start, end, elapsed;

        start = System.nanoTime();

        for(int i = 0; i < n; i++)
            index[i] = i;
        
        for(int i = 0; i < n-1; i++){  
            for(int j = i+1; j < n; j++){  
                if(arr[index[i]] > arr[index[j]]){   
                    temp = index[i];  
                    index[i] = index[j];  
                    index[j] = temp;  
                }             
            }  
        }

        end = System.nanoTime();
        elapsed = end - start;

        System.out.println("======Index Sort======");
        for(int i=0; i < n; i++)
            System.out.println("Sorted by Index: "+arr[index[i]]);

        System.out.println("Index Sort Took "+elapsed+" ns");
    }
}
