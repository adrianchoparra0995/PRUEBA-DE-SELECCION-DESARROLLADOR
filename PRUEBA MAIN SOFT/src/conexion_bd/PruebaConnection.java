package conexion_bd;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * CLASE PRUEBRA CONECTION: Clase donde se realiza la conexion con la base de datos
 * por medio de MICROSOFT SQL SERVER 
 * @author ADRIAN FELIPE PARRA FIAGA - INGENIERO DE SISTEMAS 
 * Nombre bd: bartender
 * user: sa
 * password: 123
 * port: 1434 
 */
public class PruebaConnection {

	private static Connection cn; 
	
	public static Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=bartender","sa","123");
		} catch (Exception e) {
			cn = null;
		}
		return cn; 
	}
	
	/**
	 * Test Conexion 
	 * @return Connection 
	 */
	public static Connection Conectar(){
		Connection pruebaCn = PruebaConnection.getConnection();
		if(pruebaCn!=null) {
			System.out.println("Conectado");
		    System.out.println(pruebaCn);
		    
		}else{
			System.out.println("Desconectado");
		}
		return pruebaCn;
	}
	
	
}
