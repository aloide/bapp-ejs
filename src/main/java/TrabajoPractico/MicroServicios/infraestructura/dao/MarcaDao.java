package TrabajoPractico.MicroServicios.infraestructura.dao;

import java.util.List;
import java.util.Optional;

import TrabajoPractico.MicroServicios.dominio.modelo.*;


import TrabajoPractico.MicroServicios.infraestructura.entidad.MarcaEntity;

public interface MarcaDao {
	Optional<MarcaEntity> getMarca(Integer id);
	List<MarcaEntity> findAll();
}
