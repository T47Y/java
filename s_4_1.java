import java.awt.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
public class run implements Runnable {
private JLabel label;
public run(JLabel label) {
this.label = label;
}
public void run() {
try {
while (true) {
label.setVisible(true);
TimeUnit.MILLISECONDS.sleep(500); // Text visible for 500 milliseconds
label.setVisible(false);
TimeUnit.MILLISECONDS.sleep(500); // Text invisible for 500 milliseconds
}
} catch (InterruptedException e) {
e.printStackTrace();
}
}
public static void main(String[] args) {
JFrame frame = new JFrame("Blinking Text");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(300, 200);
JLabel label = new JLabel("Blinking Text");
label.setFont(new Font("Arial", Font.PLAIN, 20));
label.setHorizontalAlignment(JLabel.CENTER);
frame.getContentPane().add(label, BorderLayout.CENTER);
run blinkingText = new run(label);
Thread thread = new Thread(blinkingText);
thread.start();
frame.setVisible(true);
}
}
