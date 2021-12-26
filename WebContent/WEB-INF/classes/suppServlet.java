import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models1.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class suppServlet
 */
@WebServlet("/suppServlet")
public class suppServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet (HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException 
	{
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
				String id =request.getParameter("id");
				
				
				PreparedStatement psUsers = conn.prepareStatement("DELETE FROM etudiant WHERE id = ?");
		    	psUsers.setString(1,id);
				
				int rsUsers = psUsers.executeUpdate();
		        
		    	
			if (rsUsers==1) {
				PreparedStatement psEtudiant = conn.prepareStatement("SELECT * FROM etudiant");
				ResultSet rsEtud = psEtudiant.executeQuery();
				 List<Etudiant> etudiants = new ArrayList<Etudiant>();
				 while (rsEtud.next()) {
					int id1 = rsEtud.getInt("id");
					String  nom1 = rsEtud.getString("nom");
					String prenom1 = rsEtud.getString("prenom");
					String  classe1 = rsEtud.getString("classe");
					Etudiant e = new Etudiant (id1,nom1,prenom1,classe1);
					etudiants.add(e);
					
				}
		
				request.setAttribute("etudiants", etudiants);
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/listeEtudiant.jsp");
				dispatcher.forward(request, response);
	        }
	        
	       
			else {
				out.print("<h1>échec a la suppression</h1>");
			}
				
				
				// SQL delete
				/*PreparedStatement psRetrait = conn.prepareStatement("DELETE FROM banque WHERE id = ?");
				psRetrait.setInt(1, 1);
				psRetrait.executeUpdate();*/
				
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
		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
		
		
	
}
