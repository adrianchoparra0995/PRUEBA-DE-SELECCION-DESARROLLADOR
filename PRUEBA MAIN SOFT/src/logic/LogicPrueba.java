package logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase LogicPrueba: Clase donde se encuentra la logica del programa a
 * desarrollar y sus pricipales metodos para tanto hacer el llamado desde la
 * base de datos como el tratamiento de esta informacion
 * 
 * @author ADRIAN FELIPE PARRA FIAGA - INGENIERO DE SISTEMAS
 *
 */
public class LogicPrueba {

	/**
	 * Metodo para obtener la tabla array de la bd
	 * 
	 * @param cn
	 * @throws SQLException
	 */
	public static void getAllInfo(Connection cn) throws SQLException {
		Statement st = cn.createStatement();
		ResultSet rst = st.executeQuery("select * from arrays ");
		while (rst.next()) {
			System.out.println("Id: " + rst.getInt(1) + "Vector: " + rst.getString(2));
		}

	}

	/**
	 * Metodo para obtener un arreglo de la tabla por id
	 * 
	 * @param cn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static String getById(Connection cn, int id) throws SQLException {
		String vector = "";
		Statement st = cn.createStatement();
		ResultSet rst = st.executeQuery("select * from arrays WHERE id =" + id);
		while (rst.next()) {
			vector = rst.getString(2);
			System.out.println(vector);
		}
		return vector;

	}

	/**
	 * Metodo que comvierte la cadena String en una cadena Integer
	 * 
	 * @param vector
	 * @return
	 */
	public static Integer[] cadena(String vector) {
		String separador = ",";
		String[] arreglo = vector.split(separador);
		int size = arreglo.length;
		Integer[] arr = new Integer[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(arreglo[i]);
		}
		System.out.println(Arrays.toString(arr));
		return arr;
	}

	/**
	 * Metodo el cual construye un arreglo de numeros primos
	 */
	private static final int[] arregloPrimos = new int[1201];

	static {
		final boolean[] primes = new boolean[9800];
		Arrays.fill(primes, true);
		int bound = (int) Math.sqrt(primes.length);
		for (int i = 2; i < bound; ++i) {
			if (primes[i])
				for (int j = i + i; j < primes.length; j += i)
					primes[j] = false;
		}

		int j = 0;
		for (int i = 2; i < primes.length; ++i) {
			if (primes[i]) {
				LogicPrueba.arregloPrimos[j++] = i;
			}
			if (j >= LogicPrueba.arregloPrimos.length)
				break;
		}
	}

	/**
	 * Metodo por el cual se soluciona el problema
	 * 
	 * @param Q numero de iteraciones
	 * @param A arreglo vacio
	 */
	public static void solucion(int Q, Integer[] A) {
		ArrayList<Integer> A0 = new ArrayList<Integer>();
		for (int e : A)
			A0.add(e);
		List<ArrayList<Integer>> AList = new ArrayList<>(Q);
		AList.add(A0);
		List<ArrayList<Integer>> BList = new ArrayList<>();

		for (int i = 1; i <= Q; ++i) {
			ArrayList<Integer> list = AList.get(i - 1);
			ArrayList<Integer> nextAList = new ArrayList<Integer>();
			ArrayList<Integer> nextBList = new ArrayList<Integer>();
			int ithPrime = arregloPrimos[i - 1];
			while (!list.isEmpty()) {
				int e = list.remove(list.size() - 1);
				if (e % ithPrime == 0)
					nextBList.add(e);
				else
					nextAList.add(e);
			}

			BList.add(nextBList);
			if (nextAList.size() == 0)
				break;
			AList.add(nextAList);

		}

		for (int i = 0; i < BList.size(); ++i) {
			ArrayList<Integer> ListB = BList.get(i);
			while (!ListB.isEmpty())
				System.out.println(ListB.remove(ListB.size() - 1));
		}
		ArrayList<Integer> ListA = AList.get(AList.size() - 1);
		while (!ListA.isEmpty())
			System.out.println(ListA.remove(ListA.size() - 1));

	}

}
