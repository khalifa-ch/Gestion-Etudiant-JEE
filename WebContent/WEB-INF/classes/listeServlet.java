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
 * Servlet implementation class listeServlet
 */
@WebServlet("/listeServlet")
public class listeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
				String id =request.getParameter("id");
				String nom =request.getParameter("nom");
				String prenom =request.getParameter("prenom");
				String classe =request.getParameter("classe");
				//String operation =request.getParameter("opr");
				
				PreparedStatement psUsers = conn.prepareStatement("select * from etudiant ");
				psUsers.setString(1,id);
				psUsers.setString(2,nom);
				psUsers.setString(3,prenom);
				psUsers.setString(4,classe);
				ResultSet rsUsers = psUsers.executeQuery();
		        if(rsUsers.next() ) {
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
				out.print("<h1>échec d'affichage liste </h1>");
		        }
		       /* if (operation.equals("Previous"))
				{
			
			ServletContext context = getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/listeEtudiant.jsp");
			dispatcher.forward(request, response);
				}*/
	            
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