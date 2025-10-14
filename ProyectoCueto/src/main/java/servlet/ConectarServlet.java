package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexion.SqlServerConexion;

/**
 * Servlet implementation class ConectarServlet
 */
@WebServlet("/ConectarServlet")
public class ConectarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ConectarServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				 response.setContentType("text/html");
			        PrintWriter out = response.getWriter();
			    
			        try {
			            Connection con = SqlServerConexion.getConexion();
			            if (con != null) {
			                out.println("✅ Conexión exitosa a SQL Server");
			                con.close();
			            } else {
			                out.println("❌ No se pudo conectar a la base de datos");
			            }
			        } catch (Exception e) {
			            out.println("⚠️ Error: " + e.getMessage());
			        }
			        
			       // ProductoModel model = new ProductoModel();
			       //   model.suma(3, 6);
			        
			        
				response.getWriter().append("La suma es  " ).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
