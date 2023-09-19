package TrabajoPractico.MicroServicios.infraestructura.h2.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import TrabajoPractico.MicroServicios.infraestructura.dao.MarcaDao;
import TrabajoPractico.MicroServicios.infraestructura.entidad.MarcaEntity;

public final class H2MarcaDao implements MarcaDao {

	@Override
	public Optional<MarcaEntity> getMarca(Integer id) {

		return Optional.empty();
	}

	@Override public List<MarcaEntity> findAll() {
		return Collections.emptyList();
	}
}
