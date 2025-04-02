import java.util.*;
public class sub {public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
LinkedList<String> list = new LinkedList<>();
System.out.print("\nEnter the number of subjects: ");
int n = sc.nextInt();
sc.nextLine();
for(int i=0; i<n; i++) {
System.out.print("Enter subject " + (i+1) + ": ");
list.add(sc.nextLine());
}
System.out.println("\nList items:-");
Iterator<String> itr = list.iterator();
while(itr.hasNext()) {
System.out.println(itr.next());
}
sc.close();
}
}
