
class ZeroEvenOdd {
    private int n;
    private int flag;
    
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.flag = 0;
        
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i<=n; i++){
            while(flag != 0){
                wait();
            }
            printNumber.accept(0);
            if(i%2 == 1){
                flag = 1;
            }else{
                flag = 2;
            }
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2; i<=n; i+=2){
            while(flag != 2){
                wait();
            }
            printNumber.accept(i);
            flag = 0;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i+=2){
            while(flag != 1){
                wait();
            }
            printNumber.accept(i);
            flag = 0;
            notifyAll();
        }
    }

}


