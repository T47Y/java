public class student {
public static void main(String args[]) {
Thread thread = Thread.currentThread();
System.out.println("\nThread Name: " + thread.getName());
System.out.println("Thread Priority: " + thread.getPriority());
}
}
