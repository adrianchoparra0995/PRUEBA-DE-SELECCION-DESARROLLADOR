package run;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import conexion_bd.PruebaConnection;
import logic.LogicPrueba;

/**
 * Clase Run: clase principal donde se ejecuta el programa
 * @author ADRIAN FELIPE PARRA FIAGA - INGENIERO DE SISTEMAS 
 *
 */

public class Run {
	
	/**
	 * Metodo principal
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		Scanner reader = new Scanner(System.in);
		String cadena = "";
		Integer[] array;  
		int id = 0;
		int iteraciones = 0;
		System.out.println("-----------------CONEXION A BD------------------------------------------");
		Connection cn = PruebaConnection.Conectar();
		//LogicPrueba.getAllInfo(cn);
		System.out.println("-----------------LLAMADO A BASE DE DATOS DE VECTOR POR ID---------------");
		System.out.print("Por favor, seleccione el id del vector que desea operar: ");
		id = reader.nextInt();
		cadena = LogicPrueba.getById(cn, id);
		System.out.println("-----------------CADENA CONVERTIDA A INTEGER----------------------------");
	    array = LogicPrueba.cadena(cadena);
	    System.out.println("-----------------SOLUCION PROBLEMA----------------------------");
	    System.out.print("Por favor, seleccione la cantidad de iteraciones que desee (Q): ");
	    iteraciones = reader.nextInt();
	    System.out.println("EL RESULTADO FINAL ES: ");
		LogicPrueba.solucion(iteraciones, array);
	}
	

}
