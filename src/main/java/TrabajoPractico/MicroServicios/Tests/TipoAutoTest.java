package TrabajoPractico.MicroServicios.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


import TrabajoPractico.MicroServicios.dominio.modelo.*;
import TrabajoPractico.MicroServicios.dominio.repositorio.*;


public class TipoAutoTest {

	private final TipoAutoRepository tipoAutoRepository = null;

	@Test
	public void obtieneLaCantidadTiposDeAutosCorrectamente() {

		assertEquals(7, tipoAutoRepository.getAll().size());
	}

	@Test
	public void elTipoConvertibleEsCorrecto() {
		final TipoAuto tipoAutoEsperado = new TipoAuto(3, "Convertible");
		final TipoAuto tipoAuto = tipoAutoRepository
			.getAll()
			.stream()
			.filter(tipo -> tipo.getNombre().equalsIgnoreCase("Convertible"))
			.findFirst()
			.orElseThrow();
		assertEquals(tipoAutoEsperado, tipoAuto);
	}
}
