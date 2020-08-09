package untitled.src;

/**
 * @author guojinren
 * @be created at 2020-02-22-21:00
 */

 class Window01 implements  Runnable{
        private static int ticket = 100;

        Object obj = new Object();
        @Override
        public void run() {
            while(true) {
                synchronized (obj) {
                    if (ticket > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket--);
                    } else
                        break;
                }
            }
        }
    }

public class TheardTest01 {
    public static void main(String[] args) {
        Window01 mThread = new  Window01();
        Thread t1 = new Thread(mThread);
        Thread t2 = new Thread(mThread);
        Thread t3 = new Thread(mThread);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }

}
