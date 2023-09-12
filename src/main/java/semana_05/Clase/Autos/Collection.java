package semana_05.Clase.Autos;

import semana_05.Clase.Autos.modelo.Auto;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Collection {

	/*
	 * Devuelve la cantidad de autos de una marca y un año determinado
	 *
	 * @param autos array de autos
	 * @param marca marca a buscar
	 * @param anio año a buscar
	 * @return cantidad de autos de una marca y un año determinado
	 */
	public static long obtenerCantidadPorMarcaYAnio(List<Auto> autos, String marca, int anio) {
		List<Auto> resultado = new ArrayList<Auto>();
		for(Auto a : autos){
			if(Objects.equals(a.getMarca(), marca) && a.getAnio() == anio)
				resultado.add(a);
		}
		return resultado.size();
	}

	/*
	 * Devuelve la cantidad de autos convertibles
	 *
	 * @param autos array de autos
	 * @return cantidad de autos convertibles
	 */
	public static long obtenerCantidadDeConvertibles(List<Auto> autos) {
		ArrayList<Auto> list = new ArrayList<>();
		for (Auto a : autos){
			if (a.getTipos().contains("Convertible")){
				list.add(a);
			}
		}
		return list.size();
	}

	/*
	 * Devuelve un array con las marcas que vendan sedanes
	 *
	 * @param autos array de autos
	 * @return array de marcas
	 */
	public static Set<String> obtenerLasMarcasQueVendanSedanes(List<Auto> autos) {
		Set<String> res = new HashSet<>();
		for(Auto a : autos){
			if(a.getTipos().contains("Sedan")){
				res.add(a.getMarca());
			}
		}
		return  res;
	}

	/*
	 * Devuelve un map con la cantidad de autos por marca
	 *
	 * @param autos array de autos
	 * @return map con la cantidad de autos por marca
	 */
	public static Map<String, Long> obtenerCantidadDeAutosPorMarca(List<Auto> autos) {

		Map<String,Long> res = new HashMap<>();

		for(Auto a : autos){
			var m = a.getMarca();

			if(res.containsKey(m)){
				var val = res.get(m);
				res.put(m,val+1);
			}
			else{
				res.put(a.getMarca(), 1L);
			}
		}

		return res;
	}

	/*
	 * Devuelve un map con la cantidad de autos por año
	 *
	 * @param autos array de autos
	 * @return map con la cantidad de autos por año
	 */
	public static Map<Integer, Long> obtenerCantidadDeAutosPorAnio(List<Auto> autos) {
		Map<Integer, Long> res = new HashMap();

		for(Auto a : autos){
			var anio = a.getAnio();

			if(res.containsKey(anio)){
				var count = res.get(anio);
				res.put(anio, count+1);
			}
			else {
				res.put(anio, 1L);
			}
		}

		return res;

	}

	/*
	 * Devuelve los autos filtrados
	 * @param autos array de autos
	 * @param filtro filtro a aplicar
	 * @return autos filtrados
	 */
	public static List<Auto> filtrarAutos(List<Auto> autos, Predicate<Auto> filtro) {

		return autos.stream().filter(filtro).toList();

	}

	/**
	 * Devuelve una lista de autos que no sean del tipo especificado
	 *
	 * @param autos array de autos
	 * @param tipo  tipo a filtrar
	 * @return lista de autos que no sean del tipo especificado
	 */
	public static List<Auto> obtenerTodosLosAutosQueNoSeanDelTipo(List<Auto> autos, String tipo) {

		return autos.stream().filter(a -> !a.getTipos().contains(tipo)).toList();

	}

	/*
	 * Obtener las marcas que tengan modelos con números en el nombre
	 * @param autos array de autos
	 * @return marcas que tengan modelos con números en el nombre
	 */
	public static Set<String> obtenerLasMarcasQueTenganModelosConNumeros(List<Auto> autos) {

		Set<String> res = new HashSet();

		// Expresión regular para verificar si el modelo contiene al menos un número

		Pattern pattern = Pattern.compile(".*\\d.*");

		for (Auto a : autos) {
			// Verifica si el modelo contiene al menos un número
			Matcher matcher = pattern.matcher(a.getModelo());
			if (matcher.matches()) {
				res.add(a.getMarca());
			}
		}

		return res;
	}

	/*
	 * Leer el archivo autos.csv y devuelve un array de autos
	 * @return array de autos
	 */
	public static List<Auto> obtenerAutos() {

		var path = "C:\\Users\\Alito\\repos\\JavaBAPP\\BackendAplicaciones\\src\\main\\java\\semana_05\\Clase\\Autos\\autos.csv";
		List<Auto> res = new ArrayList<>();

		try {
			Scanner s = new Scanner(new File(path));

			while(s.hasNext()){
				String line = s.nextLine();

				Auto a = Auto.fromString(line);

				res.add(a);

			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}


		return res;
	}
}
