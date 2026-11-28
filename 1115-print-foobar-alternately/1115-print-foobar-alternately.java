class FooBar {
    private int n;
    private int flag;
    public FooBar(int n) {
        this.n = n;
        this.flag = 0;
    }
    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(flag != 0){
                wait();
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.

            
        	printFoo.run();
            flag = 1;

            notifyAll();
        }
    }

      public synchronized void bar(Runnable printBar) throws InterruptedException { 
        for (int i = 0; i < n; i++) {
            while (flag != 1) {
                wait();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = 0;
            notifyAll();
        }
    }
}
