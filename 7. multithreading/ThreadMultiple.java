class ThreadMultiple {
    public static void main(String args[]) {
        Multiple obj = new Multiple();
        MultipleThread threadA = new MultipleThread(50, obj);
        MultipleThread threadB = new MultipleThread(10, obj);

        threadA.start();
        threadB.start();
    }
}

class MultipleThread extends Thread{
    private Multiple tm = null;
    private int num = 0;

    MultipleThread(int value, Multiple ob) {
        this.tm = ob;
        this.num = value;
    }

    public void run(){
        tm.calcMultiple(num);
    }
}

class Multiple{
    public synchronized void calcMultiple(int n){
        for (int i = 1; i <= 5; i++) {
            System.out.println("Multiple of " + n + " x "+ i + " : " + (i * n));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}