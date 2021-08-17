class ThreadSync{
    public static void main(String args[]){
        ThreadSync obj = new ThreadSync();
        Thread threadA = new Counter(obj, 'A');
        Thread threadB = new Counter(obj, 'B');

        threadA.start();
        threadB.start();
    }
}

class Counter extends Thread{
    int count = 0;
    char id;
    protected ThreadSync sync = null;

    Counter(ThreadSync obj, char id){
        this.sync = obj;
        this.id = id;
    }

    public synchronized void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println("Thread id: "+id+" "+add(i));
        }
    }

    public int add(int value){
        this.count += value;
        return count;
    }
}
