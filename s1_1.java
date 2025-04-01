public class alfha extends Thread {
public void run() {
try {
for(char c = 'A'; c <= 'Z'; c++) {
System.out.println("Generated Charachter: " + c);
Thread.sleep(2000);
}
} catch(InterruptedException e) {
System.out.println(e);
}
}
public static void main(String args[]) {
alfha t1 = new alfha();
t1.start();
}
}
