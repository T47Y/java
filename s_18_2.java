<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Details Form</title>
</head>
<body>
<h2>Enter Student Details</h2>
<form action="info" method="post">
<label for="seat_no">Seat No:</label>
<input type="text" id="seat_no" name="seat_no" required><br><br>
<label for="name">Name:</label>
<input type="text" id="name" name="name" required><br><br>
<label for="class">Class:</label>
<input type="text" id="class" name="class" required><br><br>
<label for="total_marks">Total Marks:</label>
<input type="text" id="total_marks" name="total_marks"
required><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>





import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class info extends HttpServlet {
public void doPost(HttpServletRequest req, HttpServletResponse res) throws
IOException, ServletException {
res.setContentType("text/html");
PrintWriter out = res.getWriter();
int seatNo = Integer.parseInt(req.getParameter("seat_no"));String name = req.getParameter("name");
String stu_class= req.getParameter("class");
int totalMarks = Integer.parseInt(req.getParameter("total_marks"));
double perc = (totalMarks / 500.0) * 100;
String grade;
if (perc >= 90) {
grade = "A+";
} else if (perc >= 80) {
grade = "A";
} else if (perc >= 70) {
grade = "B";
} else if (perc >= 60) {
grade = "C";
} else if (perc >= 50) {
grade = "D";
} else {
grade = "Fail!";
}
out.println("<html><head><title>Student
Details</title></head><body>");
out.println("<h2>Student Details</h2>");
out.println("<p>Seat No.: " + seatNo + "</p>");
out.println("<p>Name: " + name + "</p>");
out.println("<p>Class: " + stu_class + "</p>");
out.println("<p>Total Marks: " + totalMarks + "</p>");
out.println("<p>Percentage: " + perc + "</p>");
out.println("<p>Grade: " + grade + "</p>");
out.println("</body></html>");
out.close();
}
}
