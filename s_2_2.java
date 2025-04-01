import java.io.*;import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class info extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
// Set response content type
response.setContentType("text/html");
// Get server information
String serverInfo = getServletContext().getServerInfo();
// Get servlet names
Collection<? extends ServletRegistration> servletRegistrations =
getServletContext().getServletRegistrations().values();
// Output HTML response
PrintWriter out = response.getWriter();
out.println("<html>");
out.println("<head><title>Servlet Information</title></head>");
out.println("<body>");
out.println("<h2>Server Information:</h2>");
out.println("<p>Server Software: " + serverInfo + "</p>");
out.println("<h2>Loaded Servlets:</h2>");
for (ServletRegistration servletRegistration : servletRegistrations) {
out.println("<p>" + servletRegistration.getName() + "</p>");
}
out.println("</body>");
out.println("</html>");
}
}
