package untitled.src;

/**
 * @author guojinren
 * @be created at 2020-02-22-20:29
 */
class Window extends Thread{
    private static int ticket = 100;

    Object obj = new Object();

    @Override
    public void run() {
        while(true) {
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(getName() + "卖票，票号为：" + ticket--);
                } else
                    break;
            }
        }
    }
}
