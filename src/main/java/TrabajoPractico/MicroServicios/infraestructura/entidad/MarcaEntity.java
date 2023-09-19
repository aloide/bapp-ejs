package TrabajoPractico.MicroServicios.infraestructura.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class MarcaEntity {
	@Id
	@GeneratedValue
	private Integer id;
	private String nombre;

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}


}
