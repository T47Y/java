import java.util.*;
public class object {
public static void main(String args[]) {
LinkedList<Integer> list = new LinkedList<>();
list.add(20);
list.add(30);
System.out.println("\nOriginal Liked List: " + list);
list.addFirst(10);
System.out.println("\nLiked List after adding element at first
position: " + list);
list.removeLast();
System.out.println("\nLiked List after deleting the last element: " +
list);
System.out.println("\nSize of the Linked List: " + list.size());
}
}
