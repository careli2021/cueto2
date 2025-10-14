package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServerConexion {
	
	public static int suma (int a, int b,int c)
	{
		int x=a+2*b+c;
		
		return x  ;
	}
	
    public static double promedio (int n1,int n2, int n3)
    {
    	double prom=0;
    	
    	prom = (n1+n2+n3)/3.00; 
    	
    	return prom;
    }
	
	public static String pedro()
    {
    	String  c ="hola mundo";
    	return c;
    	
    }
    public static double juan()
    {
    double 	p= 12.5; 
       	return p;
    }
    public static int menos (int a ,int b )
	{
		int z= a-b;
		return z;
	}
	
    public static Connection getConexion() {
        Connection con = null;
        try {
            // Cargar el driver de SQL Server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // URL de conexión a SQL Server
            // Ajusta el puerto, el nombre de la base de datos, usuario y contraseña
         //   String url = "jdbc:sqlserver://localhost:1433;databaseName=cueto2025;encrypt=true;trustServerCertificate=true";
          //  String usr = "sa";       // tu usuario de SQL Server
          //  String psw = "Careli24";    // tu contraseña
            
         String url = "jdbc:sqlserver://Cueto2025.mssql.somee.com:1433;"
                    + "databaseName=Cueto2025;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
         String usr = "careli_SQLLogin_1";
         String psw = "fvfjljis7c";

         

            // Crear la conexión
            con = DriverManager.getConnection(url, usr, psw);

        } catch (ClassNotFoundException e) {
            System.out.println("Error >> driver no instalado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error >> de conexión con la BD: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error >> general: " + e.getMessage());
        }
        return con;
    }

    public static void closeConexion(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Problemas al cerrar la conexión");
        }
    }
}
