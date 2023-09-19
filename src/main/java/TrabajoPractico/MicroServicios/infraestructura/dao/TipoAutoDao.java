package TrabajoPractico.MicroServicios.infraestructura.dao;

import java.util.List;
import java.util.Optional;

import TrabajoPractico.MicroServicios.infraestructura.entidad.TipoAutoEntity;

public interface TipoAutoDao {
	Optional<TipoAutoEntity> getTipoAuto(Integer id);
	List<TipoAutoEntity> findAll();
}
