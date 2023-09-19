package TrabajoPractico.MicroServicios.infraestructura.h2.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import TrabajoPractico.MicroServicios.infraestructura.dao.MarcaDao;
import TrabajoPractico.MicroServicios.infraestructura.entidad.MarcaEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class H2MarcaDao implements MarcaDao {

	@Override
	public Optional<MarcaEntity> getMarca(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("autos-db");
		EntityManager em = emf.createEntityManager();
		try{
		MarcaEntity e =  em.find(MarcaEntity.class, id);
			return Optional.ofNullable(e);
		}catch (Exception e){
			System.out.println("SUKA " + e.getMessage());
		}
		return Optional.empty();
	}

	@Override public List<MarcaEntity> findAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("autos-db");
		var manager = factory.createEntityManager();


	}
}
