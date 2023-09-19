package TrabajoPractico.MicroServicios.infraestructura.dao;

import java.util.Optional;
import TrabajoPractico.MicroServicios.dominio.modelo.*;

import TrabajoPractico.MicroServicios.infraestructura.entidad.ModeloEntity;

public interface ModeloDao {
	Optional<ModeloEntity> getModelo(Integer id);
}
