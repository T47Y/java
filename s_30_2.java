import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class table extends JFrame {
private JTable table;
public table() {
super("Teacher Information");
// Create a panel for holding the table
JPanel panel = new JPanel(new BorderLayout());
getContentPane().add(panel);
// Create a scroll pane for the table
JScrollPane scrollPane = new JScrollPane();panel.add(scrollPane, BorderLayout.CENTER);
// Create a table model
DefaultTableModel model = new DefaultTableModel();
// Set the column names
model.setColumnIdentifiers(new String[]{"Teacher ID", "Name",
"Subject"});
// Create the table with the model
table = new JTable(model);
// Set table properties
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);
// Add the table to the scroll pane
scrollPane.setViewportView(table);
// Populate the table
try {
Class.forName("org.postgresql.Driver");
Connection con =
DriverManager.getConnection("jdbc:postgresql://localhost:5432/ty92","ty92","ty
92");
Statement stmt =
con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
ResultSet.CONCUR_READ_ONLY);
ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");
// Populate the table model with data from the ResultSet
while (rs.next()) {
int no = rs.getInt("tno");
String name = rs.getString("tname");
String subject = rs.getString("subject");
model.addRow(new Object[]{no, name, subject});
}
} catch (SQLException | ClassNotFoundException e) {
System.out.println(e);
}
// Set frame properties
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(600, 400);
setLocationRelativeTo(null);
setVisible(true);
}
public static void main(String[] args) {
new table();
}
}
