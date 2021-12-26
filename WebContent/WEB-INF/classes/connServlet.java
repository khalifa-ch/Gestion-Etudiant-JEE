import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models1.Etudiant ;
/**
 * Servlet implementation class connServet
 */
@WebServlet("/connServlet")
public class connServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection  conn;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public connServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		 
		 try {
				/**********************************************/
				String strClassName = "com.mysql.jdbc.Driver";
				Class.forName(strClassName);
		         String url = "jdbc:mysql://localhost:3306/projetjee";
		            String user = "root";
		            String password = "";
		            Connection  conn = DriverManager.getConnection(url, user, password);
		            /***********************************/
		            
		        	response.setContentType("text/html");
					PrintWriter out = response.getWriter(); 
					String login =request.getParameter("login");
					String pass =request.getParameter("password");
					
					
					PreparedStatement psUsers = conn.prepareStatement("SELECT * FROM utilisateur WHERE login = ? AND password = ?");
					psUsers.setString(1,login);
					psUsers.setString (2,pass);
			        ResultSet rsUsers = psUsers.executeQuery();
					
				if (rsUsers.next()) {
					PreparedStatement psEtudiant = conn.prepareStatement("SELECT * FROM etudiant");
					ResultSet rsEtud = psEtudiant.executeQuery();
					 List<Etudiant> etudiants = new ArrayList<Etudiant>();
					while (rsEtud.next()) {
						int id = rsEtud.getInt("id");
						String  nom = rsEtud.getString("nom");
						String prenom = rsEtud.getString("prenom");
						String  classe = rsEtud.getString("classe");
						Etudiant e = new Etudiant (id,nom,prenom,classe);
						etudiants.add(e);
						
					}
			
					request.setAttribute("etudiants", etudiants);
					ServletContext context = getServletContext();
					RequestDispatcher dispatcher = context.getRequestDispatcher("/listeEtudiant.jsp");
					dispatcher.forward(request, response);
				} 
				else {
					out.print("<h1>échec a la l'auth</h1>");
				}
				
			
					out.print("</html>");
					out.close();
					
			
				conn.close();
				}
				catch(ClassNotFoundException e) {
					System.out.println("Driver non chargé !");
					e.printStackTrace(); 
				} catch(SQLException e) {
					System.out.println(e);
			
				} 


		
		}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);		
} 
	 }