class Buffer {
private String data;
private boolean produced;
Buffer() {
this.data = null;
this.produced = false;
}
public synchronized void produce(String item) throws InterruptedException
{
// Wait until the previous value is consumed
while (produced)
wait();
// Produce the new value
data = item;
produced = true;
System.out.println("Produced: " + item);// Notify the consumer
notify();
}
public synchronized String consume() throws InterruptedException {
// Wait until a new value is produced
while (!produced)
wait();
// Consume the produced value
String consumedItem = data;
produced = false;
System.out.println("Consumed: " + consumedItem);
// Notify the producer
notify();
return consumedItem;
}
}
class Producer extends Thread {
private String msg;
private Buffer buffer;
private int count;
Producer(String msg, Buffer buffer, int count) {
this.msg = msg;
this.buffer = buffer;
this.count = count;
}
public void run() {
try {
for (int i = 0; i < count; i++) {
buffer.produce(msg);
Thread.sleep(1000);
}
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
class Consumer extends Thread {
private Buffer buffer;
private int count;Consumer(Buffer buffer, int count) {
this.buffer = buffer;
this.count = count;
}
public void run() {
try {
for (int i = 0; i < count; i++) {
buffer.consume();
Thread.sleep(1000);
}
} catch (InterruptedException e) {
System.out.println(e);
}
}
}
public class info {
public static void main(String args[]) {
Buffer buffer = new Buffer();
Producer producer = new Producer("Hello!", buffer, 6);
Consumer consumer = new Consumer(buffer, 6);
producer.start();
consumer.start();
}
}
