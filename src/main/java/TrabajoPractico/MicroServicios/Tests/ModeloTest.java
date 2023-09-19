package TrabajoPractico.MicroServicios.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;


import TrabajoPractico.MicroServicios.dominio.modelo.*;
import TrabajoPractico.MicroServicios.dominio.repositorio.*;

public class ModeloTest {

	ModeloRepository modeloRepository = null;

	@Test
	public void obtieneElModeloCorrecto() {
		final Modelo modeloEsperado = new Modelo(
			50,
			"2 Series",
			2021,
			new Marca(8, "BMW"),
			List.of(
				new TipoAuto(1, "Sedan"),
				new TipoAuto(3, "Convertible"),
				new TipoAuto(6, "Coupe")
			)
		);
		final Modelo modelo = modeloRepository.get(50);

		assertEquals(modeloEsperado, modelo);
	}
}
