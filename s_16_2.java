import java.sql.*;
public class teacher{
public static void main(String args[]) {
try {
Class.forName("org.postgresql.Driver");
Connection con =
DriverManager.getConnection("jdbc:postgresql://localhost:5432/ty92","ty92","ty
92");Statement stmt = con.createStatement();
PreparedStatement pstmt = null;
stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Teacher (TNO int
primary key, TNAME varchar(20), SUBJECT varchar(20))");
System.out.println("Table exists / created!");
System.out.println("Inserting values into the table...");
pstmt = con.prepareStatement("INSERT INTO
Teacher(TNO,TNAME,SUBJECT) VALUES (?,?,?)");
insertTeacher(pstmt, 101, "Taskar", "JAVA");
insertTeacher(pstmt, 102, "Mahale", "DSA");
insertTeacher(pstmt, 103, "Deore", "C");
insertTeacher(pstmt, 104, "Patil", "CN");
insertTeacher(pstmt, 105, "Kapse", "OS");
System.out.println("\nRecords inserted successfully!");
System.out.println("\nDisplaying details of teachers teaching
'JAVA' subject...");
pstmt = con.prepareStatement("SELECT * FROM Teacher WHERE SUBJECT
= ?");
pstmt.setString(1,"JAVA");
ResultSet rs = pstmt.executeQuery();
while(rs.next()) {
int tno = rs.getInt("TNO");
String tname = rs.getString("TNAME");
String sub = rs.getString("SUBJECT");
System.out.println("\nTeacher No.: " + tno);
System.out.println("Teacher Name: " + tname);
System.out.println("Subject: " + sub);
}
rs.close();
pstmt.close();
con.close();
} catch (SQLException | ClassNotFoundException e) {
System.out.println(e);
}
}private static void insertTeacher(PreparedStatement pstmt, int tno, String
tname, String sub) throws SQLException {
pstmt.setInt(1, tno);
pstmt.setString(2, tname);
pstmt.setString(3, sub);
pstmt.executeUpdate();
}
}
