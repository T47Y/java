public class name {
public static void main(String[] args) {
// Create and start a new thread
Thread thread = new Thread(new MyRunnable());
thread.start();// Display the name of the main thread
System.out.println("Main thread name: " +
Thread.currentThread().getName());
}
}
class MyRunnable implements Runnable {
public void run() {
System.out.println("Currently executing thread name: " +
Thread.currentThread().getName());
}
}
