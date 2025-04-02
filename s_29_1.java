import java.sql.*;
public class info {
public static void main(String args[]) {
try {
Class.forName("org.postgresql.Driver");
Connection con =
DriverManager.getConnection("jdbc:postgresql://localhost:5432/ty92","ty92","ty
92");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM Donor");
ResultSetMetaData rsmd = rs.getMetaData();
for(int i = 1; i <= rsmd.getColumnCount(); i++) {
System.out.println("Column Name: " + rsmd.getColumnName(i));
System.out.println("Data Type: " + rsmd.getColumnTypeName(i));
System.out.println("Column Type: " + rsmd.getColumnType(i));
System.out.println("------------------------------------------
--------");
}
} catch (SQLException | ClassNotFoundException e) {
System.out.println(e);
}
}
}
