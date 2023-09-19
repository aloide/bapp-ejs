package TrabajoPractico.MicroServicios.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import TrabajoPractico.MicroServicios.dominio.modelo.Marca;
import TrabajoPractico.MicroServicios.dominio.repositorio.MarcaRepository;

public class MarcaTest {
	private final MarcaRepository marcaRepository = null;

	@Test
	public void obtieneLaCantidadMarcasCorrectamente() {
		assertEquals(9, marcaRepository.getAll().size());
	}

	@Test
	public void laMarcaAudiEsCorrecta() {
		final Marca marcaEsperada = new Marca(6, "Audi");
		final Marca marca = marcaRepository
			.getAll()
			.stream()
			.filter(tipo -> tipo.getNombre().equalsIgnoreCase("Audi"))
			.findFirst()
			.orElseThrow();
		assertEquals(marcaEsperada, marca);
	}
}
